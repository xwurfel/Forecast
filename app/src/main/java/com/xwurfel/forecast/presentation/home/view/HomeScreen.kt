package com.xwurfel.forecast.presentation.home.view

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.xwurfel.forecast.LocationService
import com.xwurfel.forecast.R
import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import com.xwurfel.forecast.presentation.common.CircularLoadingIndicator
import com.xwurfel.forecast.presentation.common.GenericErrorScreen
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel.HomeUiState.Error
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel.HomeUiState.Loading
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel.HomeUiState.Success

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    val applicationContext = LocalContext.current.applicationContext
    when (uiState) {
        is Loading -> {
            CircularLoadingIndicator()
        }

        is Success -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Button(onClick = {
                    Intent(applicationContext, LocationService::class.java).apply {
                        action = LocationService.ACTION_START
                        applicationContext.startService(this)
                    }
                }) {
                    Text(text = "Start")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    Intent(applicationContext, LocationService::class.java).apply {
                        action = LocationService.ACTION_STOP
                        applicationContext.startService(this)
                    }
                }) {
                    Text(text = "Stop")
                }
                //    HomeScreenContent(uiState.data)
            }
        }

        is Error -> {
            GenericErrorScreen(uiState.message)
        }
    }
}


@Composable
fun HomeScreenContent(
    data: WeatherForecast,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = painterResource(R.drawable.bg))
    ) {
        Text("HOME ${data.city.name}", color = MaterialTheme.colorScheme.onSurface)
    }
}