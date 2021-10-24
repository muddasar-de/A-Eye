package com.scorpio.a_eye.ui

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.*


object PerformOperations {
    var t1: TextToSpeech? = null
    fun announceCurrentCall(context: Context, textToSpeak: String) {
//        Toast.makeText(context, "Speech Check", Toast.LENGTH_LONG).show()

        t1 = TextToSpeech(
            context
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                t1!!.language = Locale.getDefault()
                t1!!.setSpeechRate(1F)

                val handler = Handler(Looper.getMainLooper()!!)
                handler.postDelayed(Runnable {
                    t1!!.speak(
                        textToSpeak,
                        TextToSpeech.QUEUE_FLUSH,
                        null, ""

                    )
                    Toast.makeText(context, "Speech No Error", Toast.LENGTH_LONG).show()
                }, 1000)

            }
        }
    }


}