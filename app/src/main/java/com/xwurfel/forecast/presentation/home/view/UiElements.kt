package com.xwurfel.forecast.presentation.home.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xwurfel.forecast.R
import com.xwurfel.forecast.ui.theme.ForecastTheme

@Composable
fun ForecastIconBubble(
    title: String,
    @DrawableRes icon: Int,
    temperature: Int,
    modifier: Modifier = Modifier,
    isActive: Boolean = false
) {
    Column(
        modifier = modifier
            .padding(vertical = 24.dp)
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(title, color = MaterialTheme.colorScheme.onBackground)
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Text(temperature.toString(), color = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview
@Composable
private fun PreviewForecastIconBubble() {
    ForecastTheme {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {
            ForecastIconBubble(
                title = "Title",
                icon = R.drawable.ic_raincloud,
                temperature = 0,
                modifier = Modifier.wrapContentSize()
            )
        }
    }
}