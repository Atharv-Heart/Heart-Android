package com.accidentaldeveloper.heart.viewmodel.HeartViewModel

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.heart.helper.NetworkResult
import com.accidentaldeveloper.heart.models.heart_auth_model.login_response
import com.accidentaldeveloper.heart.models.heart_auth_model.sing_up_response
import com.accidentaldeveloper.heart.models.heart_auth_model.singup_and_login_request
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val heartRepository: Heart_Repository):ViewModel() {

    val userResponseLiveDataforsignup:LiveData<NetworkResult<sing_up_response>> = heartRepository.signupResponseLiveData
    fun registerUser(singupRequest: singup_and_login_request) =
        viewModelScope.launch {
            heartRepository.make_request_for_sigup(singupRequest)
        }

    val userResponseLiveDataforlogin:LiveData<NetworkResult<login_response>> = heartRepository.loginResponseLiveData
    fun login(singupRequest: singup_and_login_request) =  viewModelScope.launch {
        heartRepository.make_request_for_login(singupRequest)
    }

    //validating credential
    fun validateCreditials(email:String,password:String):Pair<Boolean,String>{
        var result = Pair(true,"")
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            result = Pair(false,"Please Provide Credential")
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            result = Pair(false,"please provide valid email")
        }else if(password.length<=5){
            result = Pair(false,"Password length should be greater than 5")
        }

        return result
    }

}