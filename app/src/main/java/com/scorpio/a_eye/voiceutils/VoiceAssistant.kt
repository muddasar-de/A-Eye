package com.scorpio.a_eye.voiceutils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import java.util.*
import android.speech.SpeechRecognizer

import android.speech.RecognizerIntent

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import com.scorpio.a_eye.viewmodel.AppViewModel
import kotlin.collections.ArrayList

@SuppressLint("StaticFieldLeak")
object VoiceAssistant : RecognitionListener {
    private const val TAG = "RecognitionListenerTest"
    var t1: TextToSpeech? = null
    var appViewModel: AppViewModel? = null
    var sr: SpeechRecognizer? = null

    var mContext: Context? = null

    fun announceCurrentCall(context: Context, textToSpeak: String) {
        t1 = TextToSpeech(
            context
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                t1?.language = Locale.getDefault()
                t1?.setSpeechRate(0.8F)

                val handler = Handler(Looper.getMainLooper()!!)
                handler.postDelayed({
                    t1?.speak(
                        textToSpeak,
                        TextToSpeech.QUEUE_FLUSH,
                        null, ""
                    )
                }, 500)
            }
        }
    }

    fun announceWithCallback(context: Context, textToSpeak: String, complete: () -> Unit) {
        t1 = TextToSpeech(
            context
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                t1?.language = Locale.getDefault()
                t1?.setSpeechRate(0.8F)

                val handler = Handler(Looper.getMainLooper()!!)
                handler.postDelayed({
                    t1?.speak(
                        textToSpeak,
                        TextToSpeech.QUEUE_FLUSH,
                        null, ""
                    )
                }, 500)

                t1?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(p0: String?) {

                    }

                    override fun onDone(p0: String?) {
                        complete()
                    }

                    override fun onError(p0: String?) {
                        complete()
                    }

                })
            }
        }
    }


    fun startListening(context: Context) {
        mContext = context
        // Intent to listen to user vocal input and return the result to the same activity.
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        // Use a language model based on free-form speech recognition.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 15)
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
        // Add custom listeners.
        if (sr == null)
            sr = SpeechRecognizer.createSpeechRecognizer(context)
        sr?.setRecognitionListener(this)
        sr?.cancel()
        sr?.startListening(intent)
    }

    private fun compareCommands(resultList: java.util.ArrayList<String>) {
        resultList.forEach {
            if (it.equals("Start OCR", true) ||
                it.equals("Start OCR Detection", true) ||
                it.equals("Detect OCR", true) ||
                it.equals("OCR Detection", true) ||
                it.equals("Start O C R", true) ||
                it.equals("Start O C R Detection", true) ||
                it.equals("Detect O C R", true) ||
                it.equals("O C R Detection", true)
            ) {
                appViewModel?.currentScanningType?.postValue(0)
            } else if (it.equals("Start Face Detection", true) ||
                it.equals("Face Detection", true) ||
                it.equals("Start Detecting Faces", true) ||
                it.equals("Detect Face", true) ||
                it.equals("Detect Faces", true)
            ) {
                appViewModel?.currentScanningType?.postValue(1)
            } else if (it.equals("Start Currency Detection", true) ||
                it.equals("Currency Detection", true) ||
                it.equals("Start Detecting Currency", true) ||
                it.equals("Start Detecting Currencies", true) ||
                it.equals("Detect Currencies", true) ||
                it.equals("Detect Currency", true)
            ) {
                appViewModel?.currentScanningType?.postValue(2)
            } else if (it.equals("Start Object Detection", true) ||
                it.equals("Start Objects Detection", true) ||
                it.equals("Object Detection", true) ||
                it.equals("Objects Detection", true) ||
                it.equals("Start Detecting Objects", true) ||
                it.equals("Start Detecting Object", true) ||
                it.equals("Detect Object", true) ||
                it.equals("Detect Objects", true)
            ) {
                appViewModel?.currentScanningType?.postValue(3)
            } else if (it.equals("Start Color Detection", true) ||
                it.equals("Detect Color", true) ||
                it.equals("Detect Colour", true) ||
                it.equals("Detect Colors", true) ||
                it.equals("Detect Colours", true) ||
                it.equals("Color Detection", true) ||
                it.equals("Colour Detection", true) ||
                it.equals("Colors Detection", true) ||
                it.equals("Colours Detection", true) ||
                it.equals("Start Colour Detection", true)
            ) {
                appViewModel?.currentScanningType?.postValue(4)
            } else if (it.equals("Start QR Code Detection", true) ||
                it.equals("Start QR Codes Detection", true) ||
                it.equals("Product Recognition", true) ||
                it.equals("Start Detecting QR Code", true) ||
                it.equals("Start Detecting QR Codes", true) ||
                it.equals("QR Code Detection", true) ||
                it.equals("QR Codes Detection", true) ||
                it.equals("Detect QR Codes", true) ||
                it.equals("Detect QR Code", true)
            ) {
                appViewModel?.currentScanningType?.postValue(5)
            } else if (it.equals("Start Scene Detection", true) ||
                it.equals("Scene Detection", true) ||
                it.equals("Detect Scenes", true) ||
                it.equals("Detect Scene", true)
            ) {
                appViewModel?.currentScanningType?.postValue(6)
            } else if (it.equals("Start Obstacle Detection", true) ||
                it.equals("Start Obstacles Detection", true) ||
                it.equals("Obstacle Detection", true) ||
                it.equals("Obstacles Detection", true) ||
                it.equals("Detect Obstacles", true) ||
                it.equals("Detect Obstacle", true)
            ) {
                appViewModel?.currentScanningType?.postValue(7)
            } else if (it.equals("Start Emotion Detection", true) ||
                it.equals("Start Emotions Detection", true) ||
                it.equals("Emotion Detection", true) ||
                it.equals("Emotions Detection", true) ||
                it.equals("Detect Emotions", true) ||
                it.equals("Detect Emotion", true)
            ) {
                appViewModel?.currentScanningType?.postValue(8)
            } else {
                mContext?.let { ctxt ->
                    announceCurrentCall(ctxt, "No Command Found")
                }
            }
        }
    }

    override fun onReadyForSpeech(params: Bundle) {
        Log.d(TAG, "onReadyForSpeech")
    }

    override fun onBeginningOfSpeech() {
        Log.d(TAG, "onBeginningOfSpeech")
    }

    override fun onRmsChanged(rmsdB: Float) {
//        Log.d(TAG, "onRmsChanged $rmsdB")
    }

    override fun onBufferReceived(buffer: ByteArray) {
        Log.d(TAG, "onBufferReceived")
    }

    override fun onEndOfSpeech() {
        Log.d(TAG, "onEndofSpeech")
    }

    override fun onError(error: Int) {
        Log.e(TAG, "error $error")
//        conversionCallaback.onErrorOccured(TranslatorUtil.getErrorText(error))
    }

    override fun onResults(results: Bundle) {
        val result = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        Log.e(TAG, "onResult: $result")
        result?.let { compareCommands(it) }
    }

    override fun onPartialResults(partialResults: Bundle) {
        Log.d(TAG, "onPartialResults")
    }

    override fun onEvent(eventType: Int, params: Bundle) {
        Log.d(TAG, "onEvent $eventType")
    }

}