package com.accidentaldeveloper.heart.models.heart_auth_model


import com.google.gson.annotations.SerializedName

data class singup_and_login_request(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)