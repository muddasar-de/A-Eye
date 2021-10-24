package com.scorpio.a_eye.Services

import com.google.gson.annotations.SerializedName




class ServerResponse {
    // variable name should be same as in the json response from php
    @SerializedName("success")
    private var success = false

    @SerializedName("message")
    private var message: String? = null

    fun getMessage(): String? {
        return message
    }

    fun getSuccess(): Boolean {
        return success
    }

}