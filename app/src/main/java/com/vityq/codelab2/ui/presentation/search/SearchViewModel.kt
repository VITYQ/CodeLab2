package com.vityq.codelab2.ui.presentation.search

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.vityq.codelab2.model.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(): ViewModel() {
    val repo = WeatherRepository()
    var date = mutableStateListOf<String>()
    var tempMax = mutableStateListOf<Double>()
    var tempMin = mutableStateListOf<Double>()
    var weathercode = mutableStateListOf<Int>()

    init {
        getDailyWeather()
    }

    private fun getDailyWeather() {
        CoroutineScope(Dispatchers.Default).launch {
            val response = repo.getDailyWeather(52.52f, 13.41f)
            date.addAll(response.daily.time)
            tempMax.addAll(response.daily.temperature_2m_max)
            tempMin.addAll(response.daily.temperature_2m_min)
            weathercode.addAll(response.daily.weathercode)
            Log.d("check net", "vm ${date}")
        }
    }
}