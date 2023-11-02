package com.accidentaldeveloper.heart.di

import com.accidentaldeveloper.heart.api.ApiService
import com.accidentaldeveloper.heart.api.Heart_Auth_Service
import com.accidentaldeveloper.heart.helper.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provide_Retrofit_Instance_For_Mascaot() = Retrofit
        .Builder()
        .baseUrl(AppConstant.MASCOT_BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS) // Increase the read timeout
                .connectTimeout(30, TimeUnit.SECONDS)  // Increase the connect timeout
                .build()
        )
        .build()
        .create(ApiService::class.java)



    @Provides
    fun provide_Provide_Retrofit_Instance_For_HeART() = Retrofit
        .Builder()
        .baseUrl(AppConstant.HEART_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS) // Increase the read timeout
                .connectTimeout(60, TimeUnit.SECONDS)  // Increase the connect timeout
                .build()
        )
        .build()
        .create(Heart_Auth_Service::class.java)
}