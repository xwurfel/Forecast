package com.xwurfel.forecast.domain.usecase

import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import com.xwurfel.forecast.domain.repository.WeatherForecastRepository
import com.xwurfel.forecast.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetWeatherForecastUseCase(
    private val weatherForecastRepository: WeatherForecastRepository
) {
    suspend operator fun invoke(): Flow<Resource<WeatherForecast>> = flow {
        try {
            emit(Resource.Loading<WeatherForecast>())
            val weatherForecast = weatherForecastRepository.getWeatherForecast()
            emit(Resource.Success<WeatherForecast>(weatherForecast))
        } catch (e: Exception) {
            emit(Resource.Error<WeatherForecast> (e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}