package com.xwurfel.forecast.domain.model.weather_forecast

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)