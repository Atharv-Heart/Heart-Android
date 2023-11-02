package com.accidentaldeveloper.heart.api

import com.accidentaldeveloper.heart.helper.AppConstant
import com.accidentaldeveloper.heart.models.heart_auth_model.login_response
import com.accidentaldeveloper.heart.models.heart_auth_model.sing_up_response
import com.accidentaldeveloper.heart.models.heart_auth_model.singup_and_login_request
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Heart_Auth_Service {

    @POST(AppConstant.HEART_END_POINT_SINGUP)
    suspend fun singup(@Body singupRequest: singup_and_login_request):Response<sing_up_response>

    @POST(AppConstant.HEART_END_POINT_LOGIN)
    suspend fun login(@Body singupRequest: singup_and_login_request):Response<login_response>





}