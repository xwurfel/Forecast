package com.xwurfel.forecast.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import com.xwurfel.forecast.domain.usecase.GetWeatherForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            initData()
        }
    }

    private suspend fun initData(){
        try {
            val result = getWeatherForecastUseCase()
            _uiState.update { HomeUiState.Success(result) }
        } catch (e: Exception) {
            _uiState.update { HomeUiState.Error(e.message ?: "Unknown Error") }
        }
    }

    sealed interface HomeUiState {
        data object Loading : HomeUiState
        data class Success(val data: WeatherForecast) : HomeUiState
        data class Error(val message: String) : HomeUiState
    }
}
