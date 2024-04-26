package com.xwurfel.forecast.di

import android.app.Application
import com.xwurfel.forecast.data.remote.WeatherForecastAPI
import com.xwurfel.forecast.data.repository.WeatherForecastRepositoryImpl
import com.xwurfel.forecast.domain.repository.WeatherForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherForecastAPI(): WeatherForecastAPI {
        return Retrofit.Builder()
            .baseUrl("https://getweatherforecast.com")
            .build()
            .create(WeatherForecastAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherForecastRepository(api: WeatherForecastAPI, app: Application): WeatherForecastRepository {
        return WeatherForecastRepositoryImpl(api, app)
    }
}