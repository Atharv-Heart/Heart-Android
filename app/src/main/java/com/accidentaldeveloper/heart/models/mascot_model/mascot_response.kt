package com.accidentaldeveloper.heart.models.mascot_model


import com.google.gson.annotations.SerializedName

data class mascot_response(
    @SerializedName("conversationId")
    val conversationId: String,
    @SerializedName("response")
    val response: String
)