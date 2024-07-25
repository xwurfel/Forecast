package com.xwurfel.forecast.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xwurfel.forecast.ui.theme.ForecastTheme

@Composable
fun GenericErrorScreen(
    error: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("An error occurred", color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(16.dp))
            Text(error, color = MaterialTheme.colorScheme.error)
        }
    }
}

@Preview
@Composable
private fun PreviewGenericErrorScreen() {
    ForecastTheme {
        GenericErrorScreen("")
    }
}