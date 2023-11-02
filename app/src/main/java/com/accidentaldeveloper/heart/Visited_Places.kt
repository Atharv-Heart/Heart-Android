package com.accidentaldeveloper.heart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.viewModels
import com.accidentaldeveloper.heart.databinding.ActivityMainBinding
import com.accidentaldeveloper.heart.databinding.ActivityVisitedPlacesBinding
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Visited_Places : AppCompatActivity() {
    private lateinit var webView: WebView
    lateinit var binding:ActivityVisitedPlacesBinding
    private val viewmodel:EventsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisitedPlacesBinding.inflate(layoutInflater)
        val view = binding.root

        //maps
        mapswebView()
        setContentView(view)

        //events data
         viewmodel.liveData.observe(this,{
             Log.d("events", "onCreate: ${it} ")
         })


    }
    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webView.canGoBack())
            webView.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }

    //maps wenview
    fun mapswebView(){
        webView = binding.maps
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://shorturl.at/ksBKO")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }
}