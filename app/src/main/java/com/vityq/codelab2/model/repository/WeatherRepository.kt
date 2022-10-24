package com.vityq.codelab2.model.repository

import com.google.gson.GsonBuilder
import com.vityq.codelab2.model.retrofit.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {
    val apiKey = "e9fa256df6ebb4101bec1ec7eaa465f2"
    val gson = GsonBuilder().apply {
        setLenient()
    }.create()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val weatherApi = retrofit.create(WeatherApi::class.java)

    suspend fun getCurrentWeather(cityId: Int) = weatherApi.getCurrentWeather(cityId, apiKey)
}