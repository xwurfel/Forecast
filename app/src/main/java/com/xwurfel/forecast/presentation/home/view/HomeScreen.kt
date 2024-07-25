package com.xwurfel.forecast.presentation.home.view

import com.xwurfel.forecast.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

    when (uiState) {
        is Loading -> {
            CircularLoadingIndicator()
        }

        is Success -> {
            HomeScreenContent(uiState.data)
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