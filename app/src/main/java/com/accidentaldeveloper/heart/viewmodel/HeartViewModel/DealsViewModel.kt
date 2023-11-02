package com.accidentaldeveloper.heart.viewmodel.HeartViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.accidentaldeveloper.heart.models.deals_model.Deals_Response
import com.accidentaldeveloper.heart.repository.Heart_Repository.Heart_Features_Repository
import com.accidentaldeveloper.heart.repository.Heart_Repository.Heart_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealsViewModel @Inject constructor(private val heartRepository: Heart_Features_Repository):ViewModel() {
    private val mutableLiveData = MutableLiveData<Deals_Response>()
    val livedata:LiveData<Deals_Response> = mutableLiveData

    init {
        getDeals()
    }

    private fun getDeals(){
        viewModelScope.launch {
            heartRepository.getDeals().let{response ->
                if(response.isSuccessful){
                    mutableLiveData.postValue(response.body())
                }else{
                    Log.d("error in deals_viewModel", "getDeals:${response.code()} ")
                }
            }
        }
    }
}