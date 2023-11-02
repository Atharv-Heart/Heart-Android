package com.accidentaldeveloper.heart.api

import com.accidentaldeveloper.heart.helper.AppConstant
import com.accidentaldeveloper.heart.models.mascot_model.mascot_request
import com.accidentaldeveloper.heart.models.mascot_model.mascot_response

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers(
        "X-RapidAPI-Key: ${AppConstant.MASCOT_API_KEY}",
        "X-RapidAPI-Host: ${AppConstant.MASCOT_HOST_HEADER}"
    )
    @POST(AppConstant.MASCOT_ENDPOINT)
    suspend fun getDataForMascot(
        @Body request: mascot_request
    ): Response<mascot_response>
}