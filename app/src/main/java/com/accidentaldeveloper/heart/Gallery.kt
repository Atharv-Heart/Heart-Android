package com.accidentaldeveloper.heart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Gallery : AppCompatActivity() {
    private val galleryViewModel:GalleryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        galleryViewModel.liveData.observe(this,{
            Log.d("vinit", "onCreate: ${it}")
        })
    }
}