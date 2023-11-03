package com.accidentaldeveloper.heart.api

import com.accidentaldeveloper.heart.helper.AppConstant
import com.accidentaldeveloper.heart.models.Heart_gallery_model.gallery_response
import com.accidentaldeveloper.heart.models.Heart_gallery_model.gallery_responseItem
import com.accidentaldeveloper.heart.models.advertisements_model.advertisements_response
import com.accidentaldeveloper.heart.models.deals_model.Deals_Response
import com.accidentaldeveloper.heart.models.heart_events_model.events_response
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface Heart_Featuers_Service {

    @GET(AppConstant.HEART_END_POINT_GALLERY)
    suspend fun Gallery(): Response<gallery_response>

    @GET(AppConstant.HEART_END_POINT_EVENTS)
    suspend fun events():Response<events_response>

    @GET(AppConstant.HEART_END_POINT_DEALS)
    suspend fun deals():Response<Deals_Response>


    @GET(AppConstant.HEART_END_POINT_ADVERTISMENT)
    suspend fun advertisments():Response<advertisements_response>





}