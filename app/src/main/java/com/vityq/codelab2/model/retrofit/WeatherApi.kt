package com.vityq.codelab2.model.retrofit

import com.vityq.codelab2.model.dataclasses.currentweather.CurrentWeather
import com.vityq.codelab2.model.dataclasses.dailyweather.DailyWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/forecast?daily=weathercode,temperature_2m_max,temperature_2m_min&timezone=GMT")
    suspend fun getDailyWeather(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float
    ): DailyWeather
}