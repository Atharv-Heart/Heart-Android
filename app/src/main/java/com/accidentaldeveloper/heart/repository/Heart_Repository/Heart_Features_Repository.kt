package com.accidentaldeveloper.heart.repository.Heart_Repository

import com.accidentaldeveloper.heart.api.Heart_Featuers_Service
import javax.inject.Inject

class Heart_Features_Repository @Inject constructor(private val heartService:Heart_Featuers_Service)  {

    suspend fun getEvents() = heartService.events()

    suspend fun getDeals() = heartService.deals()

    suspend fun getAdvertisment() = heartService.advertisments()

    suspend fun getGallery() = heartService.Gallery()




}