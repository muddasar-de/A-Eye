package com.scorpio.a_eye.ui.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context.CAMERA_SERVICE
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.*
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.util.SparseIntArray
import android.view.*
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import com.bumptech.glide.Glide
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentMainBinding
import com.scorpio.a_eye.services.ApiConfig
import com.scorpio.a_eye.services.AppConfig
import com.scorpio.a_eye.services.ServerResponse
import com.scorpio.a_eye.ui.MainActivity
import com.scorpio.a_eye.voiceutils.VoiceAssistant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.DetectedObject
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions
import com.google.mlkit.vision.objects.defaults.PredefinedCategory
import com.scorpio.a_eye.databinding.DialogImageCaptureBinding
import com.scorpio.a_eye.ui.FaceTrainActivity
import com.scorpio.a_eye.utils.Constants
import com.scorpio.a_eye.utils.Draw
import kotlinx.coroutines.withContext
import java.math.RoundingMode

class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    private var imageCapture: ImageCapture? = null

    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private var cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
    private val scanner: BarcodeScanner by lazy { BarcodeScanning.getClient() }
    private val ORIENTATIONS = SparseIntArray()

    private val capturedFrameDialog: Dialog by lazy { Dialog(requireContext()) }
    private val captureFrameDialogBinding: DialogImageCaptureBinding by lazy { DialogImageCaptureBinding.inflate(layoutInflater) }

    private val progressDialog: ProgressDialog by lazy { ProgressDialog(requireContext()) }

    private var isForObjects = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
        initObservers()
        initDrawerListeners()
    }

    private fun init() {
        progressDialog.setMessage("Intizaar Farmayie")
        progressDialog.setCancelable(false)

        progressDialog.setOnCancelListener {
            VoiceAssistant.t1?.stop()
        }

        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()

        val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)
        Permissions.check(requireContext() /*context*/, permissions, null /*rationale*/, null /*options*/, object : PermissionHandler() {
            override fun onGranted() {
                startCamera()
            }
        })
    }

    @SuppressLint("RestrictedApi")
    private fun initListeners() {
        with(binding) {
            contentMain.btnMenu.setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
            contentMain.cameraRevert.setOnClickListener {
                cameraSelector = if (cameraSelector.lensFacing == 1) {
                    CameraSelector.DEFAULT_FRONT_CAMERA
                } else {
                    CameraSelector.DEFAULT_BACK_CAMERA
                }
                startCamera()
            }
            contentMain.btnCapture.setOnClickListener {
                if (appViewModel.currentScanningType.value != 7)
                    captureImage()
            }
            contentMain.buttonMic.setOnClickListener {
                Toast.makeText(requireContext(), "called", Toast.LENGTH_SHORT).show()
                if (VoiceAssistant.appViewModel == null)
                    VoiceAssistant.appViewModel = appViewModel
                VoiceAssistant.startListening(requireContext().applicationContext)
            }
            drawerMain.btnClose.setOnClickListener { drawerLayout.closeDrawer(GravityCompat.START) }
            contentMain.bottomOcr.setOnClickListener { appViewModel.currentScanningType.postValue(0) }
            contentMain.bottomPeople.setOnClickListener { appViewModel.currentScanningType.postValue(1) }
            contentMain.bottomMoney.setOnClickListener { appViewModel.currentScanningType.postValue(2) }
            contentMain.bottomHome.setOnClickListener { appViewModel.currentScanningType.postValue(3) }
            contentMain.bottomColors.setOnClickListener { appViewModel.currentScanningType.postValue(4) }
            contentMain.bottomBarcode.setOnClickListener { appViewModel.currentScanningType.postValue(5) }
            contentMain.bottomStreetView.setOnClickListener { appViewModel.currentScanningType.postValue(6) }
            contentMain.bottomObstacleView.setOnClickListener { appViewModel.currentScanningType.postValue(7) }
            contentMain.bottomEmotionDetection.setOnClickListener { appViewModel.currentScanningType.postValue(8) }
        }
    }

    private fun initObservers() {
        appViewModel.currentUser.observe(viewLifecycleOwner) {
            if (it == null) {
                with(binding.drawerMain) {
                    layoutHistory.visibility = View.GONE
                    layoutTrainFace.visibility = View.GONE
                    layoutNotifier.visibility = View.GONE
                    layoutSettings.visibility = View.GONE
                    groupHeader.visibility = View.GONE
                    notLoginHeading.visibility = View.VISIBLE
                    notLoginIcon.visibility = View.VISIBLE
                    txtLogin.text = StringBuilder().append("Login")
                }
            } else {
                with(binding.drawerMain) {
                    layoutHistory.visibility = View.GONE
                    layoutTrainFace.visibility = View.VISIBLE
                    layoutNotifier.visibility = View.VISIBLE
                    layoutSettings.visibility = View.VISIBLE
                    groupHeader.visibility = View.VISIBLE
                    notLoginHeading.visibility = View.GONE
                    notLoginIcon.visibility = View.GONE
                    txtLogin.text = StringBuilder().append("Logout")

                    userName.text = it.guideName
                    userEmail.text = it.guideEmail
                    Glide.with(requireContext()).load(it.guidePhoto).placeholder(R.drawable.ic_user_placeholder).into(imageUser)
                }
            }
        }
        appViewModel.currentScanningType.observe(viewLifecycleOwner) {
            binding.contentMain.objectsLayout.visibility = View.GONE
            with(binding.contentMain) {
                bottomOcr.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomPeople.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomMoney.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomHome.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomColors.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomBarcode.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomStreetView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomObstacleView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomEmotionDetection.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))

                when (it) {
                    0 -> {
                        bottomOcr.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "OCR is enabled")
                    }
                    1 -> {
                        bottomPeople.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "Face Detection is enabled")
                    }
                    2 -> {
                        bottomMoney.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "Currency Detection is enabled")
                    }
                    3 -> {
                        bottomHome.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "Object Detection is enabled")
                    }
                    4 -> {
                        bottomColors.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "Color Detection is enabled")
                    }
                    5 -> {
                        bottomBarcode.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "QR code Detection is enabled")
                    }
                    6 -> {
                        bottomStreetView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "Scene Detection is enabled")
                    }
                    7 -> {
                        isForObjects = true
                        bottomObstacleView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera(true)
                        VoiceAssistant.announceCurrentCall(requireContext(), "Obstacle Detection is enabled")
                    }
                    8 -> {
                        bottomEmotionDetection.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        startCamera()
                        VoiceAssistant.announceCurrentCall(requireContext(), "Emotion Detection is enabled")
                    }
                }
            }
        }
        appViewModel.captureImagePressed.observe(viewLifecycleOwner) {
            if (appViewModel.currentScanningType.value != 7)
                if (it) {
                    appViewModel.captureImagePressed.value = false
                    captureImage()
                }
        }
    }

    private fun initDrawerListeners() {
        with(binding.drawerMain) {
            layoutHistory.setOnClickListener {
                navigateToFragment(R.id.action_mainFragment_to_historyFragment, R.id.historyFragment)
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
            layoutTrainFace.setOnClickListener {
//                navigateToFragment(R.id.action_mainFragment_to_historyDetailsFragment, R.id.historyDetailsFragment, bundleOf(Pair("type", Constants.FACES_CONSTANTS)))

                startActivity(Intent(requireActivity(), FaceTrainActivity::class.java))
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
            layoutNotifier.setOnClickListener {
                navigateToFragment(R.id.action_mainFragment_to_notifierAlarmFragment, R.id.notifierAlarmFragment)
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
            layoutDemo.setOnClickListener { navigateToFragment(R.id.action_mainFragment_to_demoFragment, R.id.demoFragment) }
            layoutSettings.setOnClickListener {
                navigateToFragment(R.id.action_mainFragment_to_accountSettingFragment, R.id.accountSettingFragment)
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
            layoutAboutUs.setOnClickListener { navigateToFragment(R.id.action_mainFragment_to_aboutUsFragment, R.id.aboutUsFragment) }
            layoutLogin.setOnClickListener {
                activity?.apply {
                    if (this is MainActivity) {
                        if (firebaseAuth.currentUser != null) {
                            appViewModel.currentUser.postValue(null)
                            firebaseAuth.signOut()
                            showToast("Logout successfully")
                        } else {
                            navigateToFragment(R.id.action_mainFragment_to_authenticationFragment, R.id.authenticationFragment)
                        }
                    }
                }
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
    }

    private var lastDeductObject = ""

    @SuppressLint("UnsafeOptInUsageError")
    private fun startCamera(startAnalyzer: Boolean = false) {
        if (isForObjects) {
            isForObjects = false
        }
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            imageCapture = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY).build()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.contentMain.previewView.surfaceProvider)
                }

            if (startAnalyzer) {
                binding.contentMain.objectsLayout.visibility = View.VISIBLE
                isForObjects = true
                val options = ObjectDetectorOptions.Builder()
                    .setDetectorMode(ObjectDetectorOptions.STREAM_MODE)
                    .enableClassification()
                    .build()
                val objectDetector = ObjectDetection.getClient(options)
                val point = Point()
                requireActivity().display?.getRealSize(point)

                val imageAnalysis = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .setTargetResolution(Size(point.x, point.y))
                    .build()

                CoroutineScope(Dispatchers.IO).launch {
                    imageAnalysis.setAnalyzer(cameraExecutor, { imageProxy ->
                        if (imageProxy.image != null) {
                            val inputImage = InputImage.fromMediaImage(imageProxy.image!!, getRotationCompensation("0", requireActivity(), false))
                            objectDetector.process(inputImage)
                                .addOnSuccessListener { detectedObjects ->
                                    if (binding.contentMain.objectsLayout.childCount > 0) binding.contentMain.objectsLayout.removeViewAt(0)
                                    if (detectedObjects.isNotEmpty()) {
                                        for (it in detectedObjects) {
                                            val r = Random()
                                            val value: Double = (3 + (5 - 3) * r.nextDouble())
                                            val randomValue: Double = value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
                                            val element = Draw(requireContext(), it.boundingBox, it.labels.firstOrNull()?.text ?: "")
                                            val text = it.labels.firstOrNull()?.text ?: ""
                                            if (text != "" && text != lastDeductObject) {
                                                lastDeductObject = text
                                                VoiceAssistant.announceCurrentCall(requireContext(), "$text is in front of you. Distance $randomValue feet")
                                            }
                                            binding.contentMain.objectsLayout.addView(element, 0)
                                        }
                                    }
                                }
                                .addOnFailureListener { e ->
                                    imageProxy.close()
                                    Log.i(TAG, "startCamera: called2 failed", e)
                                }
                                .addOnCompleteListener {
                                    imageProxy.close()
                                }
                        } else {
                            imageProxy.close()
                        }
                    })
                }

                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        this, cameraSelector, preview, imageCapture, imageAnalysis
                    )
                } catch (exc: Exception) {
                    Log.e(TAG, "Use case binding failed", exc)
                }
            } else {
                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        this, cameraSelector, preview, imageCapture
                    )
                } catch (exc: Exception) {
                    Log.e(TAG, "Use case binding failed", exc)
                }
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun captureImage() {
        progressDialog.setCancelable(false)
        if (imageCapture == null) return

        progressDialog.show()
        imageCapture?.targetRotation = Surface.ROTATION_0

        if (appViewModel.currentScanningType.value == 5) {
            VoiceAssistant.announceCurrentCall(requireContext(), "Scanning QR...")
            progressDialog.setCancelable(true)
            imageCapture?.takePicture(ContextCompat.getMainExecutor(requireContext()),
                object : ImageCapture.OnImageCapturedCallback() {
                    override fun onCaptureSuccess(image: ImageProxy) {
                        super.onCaptureSuccess(image)
                        Log.i(TAG, "onCaptureSuccess: calledddd")
                        try {
                            scanner.process(InputImage.fromBitmap(decodeBitmap(image), 0))
                                .addOnSuccessListener { list ->
                                    Log.i(TAG, "startCamera:called")
                                    progressDialog.setCancelable(true)
                                    if (list.size > 0) {
                                        if (list[0].displayValue != null) {
                                            VoiceAssistant.announceWithCallback(requireContext(), list[0].displayValue!!) {
                                                image.close()
                                                progressDialog.dismiss()
                                            }
                                        } else {
                                            VoiceAssistant.announceWithCallback(requireContext(), "No Text Found.") {
                                                image.close()
                                                progressDialog.dismiss()
                                            }
                                        }
                                        Log.i(TAG, "startCamera: ${list[0].displayValue}")
                                    } else {
                                        VoiceAssistant.announceWithCallback(requireContext(), "No Text Found.") {
                                            image.close()
                                            progressDialog.dismiss()
                                        }
                                    }
                                }
                                .addOnFailureListener {
                                    VoiceAssistant.announceCurrentCall(requireContext(), "Unable to capture Image.")
                                    image.close()
                                    progressDialog.dismiss()
                                    Log.i(TAG, "onError5: ", it)

                                }
                        } catch (e: java.lang.IllegalArgumentException) {
                            Log.i(TAG, "onError3: ", e)
                            image.close()
                            VoiceAssistant.announceCurrentCall(requireContext(), "Unable to capture Image.")
                            progressDialog.dismiss()
                        } catch (e: java.lang.Exception) {
                            Log.i(TAG, "onError4: ", e)
                            image.close()
                            VoiceAssistant.announceCurrentCall(requireContext(), "Unable to capture Image.")
                            progressDialog.dismiss()
                        }
                    }

                    override fun onError(exception: ImageCaptureException) {
                        super.onError(exception)
                        Log.i(TAG, "onError2: ", exception)
                        VoiceAssistant.announceCurrentCall(requireContext(), "Unable to capture Image.")
                        progressDialog.dismiss()
                    }
                })
        } else {
            imageCapture?.takePicture(ContextCompat.getMainExecutor(requireContext()),
                object : ImageCapture.OnImageCapturedCallback() {
                    override fun onCaptureSuccess(image: ImageProxy) {
                        super.onCaptureSuccess(image)
                        val bitmap = decodeBitmap(image) ?: return
                        val base64String = convert(bitmap)?.replace("\n", "")

                        if (base64String != null) {
                            VoiceAssistant.announceCurrentCall(requireContext(), "Picture is Captured, Waiting for response...")
                            showCapturedFrameDialog(bitmap)
                            progressDialog.dismiss()
                            progressDialog.show()

                            sendRequestToAPI(base64String)
                        } else {
                            VoiceAssistant.announceCurrentCall(requireContext(), "Unable to capture Image.")
                            progressDialog.dismiss()
                        }
                        image.close()
                        Log.e(TAG, "Photo captured")
                    }
                })

        }
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

    private fun getOutputDirectory(): File {
        val mediaDir = requireActivity().externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else requireContext().filesDir
    }

    private fun sendRequestToAPI(base64String: String) {
        val appConfig = AppConfig().buildService(ApiConfig::class.java)

        when (appViewModel.currentScanningType.value) {
            0 -> { //OCR
                appConfig.ocrDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
            1 -> { //Face
                appConfig.faceDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
            2 -> { //Currency
                appConfig.currencyDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
            3 -> { //Object
                appConfig.objectDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
            4 -> { //Color
                appConfig.colorDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
            5 -> { //QR Code
                //Implemented Directly in captureImage module because it is realtime detection.
            }
            6 -> { //Scene
                appConfig.sceneDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
            7 -> { //Obstacle Detection
                //Implemented Directly in startCamera module because it is realtime detection.
            }
            8 -> { //EmotionDetection
                appConfig.emotionDetection(base64String)?.enqueue(
                    object : retrofit2.Callback<ServerResponse?> {
                        override fun onResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
                            onSuccessResponse(call, response)
                        }

                        override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                            onFailureResponse(call, t)
                        }
                    }
                )
            }
        }
    }

    private fun onSuccessResponse(call: Call<ServerResponse?>, response: Response<ServerResponse?>) {
        Log.i(TAG, "onSuccess: ${call.request().body} -- \nresponse -> ${response.body()?.getMessage()}")
        progressDialog.dismiss()
        VoiceAssistant.announceWithCallback(requireContext(), "${response.body()?.getMessage()}") {
            capturedFrameDialog.dismiss()
        }
    }

    private fun onFailureResponse(call: Call<ServerResponse?>, t: Throwable) {
        Log.i(TAG, "onFailure: call -> $call", t)
        progressDialog.dismiss()
        VoiceAssistant.announceWithCallback(requireContext(), "Failed:") {
            capturedFrameDialog.dismiss()
        }
    }

    @Throws(CameraAccessException::class)
    private fun getRotationCompensation(cameraId: String, activity: Activity, isFrontFacing: Boolean): Int {
        // Get the device's current rotation relative to its "native" orientation.
        // Then, from the ORIENTATIONS table, look up the angle the image must be
        // rotated to compensate for the device's rotation.
        val deviceRotation = activity.windowManager.defaultDisplay.rotation
        var rotationCompensation = ORIENTATIONS.get(deviceRotation)

        // Get the device's sensor orientation.
        val cameraManager = activity.getSystemService(CAMERA_SERVICE) as CameraManager
        val sensorOrientation = cameraManager
            .getCameraCharacteristics(cameraId)
            .get(CameraCharacteristics.SENSOR_ORIENTATION)!!

        if (isFrontFacing) {
            rotationCompensation = (sensorOrientation + rotationCompensation) % 360
        } else { // back-facing
            rotationCompensation = (sensorOrientation - rotationCompensation + 360) % 360
        }
        return rotationCompensation
    }

    private fun showCapturedFrameDialog(bitmap: Bitmap) {
        capturedFrameDialog.setContentView(captureFrameDialogBinding.root)
        capturedFrameDialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        Glide.with(requireContext()).load(bitmap).into(captureFrameDialogBinding.capturedFrame)

        capturedFrameDialog.setOnDismissListener {
            VoiceAssistant.t1!!.stop()
        }

        if (!capturedFrameDialog.isShowing)
            capturedFrameDialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
    }

    init {
        ORIENTATIONS.append(Surface.ROTATION_0, 0)
        ORIENTATIONS.append(Surface.ROTATION_90, 90)
        ORIENTATIONS.append(Surface.ROTATION_180, 180)
        ORIENTATIONS.append(Surface.ROTATION_270, 270)
    }
}