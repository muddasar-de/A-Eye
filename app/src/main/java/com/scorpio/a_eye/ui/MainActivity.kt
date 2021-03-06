package com.scorpio.a_eye.ui

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.scorpio.a_eye.databinding.ActivityMainBinding
import com.scorpio.a_eye.databinding.DialogLoadingBinding
import com.scorpio.a_eye.viewmodel.AppViewModel
import com.scorpio.a_eye.voiceutils.VoiceAssistant

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var firebaseAuth: FirebaseAuth

    private lateinit var appViewModel: AppViewModel

    private val loadingDialog by lazy { Dialog(this) }
    private val loadingBinding by lazy { DialogLoadingBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appViewModel = ViewModelProvider(this)[AppViewModel::class.java]

        firebaseAuth = Firebase.auth
        if (firebaseAuth.currentUser != null) {
            appViewModel.getUserData(firebaseAuth.currentUser?.email ?: "")
        } else {

        }

    }

    fun showHideLoadingDialog(show: Boolean) {
        loadingDialog.setCancelable(false)
        loadingDialog.setContentView(loadingBinding.root)

        loadingDialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        loadingDialog.window?.setBackgroundDrawable(ContextCompat.getDrawable(this, android.R.color.transparent))
        if (show)
            loadingDialog.show()
        else
            loadingDialog.dismiss()
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        val action = event.action
        return when (event.keyCode) {
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                if (action == KeyEvent.ACTION_DOWN) {
                    appViewModel.captureImagePressed.postValue(true)
                }
                true
            }
            KeyEvent.KEYCODE_VOLUME_UP -> {
                if (VoiceAssistant.appViewModel == null)
                    VoiceAssistant.appViewModel = appViewModel
                VoiceAssistant.startListening(applicationContext)
                true
            }
            else -> super.dispatchKeyEvent(event)
        }
    }
}