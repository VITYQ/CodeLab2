package com.vityq.codelab2.model.dataclasses.currentweather

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)