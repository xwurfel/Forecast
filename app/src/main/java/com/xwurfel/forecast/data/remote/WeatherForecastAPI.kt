package com.xwurfel.forecast.data.remote

import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import com.xwurfel.forecast.domain.usecase.GetWeatherForecastUseCase
import retrofit2.http.GET

interface WeatherForecastAPI {

    @GET("api.openweathermap.org/data/2.5/forecast?lat=49.84&lon=24.03&appid=2c824374b2986cee096c43d8777932c7")
    suspend fun GetWeatherForecast(): WeatherForecast
}