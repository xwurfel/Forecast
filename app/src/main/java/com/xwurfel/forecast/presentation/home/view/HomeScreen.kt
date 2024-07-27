package com.xwurfel.forecast.presentation.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.xwurfel.forecast.R
import com.xwurfel.forecast.domain.model.weather_forecast.City
import com.xwurfel.forecast.domain.model.weather_forecast.Clouds
import com.xwurfel.forecast.domain.model.weather_forecast.Coord
import com.xwurfel.forecast.domain.model.weather_forecast.Main
import com.xwurfel.forecast.domain.model.weather_forecast.Sys
import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecast
import com.xwurfel.forecast.domain.model.weather_forecast.WeatherForecastItem
import com.xwurfel.forecast.domain.model.weather_forecast.Wind
import com.xwurfel.forecast.presentation.common.CircularLoadingIndicator
import com.xwurfel.forecast.presentation.common.GenericErrorScreen
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel.HomeUiState.Error
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel.HomeUiState.Loading
import com.xwurfel.forecast.presentation.home.viewmodel.HomeViewModel.HomeUiState.Success
import com.xwurfel.forecast.ui.theme.ForecastTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        is Loading -> {
            CircularLoadingIndicator()
        }

        is Success -> {
            HomeScreenContent((uiState as Success).data)
        }

        is Error -> {
            GenericErrorScreen((uiState as Error).message)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    data: WeatherForecast,
) {
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberModalBottomSheetState()
    )
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds
        )
        BottomSheetScaffold(
            sheetContent = {
                HomeBottomSheetContent(data = data, onToggle = { state ->
                    coroutineScope.launch {
                        when (state) {
                            HomeBottomSheetState.HOURLY_FORECAST -> {
//                                    sheetState.bottomSheetState.collapse()
                            }

                            HomeBottomSheetState.WEEKLY_FORECAST -> {
//                                    sheetState.bottomSheetState.expand()
                            }
                        }
                    }
                })
            },
            sheetContainerColor = Color(0xFF1F1D47),
            sheetContentColor = Color(0xFFEBEBF5),
            modifier = Modifier,
            scaffoldState = sheetState,
            sheetPeekHeight = 350.dp
        ) { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.bg),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(paddingValues)
            ) {

            }
        }
    }
}

enum class HomeBottomSheetState {
    HOURLY_FORECAST, WEEKLY_FORECAST
}

@Composable
fun HomeBottomSheetContent(
    data: WeatherForecast,
    onToggle: (HomeBottomSheetState) -> Unit,
    modifier: Modifier = Modifier,
    isHourlySelected: Boolean = true
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Hourly Forecast",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.clickable { onToggle(HomeBottomSheetState.HOURLY_FORECAST) }
        )
        Text(
            text = "Weekly Forecast",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.clickable { onToggle(HomeBottomSheetState.WEEKLY_FORECAST) }
        )
    }
    HorizontalDivider(
        color = Color(0xFFEBEBF5), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp)
    )

    val state = rememberLazyListState()
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        state = state,
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            data.list
        ) { forecast ->
            ForecastIconBubble(
                title = forecast.dtTxt,
                icon = R.drawable.ic_raincloud,
                temperature = forecast.main.temp.toInt(),
                modifier = Modifier.width(45.dp)
            )
        }
    }
}

@Preview
@Composable
private fun HomeBottomSheetPreview() {
    ForecastTheme {
        Surface(
            color = MaterialTheme.colorScheme.surface, modifier = Modifier.fillMaxSize()
        ) {
            Column {
                HomeBottomSheetContent(previewData(), {})
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ForecastTheme {
        HomeScreenContent(previewData())
    }
}

fun previewData() = WeatherForecast(
    cod = "Talitha", message = 5863, cnt = 4801, list = List(10) {
        getPreviewForecastItem()
    }, city = City(
        id = 8183,
        name = "Lino",
        coord = Coord(lat = 2.433, lon = 31.886),
        country = "Elton",
        population = 9619,
        timezone = 4100,
        sunrise = 2369,
        sunset = 1804
    )
)

private fun getPreviewForecastItem() =
    WeatherForecastItem(
        dt = 2851,
        main = Main(
            temp = 44.218,
            feelsLike = 85.471,
            tempMin = 52.994,
            tempMax = 46.109,
            pressure = 3758,
            seaLevel = 5615,
            grndLevel = 9547,
            humidity = 7505,
            tempKf = 78.830
        ),
        weather = listOf(),
        clouds = Clouds(all = 5641),
        wind = Wind(
            speed = 41.208, deg = 8310, gust = 4.059
        ),
        visibility = 4195,
        pop = 91.019,
        rain = null,
        sys = Sys(pod = "Lyndsie"),
        dtTxt = "Shar"
    )

