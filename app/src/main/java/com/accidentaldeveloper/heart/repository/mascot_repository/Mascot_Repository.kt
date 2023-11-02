package com.accidentaldeveloper.heart.repository.mascot_repository

import com.accidentaldeveloper.heart.api.ApiService
import com.accidentaldeveloper.heart.models.mascot_model.mascot_request

import javax.inject.Inject

class Mascot_Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun perform_post_request_for_mascot(query: mascot_request) = apiService.getDataForMascot(query)
}