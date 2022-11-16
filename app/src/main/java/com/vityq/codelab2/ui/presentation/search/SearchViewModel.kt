package com.vityq.codelab2.ui.presentation.search

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.vityq.codelab2.model.WeatherStates
import com.vityq.codelab2.model.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SearchViewModel(): ViewModel() {
    val repo = WeatherRepository()
    var date = mutableStateListOf<String>()
    var dateFormatted = mutableStateListOf<String>()
    var tempMax = mutableStateListOf<Double>()
    var tempMin = mutableStateListOf<Double>()
    var weathercode = mutableStateListOf<Int>()

    init {
        getDailyWeather()
    }

    fun formatDate(date: String): String {
        val date2 = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val str = date2.format(DateTimeFormatter.ofPattern("d, EEEE"))
        return str
    }

    private fun getDailyWeather() {
        CoroutineScope(Dispatchers.Default).launch {
            val response = repo.getDailyWeather(59.57f, 30.19f)
            date.addAll(response.daily.time)
            response.daily.time.forEach {
                dateFormatted.add(formatDate(it))
            }
            tempMax.addAll(response.daily.temperature_2m_max)
            tempMin.addAll(response.daily.temperature_2m_min)
            weathercode.addAll(response.daily.weathercode)
            weathercode.forEach {
                Log.d("check net", "vm ${it}")
            }
            Log.d("check net", "vm ${WeatherStates.findWeatherByCode(0)?.name}")

        }
    }
}