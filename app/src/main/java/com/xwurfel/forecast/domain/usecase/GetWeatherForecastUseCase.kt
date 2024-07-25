package com.xwurfel.forecast.domain.usecase

import com.xwurfel.forecast.data.remote.WeatherForecastRetrofitApi
import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val weatherForecastRetrofitApi: WeatherForecastRetrofitApi
) {
    suspend operator fun invoke(): WeatherForecast {
        //TODO add real lat and lon
        //TODO add real lat and lon
        return weatherForecastRetrofitApi.getWeatherForecast(
            lat = 49.84,
            lon = 24.03,
            appId = "2c824374b2986cee096c43d8777932c7"
        )
    }
}