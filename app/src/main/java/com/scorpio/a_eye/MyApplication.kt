package com.scorpio.a_eye

import android.app.Application
import android.util.Log
//import org.opencv.android.OpenCVLoader

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        if (!OpenCVLoader.initDebug())
//            Log.e("OpenCv", "Unable to load OpenCV");
//        else
//            Log.d("OpenCv", "OpenCV loaded");
    }
}