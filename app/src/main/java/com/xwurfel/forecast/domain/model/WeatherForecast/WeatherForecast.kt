package com.xwurfel.forecast.domain.model.WeatherForecast

data class WeatherForecast(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherForecastItem>,
    val city: City
)