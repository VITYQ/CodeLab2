package com.vityq.codelab2.ui.presentation.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(128.dp))
        Text(text = viewModel.currentWeather?.name ?: "", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = viewModel.currentWeather?.weather?.get(0)?.description ?: "",
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${if (viewModel.currentTemperature != null) viewModel.currentTemperature else 0}°C",
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Ощущается как ${if (viewModel.feelsLikeTemperature != null) viewModel.feelsLikeTemperature else 0}°C",
            style = MaterialTheme.typography.body1
        )
    }
}