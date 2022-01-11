package com.scorpio.a_eye.services

import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Body
import com.scorpio.a_eye.services.ServerResponse

interface ApiConfig {
    @Headers("Content-Type: image/jpeg")
    @POST("/faceDetection")
    fun faceDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/objectDetection")
    fun objectDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/OCR")
    fun ocrDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/colorDetection")
    fun colorDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/currencyDetection")
    fun currencyDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/sceneDetection")
    fun sceneDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/emotionDetection")
    fun emotionDetection(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: image/jpeg")
    @POST("/faceAdd")
    fun faceAdd(@Body data: String): Call<ServerResponse?>?

    @Headers("Content-Type: text/html")
    @POST("/faceName")
    fun faceName(@Body data: String): Call<ServerResponse?>?
}