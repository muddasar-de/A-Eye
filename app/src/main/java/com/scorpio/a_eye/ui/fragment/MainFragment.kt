package com.scorpio.a_eye.ui.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.bumptech.glide.Glide
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentMainBinding
import com.scorpio.a_eye.ui.MainActivity

import com.scorpio.a_eye.ui.VoiceAssistant
import okhttp3.OkHttpClient
import java.io.File
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    private var imageCapture: ImageCapture? = null

    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private var cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

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
        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()

        Permissions.check(requireContext(), Manifest.permission.CAMERA, null, object : PermissionHandler() {
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
//            contentMain.btnCapture.setOnClickListener{scanImage()}
            drawerMain.btnClose.setOnClickListener { drawerLayout.closeDrawer(GravityCompat.START) }

            contentMain.bottomOcr.setOnClickListener { appViewModel.currentScanningType.postValue(0) }
            contentMain.bottomPeople.setOnClickListener { appViewModel.currentScanningType.postValue(1) }
            contentMain.bottomMoney.setOnClickListener { appViewModel.currentScanningType.postValue(2) }
            contentMain.bottomHome.setOnClickListener { appViewModel.currentScanningType.postValue(3) }
            contentMain.bottomColors.setOnClickListener { appViewModel.currentScanningType.postValue(4) }
            contentMain.bottomBarcode.setOnClickListener { appViewModel.currentScanningType.postValue(5) }
            contentMain.bottomStreetView.setOnClickListener { appViewModel.currentScanningType.postValue(6) }
        }
    }

    private fun initObservers() {
        appViewModel.currentUser.observe(viewLifecycleOwner) {
            if (it == null) {
                with(binding.drawerMain) {
                    layoutHistory.visibility = View.GONE
                    layoutSettings.visibility = View.GONE
                    groupHeader.visibility = View.GONE
                    notLoginHeading.visibility = View.VISIBLE
                    notLoginIcon.visibility = View.VISIBLE
                    txtLogin.text = StringBuilder().append("Login")
                }
            } else {
                with(binding.drawerMain) {
                    layoutHistory.visibility = View.VISIBLE
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
            with(binding.contentMain) {
                bottomOcr.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomPeople.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomMoney.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomHome.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomColors.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomBarcode.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                bottomStreetView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))


                when (it) {
                    0 -> {
                        bottomOcr.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        binding.contentMain.btnCapture.setOnClickListener{
                            VoiceAssistant.announceCurrentCall(requireContext(), "OCR is enabled")
                            captureImage()
                            VoiceAssistant.announceCurrentCall(requireContext(), "Picture is Captured")

                        }
                    }
                    1 -> {
                        bottomPeople.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        VoiceAssistant.announceCurrentCall(requireContext(), "Face Detection is enabled")
                    }
                    2 -> {
                        bottomMoney.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        VoiceAssistant.announceCurrentCall(requireContext(), "Currency Detection is enabled")
                    }
                    3 -> {
                        bottomHome.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        VoiceAssistant.announceCurrentCall(requireContext(), "Object Detection is enabled")
                    }
                    4 -> {
                        bottomColors.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        VoiceAssistant.announceCurrentCall(requireContext(), "Color Detection is enabled")
                    }
                    5 -> {
                        bottomBarcode.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        VoiceAssistant.announceCurrentCall(requireContext(), "QR code Detection is enabled")
                    }
                    6 -> {
                        bottomStreetView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.icon_selected))
                        VoiceAssistant.announceCurrentCall(requireContext(), "Scene Detection is enabled")
                    }
                }
            }
        }
    }

    private fun initDrawerListeners() {
        with(binding.drawerMain) {
            layoutHistory.setOnClickListener {
                navigateToFragment(R.id.action_mainFragment_to_historyFragment, R.id.historyFragment)
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

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            imageCapture = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY).build()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.contentMain.previewView.surfaceProvider)
                }

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture
                )

            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

//    private fun uploadFile() {
//        if (postPath == null || postPath == "") {
//            Toast.makeText(this, "please select an image ", Toast.LENGTH_LONG).show()
//            return
//        } else {
//            showpDialog()
//
//            // Map is used to multipart the file using okhttp3.RequestBody
//            val map = HashMap<String, RequestBody>()
//            val file = File(postPath!!)
//
//            // Parsing any Media type file
//            val requestBody = RequestBody.create(MediaType.parse("/"), file)
//            map.put("file\"; filename=\"" + file.name + "\"", requestBody)
//            val getResponse = AppConfig.getRetrofit().create(ApiConfig::class.java)
//            val call = getResponse.upload("token", map)
//            call.enqueue(object : Callback<ServerResponse> {
//                override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
//                    if (response.isSuccessful) {
//                        if (response.body() != null) {
//                            hidepDialog()
//                            val serverResponse = response.body()
//                            Toast.makeText(applicationContext, serverResponse.message, Toast.LENGTH_SHORT).show()
//
//                        }
//                    } else {
//                        hidepDialog()
//                        Toast.makeText(applicationContext, "problem uploading image", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
//                    hidepDialog()
//                    Log.v("Response gotten is", t.message)
//                }
//            })
//        }
//    }


    private fun captureImage() {
        val imageCapture = imageCapture ?: return
        imageCapture.targetRotation = Surface.ROTATION_0

        val photoFile = File(
            outputDirectory,
            SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".png"
        )

        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(requireContext()),
            object : ImageCapture.OnImageSavedCallback {
                @SuppressLint("RestrictedApi")
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    showToast("Image Captured")
                    Log.i("stuts","Succcess1")
          val data :Bundle = Bundle()

         data.putString("PhotoPath", photoFile.absolutePath)
        val caputuredImage:capturedImageViewFragment = capturedImageViewFragment()
           caputuredImage.arguments = data
        fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,caputuredImage)?.commit()

//                    performOperationAfterScan(imageCapture)
                    Log.e(TAG, "Photo captured ")
                }

                override fun onError(exc: ImageCaptureException) {
                    Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
                }
            }
        )
        // send photo file to capturedImageFragment
//
    }


    private fun getOutputDirectory(): File {
        val mediaDir = requireActivity().externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else requireContext().filesDir
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
    }
}