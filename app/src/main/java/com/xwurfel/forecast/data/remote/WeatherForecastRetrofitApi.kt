package com.xwurfel.forecast.data.remote

import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastRetrofitApi {

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String,
    ): WeatherForecast
}