package com.xwurfel.forecast.domain.repository

import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast

interface WeatherForecastRepository {
    suspend fun getWeatherForecast(): WeatherForecast
}