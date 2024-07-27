package com.xwurfel.forecast.presentation.home.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xwurfel.forecast.R
import com.xwurfel.forecast.ui.theme.ForecastTheme
import com.xwurfel.forecast.ui.theme.purpleBubble
import com.xwurfel.forecast.ui.theme.whiteBubble

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
            .background(color = purpleBubble, RoundedCornerShape(16.dp))
            .border(
                1.dp,
                color = whiteBubble,
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Spacer(modifier = Modifier.size(2.dp))
        Text(
            title,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Clip,
            modifier = Modifier.wrapContentWidth()
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
            style = MaterialTheme.typography.titleSmall,
        )
        Spacer(modifier = Modifier.size(2.dp))
    }
}

@Preview
@Composable
private fun PreviewForecastIconBubble() {
    ForecastTheme {
        Surface(
            color = Color.White,
            modifier = Modifier
        ) {
            ForecastIconBubble(
                title = "Title",
                icon = R.drawable.ic_raincloud,
                temperature = 0,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
            )
        }
    }
}