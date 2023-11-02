package com.accidentaldeveloper.heart.repository.Heart_Repository

import com.accidentaldeveloper.heart.api.Heart_Auth_Service
import com.accidentaldeveloper.heart.api.Heart_Featuers_Service
import javax.inject.Inject

class Heart_Events_Repository @Inject constructor(private val heartService:Heart_Featuers_Service)  {

    suspend fun getEvents() = heartService.events()
}