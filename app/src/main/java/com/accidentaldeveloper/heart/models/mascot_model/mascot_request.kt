package com.accidentaldeveloper.heart.models.mascot_model

import com.google.gson.annotations.SerializedName

data class mascot_request(
    @SerializedName("query")
    val query: String
)