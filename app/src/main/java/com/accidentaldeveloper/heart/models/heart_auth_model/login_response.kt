package com.accidentaldeveloper.heart.models.heart_auth_model


import com.google.gson.annotations.SerializedName

data class login_response(
    @SerializedName("token")
    val token: String
)