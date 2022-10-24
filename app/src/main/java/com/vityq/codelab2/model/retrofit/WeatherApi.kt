package com.vityq.codelab2.model.retrofit

import com.vityq.codelab2.model.dataclasses.currentweather.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("id") id: Int,
        @Query("appid") appId: String
    ): CurrentWeather
}