package com.accidentaldeveloper.heart.api

import com.accidentaldeveloper.heart.helper.AppConstant
import com.accidentaldeveloper.heart.models.Heart_gallery_model.gallery_responseItem
import com.accidentaldeveloper.heart.models.heart_events_model.events_response
import retrofit2.Response
import retrofit2.http.GET

interface Heart_Featuers_Service {

    @GET(AppConstant.HEART_END_POINT_GALLERY)
    suspend fun getImagesForGallery():Response<gallery_responseItem>

    @GET(AppConstant.HEART_END_POINT_EVENTS)
    suspend fun events():Response<events_response>

}