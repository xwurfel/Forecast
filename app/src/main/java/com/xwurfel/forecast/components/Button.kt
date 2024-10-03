package com.xwurfel.forecast.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xwurfel.forecast.R
import com.xwurfel.forecast.ui.theme.BorderPurple
import com.xwurfel.forecast.ui.theme.ForecastTheme

@Composable
fun RoundPlusButton(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.shadow(20.dp, RoundedCornerShape(100.dp))
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(5.dp, color = BorderPurple),
                    shape = CircleShape,
                    modifier = Modifier
                        .size(200.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.plus_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewUIButton(modifier: Modifier = Modifier) {
    ForecastTheme {
        RoundPlusButton()
    }
}