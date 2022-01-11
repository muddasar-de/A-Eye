package com.scorpio.a_eye.services

import android.icu.util.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppConfig {

    var BASE_URL = "http://3.21.53.119:5000/"

    var okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, java.util.concurrent.TimeUnit.MINUTES)
        .readTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
        .build()

    fun getRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun <T> buildService(service: Class<T>): T {
        return getRetrofit()?.create(service)!!
    }
}