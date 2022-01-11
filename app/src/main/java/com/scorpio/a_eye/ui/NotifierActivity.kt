package com.scorpio.a_eye.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scorpio.a_eye.voiceutils.VoiceAssistant

class NotifierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MyAlarmBelal", "Notifier Activity")
        val string = intent.getStringExtra("message") ?: "No message found"

        VoiceAssistant.announceCurrentCall(this, string)
    }
}