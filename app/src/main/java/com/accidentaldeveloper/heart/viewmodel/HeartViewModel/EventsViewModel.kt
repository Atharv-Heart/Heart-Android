package com.accidentaldeveloper.heart.viewmodel.HeartViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.heart.models.heart_events_model.events_response
import com.accidentaldeveloper.heart.repository.Heart_Repository.Heart_Features_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(private val heartRepository: Heart_Features_Repository) : ViewModel() {
    private val mutableEventsLiveData = MutableLiveData<events_response>()
    val liveData: LiveData<events_response> = mutableEventsLiveData

    init {
        getEventsData()
    }

    private fun getEventsData() {
        viewModelScope.launch {
            heartRepository.getEvents().let { response ->
                if (response.isSuccessful) {
                    mutableEventsLiveData.postValue(response.body())
                } else {
                    Log.d("error in events_viewmodel", " Error:${response.code()}")
                }
            }
        }
    }
}