package com.xwurfel.forecast.domain.model.WeatherForecast

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)