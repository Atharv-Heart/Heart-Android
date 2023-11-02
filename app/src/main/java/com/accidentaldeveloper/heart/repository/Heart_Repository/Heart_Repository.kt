package com.accidentaldeveloper.heart.repository.Heart_Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.accidentaldeveloper.heart.api.Heart_Auth_Service
import com.accidentaldeveloper.heart.helper.NetworkResult
import com.accidentaldeveloper.heart.models.heart_auth_model.login_response
import com.accidentaldeveloper.heart.models.heart_auth_model.sing_up_response
import com.accidentaldeveloper.heart.models.heart_auth_model.singup_and_login_request
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class Heart_Repository @Inject constructor(private val heartService: Heart_Auth_Service) {

    //livedata for sing_up
    private val singUpResponseMutableLiveData = MutableLiveData<NetworkResult<sing_up_response>>()
    val signupResponseLiveData: LiveData<NetworkResult<sing_up_response>> =
        singUpResponseMutableLiveData

    //function for sing_up
    suspend fun make_request_for_sigup(singupRequest: singup_and_login_request) {
        singUpResponseMutableLiveData.postValue(NetworkResult.Loading())
        val response = heartService.singup(singupRequest)
        handleSingupResponse(response)
        Log.d("response", "make_request_for_sigup: ${response.body().toString()}")
    }


    //livedata for login
    private val loginResponseMutableLiveData = MutableLiveData<NetworkResult<login_response>>()
    val loginResponseLiveData: LiveData<NetworkResult<login_response>> =
        loginResponseMutableLiveData

    //function for login
    suspend fun make_request_for_login(singupRequest: singup_and_login_request) {

        loginResponseMutableLiveData.postValue(NetworkResult.Loading())
        val response = heartService.login(singupRequest)

        handleLoginResponse(response)
        Log.d("response", "make_request_for_sigup: ${response.body().toString()}")
    }


    //to handle handleLoginResponse
    private fun handleSingupResponse(response: Response<sing_up_response>) {
        if (response.isSuccessful && response.body() != null) {
            singUpResponseMutableLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            singUpResponseMutableLiveData.postValue(NetworkResult.Error(errorObj.getString("error")))
        } else {
            singUpResponseMutableLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    //to handle handleLoginResponse
    private fun handleLoginResponse(response: Response<login_response>) {
        if (response.isSuccessful && response.body() != null) {
            loginResponseMutableLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            //parssing errorBody json object
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            loginResponseMutableLiveData.postValue(NetworkResult.Error(errorObj.getString("error")))
        } else {
            loginResponseMutableLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }







}