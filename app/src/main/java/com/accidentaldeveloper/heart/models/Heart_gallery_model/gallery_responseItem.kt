package com.accidentaldeveloper.heart.models.Heart_gallery_model


import com.google.gson.annotations.SerializedName

data class gallery_responseItem(
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