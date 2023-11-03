package com.accidentaldeveloper.heart.viewmodel.HeartViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.heart.models.Heart_gallery_model.gallery_response
import com.accidentaldeveloper.heart.models.heart_events_model.events_response
import com.accidentaldeveloper.heart.repository.Heart_Repository.Heart_Features_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val heartFeaturesRepository: Heart_Features_Repository):ViewModel() {
    private val mutableGalleryLiveData = MutableLiveData<gallery_response>()
    val liveData: LiveData<gallery_response> = mutableGalleryLiveData

    init {
        getImgaesforGallery()
    }

    private fun getImgaesforGallery() = viewModelScope.launch {
        heartFeaturesRepository.getGallery().let {response->
            if(response.isSuccessful){
                mutableGalleryLiveData.postValue(response.body())
            }else{
                Log.d("error in galleryViewModel", "getImgaesforGallery: ${response.errorBody()}")
            }
        }
    }
}