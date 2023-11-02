package com.accidentaldeveloper.heart.viewmodel.HeartViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.heart.models.advertisements_model.advertisements_response
import com.accidentaldeveloper.heart.repository.Heart_Repository.Heart_Features_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdvertimentViewModel @Inject constructor(private val heartFeaturesRepository: Heart_Features_Repository):ViewModel() {
    private val AdvertimentMutableLiveData = MutableLiveData<advertisements_response>()
    val advertismentLiveData:LiveData<advertisements_response> = AdvertimentMutableLiveData

    init {
        getAdvertisment()
    }

    private fun getAdvertisment(){
        viewModelScope.launch {
            heartFeaturesRepository.getAdvertisment().let {response->
                if(response.isSuccessful){
                    AdvertimentMutableLiveData.postValue(response.body())
                }else{
                    Log.d("error_in_advertisment_viewmodel", "getAdvertisment:${response.errorBody()}")
                }
            }
        }
    }
}