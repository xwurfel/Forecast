package com.xwurfel.forecast.di

import com.xwurfel.forecast.data.remote.WeatherForecastRetrofitApi
import com.xwurfel.forecast.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideWeatherForecastRetrofitApi(retrofit: Retrofit): WeatherForecastRetrofitApi {
        return retrofit.create(WeatherForecastRetrofitApi::class.java)
    }
}

