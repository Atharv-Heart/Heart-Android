package com.accidentaldeveloper.heart.api

import com.accidentaldeveloper.heart.helper.AppConstant
import com.accidentaldeveloper.heart.models.Heart_gallery_model.gallery_responseItem
import retrofit2.Response
import retrofit2.http.GET

interface Heart_Featuers_Service {

    @GET(AppConstant.HEART_END_POINT_GALLERY)
    suspend fun getImagesForGallery():Response<gallery_responseItem>

}