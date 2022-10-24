package com.vityq.codelab2.ui.presentation.mainscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vityq.codelab2.model.dataclasses.currentweather.CurrentWeather
import com.vityq.codelab2.model.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var currentWeather by mutableStateOf<CurrentWeather?>(null)
    var currentTemperature by mutableStateOf<Int?>(null)
    var feelsLikeTemperature by mutableStateOf<Int?>(null)
    private val repository = WeatherRepository()

    init {
        fetchCurrentWeather()
    }

    private fun fetchCurrentWeather() {
        CoroutineScope(Dispatchers.Default).launch {
            currentWeather = repository.getCurrentWeather(2643743)
            currentTemperature = (currentWeather!!.main.temp - 270).toInt()
            feelsLikeTemperature = (currentWeather!!.main.feels_like - 270).toInt()
            Log.d("currWeather", "weather: $currentWeather")
        }
    }
}