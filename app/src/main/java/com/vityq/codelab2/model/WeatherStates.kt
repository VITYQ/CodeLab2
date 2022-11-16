package com.vityq.codelab2.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.vityq.codelab2.R

enum class WeatherStates(val code: List<Int>, val icon: Int) {
    CLEAR_SKY(listOf(0), R.drawable.ic_cloudy),
    CLOUDY(listOf(3), R.drawable.ic_cloudy),
    PARTLY_CLOUDY(listOf(1,2), R.drawable.ic_partly_cloudy),
    FOG(listOf(45,48), R.drawable.ic_foggy),
    DRIZZLE(listOf(51,53,55), R.drawable.ic_cloudy),
    FREEZING_DRIZZLE(listOf(56,57), R.drawable.ic_cloudy);

    companion object {
        fun findWeatherByCode(code: Int): WeatherStates? = values().find { it.code.contains(code) }
    }
}



















//enum class WeatherStates(val weatherCodes: List<Int>) {
//    SUNNY(listOf(1,3,4)),
//    CLOUDY(listOf(34,54));
//
//    companion object {
//        fun findWeather(code: Int): WeatherStates? {
//            return values().find { it.weatherCodes.contains(code) }
//        }
//    }
//
//}