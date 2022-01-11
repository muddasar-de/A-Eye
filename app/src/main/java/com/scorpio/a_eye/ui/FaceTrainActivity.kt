package com.scorpio.a_eye.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.util.SparseIntArray
import android.view.Surface
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.ActivityFaceTrainBinding
import com.scorpio.a_eye.services.ApiConfig
import com.scorpio.a_eye.services.AppConfig
import com.scorpio.a_eye.services.ServerResponse
import com.scorpio.a_eye.ui.fragment.MainFragment
import com.scorpio.a_eye.utils.Draw
import com.scorpio.a_eye.voiceutils.VoiceAssistant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.scorpio.a_eye.model.Guide
import com.scorpio.a_eye.viewmodel.AppViewModel


class FaceTrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaceTrainBinding

    private var imageCapture: ImageCapture? = null
    private lateinit var cameraExecutor: ExecutorService
    private var cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
    private val ORIENTATIONS = SparseIntArray()

    private val progressDialog: ProgressDialog by lazy { ProgressDialog(this) }

    var storage = FirebaseStorage.getInstance()

    private val auth = Firebase.auth
    private val database = FirebaseFirestore.getInstance()

    private var guideEmail: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaceTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        guideEmail = intent.getStringExtra("guideEmail") ?: ""

        init()
        initListeners()
    }

    private fun init() {
        progressDialog.setMessage("Processing, Please wait...")
        progressDialog.setCancelable(false)
        val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)
        Permissions.check(this/*context*/, permissions, null /*rationale*/, null /*options*/, object : PermissionHandler() {
            override fun onGranted() {
                startCamera()
            }
        })
    }

    @SuppressLint("RestrictedApi")
    private fun initListeners() {
        with(binding) {
            btnBack.setOnClickListener { finish() }
            btnCapture.setOnClickListener {
                var name = ""
                with(personName) {
                    name = text.trim().toString()
                    if (name.isEmpty()) {
                        error = "Enter Person Name Here..."
                        requestFocus()
                        return@setOnClickListener
                    }
                }
                progressDialog.show()
                captureImage(name)

            }
            btnSwitchCamera.setOnClickListener {
                cameraSelector = if (cameraSelector.lensFacing == 1) {
                    CameraSelector.DEFAULT_FRONT_CAMERA
                } else {
                    CameraSelector.DEFAULT_BACK_CAMERA
                }
                startCamera()
            }
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            imageCapture = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY).build()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.previewView.surfaceProvider)
                }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture
                )
            } catch (exc: Exception) {
                Log.e("TAG", "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    private fun captureImage(personName: String) {
        val imageCapture = imageCapture ?: return
        imageCapture.targetRotation = Surface.ROTATION_0

        imageCapture.takePicture(ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageCapturedCallback() {
                override fun onCaptureSuccess(image: ImageProxy) {
                    super.onCaptureSuccess(image)
                    val bitmap = decodeBitmap(image) ?: return
                    CoroutineScope(Dispatchers.IO).launch {
                        firebaseUploadBitmap(bitmap)
                    }
                    val base64String = convert(bitmap)?.replace("\n", "")
                    Log.i("TAG", "onSuccess: $base64String")

                    if (base64String != null) {
                        sendRequestToAPI(base64String, personName)
                    } else {
                        Toast.makeText(this@FaceTrainActivity, "Unable to capture image.", Toast.LENGTH_SHORT).show()
                        progressDialog.dismiss()
                    }
                    Log.e("TAG", "Photo captured")
                }
            })
    }

    private fun sendRequestToAPI(base64String: String, personName: String) {
        val appConfig = AppConfig().buildService(ApiConfig::class.java)
        appConfig.faceAdd(base64String)?.enqueue(
            object : retrofit2.Callback<ServerResponse?> {
                override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                    Log.i("TAG", "onResponse: true, face Add ${response.body()?.getMessage()}")
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(4000)
                        appConfig.faceName(personName)?.enqueue(
                            object : retrofit2.Callback<ServerResponse?> {
                                override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                                    Log.i("TAG", "onResponse: true, name Add ${response.body()?.getMessage()}")
                                    Toast.makeText(this@FaceTrainActivity, "Image and name saved successfully.", Toast.LENGTH_SHORT).show()
                                    progressDialog.dismiss()
                                }

                                override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                                    Toast.makeText(this@FaceTrainActivity, "Some Error Occurred.", Toast.LENGTH_SHORT).show()
                                    progressDialog.dismiss()
                                }
                            }
                        )
                    }
                }

                override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                    Toast.makeText(this@FaceTrainActivity, "Some Error Occurred.", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
        )
    }

    fun convert(bitmap: Bitmap): String? {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        return android.util.Base64.encodeToString(outputStream.toByteArray(), android.util.Base64.DEFAULT)
    }

    fun decodeBitmap(image: ImageProxy): Bitmap? {
        val buffer = image.planes[0].buffer
        val bytes = ByteArray(buffer.capacity()).also { buffer.get(it) }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    private fun firebaseUploadBitmap(bitmap: Bitmap) {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val data = stream.toByteArray()
        val imageStorage = storage.reference
        val imageRef = imageStorage.child("training_images/" + "${UUID.randomUUID()}.png")
        val urlTask: Task<Uri?> = imageRef.putBytes(data).continueWithTask { task: Task<UploadTask.TaskSnapshot?> ->
            if (!task.isSuccessful) {
                Log.i("myFirebaseTest", "firebaseUploadBitmap: 1")
                throw task.exception
            }
            Log.i("myFirebaseTest", "firebaseUploadBitmap: 2 ${imageRef.downloadUrl.result.path}")
            imageRef.downloadUrl

        }.addOnCompleteListener { task: Task<Uri?> ->
            if (task.isSuccessful) {
                Log.i("myFirebaseTest", "firebaseUploadBitmap: 3 ${imageRef.downloadUrl.result.path}")
                /*database.collection("users").document(guideEmail).update("faces", mutableListOf<String>(imageRef.downloadUrl.result.path.toString())).addOnCompleteListener {

                              }.addOnFailureListener {
                                  Log.i("ViewModelTag", "add data error->", it)
                              }*/
            } else {
                // Handle failures
                // ...
            }
        }
    }
}