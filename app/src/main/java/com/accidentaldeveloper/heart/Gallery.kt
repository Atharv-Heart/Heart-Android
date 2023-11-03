package com.accidentaldeveloper.heart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.accidentaldeveloper.heart.adapters.GalleryAdapter
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Gallery : AppCompatActivity() {
    private val galleryViewModel:GalleryViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        // Find the RecyclerView in your layout
        recyclerView = findViewById(R.id.gallery_rv)

        // Set up the StaggeredGridLayoutManager with your desired span count
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        galleryViewModel.liveData.observe(this,{galleryItems->
            val adapter = GalleryAdapter(galleryItems)
            recyclerView.adapter = adapter
            Log.d("vinit", "onCreate: ${galleryItems}")
        })
    }
}