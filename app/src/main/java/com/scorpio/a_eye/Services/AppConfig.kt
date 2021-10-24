package com.scorpio.a_eye.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppConfig {

    var BASE_URL = "http://unitypuzzlegame.com/"

    fun getRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}