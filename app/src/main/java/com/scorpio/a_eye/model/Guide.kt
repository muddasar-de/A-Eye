package com.scorpio.a_eye.model

data class Guide(
    var userId: String?,
    var guidePhoto: String?,
    var guideName: String?,
    var guidePhone: String?,
    var guideEmail: String,
    var userName: String,
    var userAge: Int?,
    var userGender: String?,
    var faces: List<String> = mutableListOf(),
    var currencies: List<String> = mutableListOf()
)