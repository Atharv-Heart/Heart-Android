package com.accidentaldeveloper.heart.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.heart.models.mascot_model.mascot_request
import com.accidentaldeveloper.heart.models.mascot_model.mascot_response
import com.accidentaldeveloper.heart.repository.mascot_repository.Mascot_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Mascot_View_Model @Inject constructor(private val mascotRepository: Mascot_Repository):ViewModel() {

    private val mutableLiveData_of_mascot = MutableLiveData<mascot_response>()

    val livedata:LiveData<mascot_response> = mutableLiveData_of_mascot


     fun getdata(query: mascot_request) = viewModelScope.launch {
      mascotRepository.perform_post_request_for_mascot(query).let {response->
         if(response.isSuccessful){
           mutableLiveData_of_mascot.postValue(response.body())
         }else{
             Log.d("tag", "Error:${response.code()}")
         }
      }
    }
}