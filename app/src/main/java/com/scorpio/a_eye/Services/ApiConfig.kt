package com.scorpio.a_eye.Services

import com.squareup.okhttp.RequestBody
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap


interface ApiConfig {
    @Multipart
    @POST("images/upload_image.php")
    fun upload(
        @Header("Authorization") authorization: String?,
        @PartMap map: Map<String?, RequestBody?>?
    ): Call<ServerResponse?>?
}