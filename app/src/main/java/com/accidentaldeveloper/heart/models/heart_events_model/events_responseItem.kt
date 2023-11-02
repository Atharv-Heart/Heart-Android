package com.accidentaldeveloper.heart.models.heart_events_model


import com.google.gson.annotations.SerializedName

data class events_responseItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("saved")
    val saved: Boolean,
    @SerializedName("time")
    val time: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("__v")
    val v: Int
)