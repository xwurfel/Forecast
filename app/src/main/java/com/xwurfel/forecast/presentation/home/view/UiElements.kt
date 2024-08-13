package com.xwurfel.forecast.presentation.home.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xwurfel.forecast.R
import com.xwurfel.forecast.ui.theme.BorderPurple
import com.xwurfel.forecast.ui.theme.DarkPurple
import com.xwurfel.forecast.ui.theme.ForecastTheme
import com.xwurfel.forecast.ui.theme.PurpleBubble
import com.xwurfel.forecast.ui.theme.TitleGray
import com.xwurfel.forecast.ui.theme.WhiteBubble

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
            .background(color = PurpleBubble, RoundedCornerShape(16.dp))
            .border(
                1.dp,
                color = WhiteBubble,
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Spacer(modifier = Modifier.size(2.dp))
        Text(
            title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall,
        )
        Spacer(modifier = Modifier.size(1.dp))
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .padding(horizontal = 4.dp)
        )
        Spacer(modifier = Modifier.size(1.dp))
        Text(
            temperature.toString(),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall,
        )
        Spacer(modifier = Modifier.size(2.dp))
    }
}

@Composable
fun ForecastIconWeatherDetails(
    @DrawableRes icontitle: Int,
    title: String,
    modifier: Modifier = Modifier,
    isActive: Boolean = false
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .border(
                    width = 1.dp, color = BorderPurple,
                    shape = RoundedCornerShape(30.dp)
                )
                .size(140.dp)
                .purpleRoundedCorner(shape = RoundedCornerShape(20))
        ) {
            Image(
                painter = painterResource(id = icontitle),
                contentDescription = null,
                modifier = modifier
                    .size(35.dp)
                    .padding(vertical = 10.dp)
            )
            Text(
                title,
                color = TitleGray,
                modifier = modifier
                    .padding(horizontal = 25.dp, vertical = 5.dp)
                    .size(35.dp)
            )
        }
    }
}

fun Modifier.purpleRoundedCorner(shape: Shape) =
    this then Modifier
        .clip(shape = shape)
        .background(color = DarkPurple)

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

@Preview
@Composable
private fun PreviewForecastIconWeatherDetails() {
    ForecastTheme {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {
            ForecastIconWeatherDetails(
                title = "Title",
                icontitle = R.drawable.feels_like_icon
            )
        }
    }

}