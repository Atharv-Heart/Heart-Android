package com.accidentaldeveloper.heart.models.heart_auth_model


import com.google.gson.annotations.SerializedName

data class sing_up_response(
    @SerializedName("success")
    val success: String
)