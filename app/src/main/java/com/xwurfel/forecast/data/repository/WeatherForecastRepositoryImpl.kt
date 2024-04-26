package com.xwurfel.forecast.data.repository

import android.app.Application
import com.xwurfel.forecast.data.remote.WeatherForecastAPI
import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import com.xwurfel.forecast.domain.repository.WeatherForecastRepository
import javax.inject.Inject

class WeatherForecastRepositoryImpl @Inject constructor(
    private val api: WeatherForecastAPI,
    private val appContext: Application
): WeatherForecastRepository {

    override suspend fun getWeatherForecast(): WeatherForecast {
        return api.GetWeatherForecast()
    }
}