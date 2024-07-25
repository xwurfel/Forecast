package com.xwurfel.forecast.domain.usecase

import com.xwurfel.forecast.domain.repository.WeatherForecastRepository
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val weatherForecastRepository: WeatherForecastRepository
) {
}