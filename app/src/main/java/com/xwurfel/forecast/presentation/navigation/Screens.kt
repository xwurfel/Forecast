package com.xwurfel.forecast.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable data object Home : Screens()
    @Serializable data object WeatherForecast : Screens()
    @Serializable data object Settings : Screens()
}