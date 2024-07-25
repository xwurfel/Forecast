package com.xwurfel.forecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xwurfel.forecast.presentation.home.view.HomeScreen
import com.xwurfel.forecast.presentation.navigation.Screens
import com.xwurfel.forecast.ui.theme.ForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForecastTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.Home) {
                    composable<Screens.Home> {
                        HomeScreen()
                    }
                    composable<Screens.Settings> {
                        Text(text = "Settings")
                    }
                    composable<Screens.WeatherForecast> {
                        Text(text = "Weather Forecast")
                    }
                }
            }
        }
    }
}
