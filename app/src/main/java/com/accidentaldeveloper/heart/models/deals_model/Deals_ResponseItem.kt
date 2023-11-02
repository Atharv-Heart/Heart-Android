package com.accidentaldeveloper.heart.models.deals_model


import com.google.gson.annotations.SerializedName

data class Deals_ResponseItem(
    @SerializedName("advertisement")
    val advertisement: Boolean,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("__v")
    val v: Int
)