package com.vityq.codelab2.ui.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vityq.codelab2.ui.presentation.search.SearchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vityq.codelab2.R
import com.vityq.codelab2.model.WeatherStates

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel()) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Log.d("check net", "${viewModel.date}")
        itemsIndexed(viewModel.date) { i, value ->
        }
        itemsIndexed(viewModel.date) { index, item ->
            DailyWeatherCard(
                tempMax = viewModel.tempMax[index].toInt(),
                tempMin = viewModel.tempMin[index].toInt(),
                date = viewModel.dateFormatted[index],
                weatherCode = viewModel.weathercode[index]
            )
        }
    }
}

@Composable
fun DailyWeatherCard(tempMax: Int, tempMin: Int, date: String, weatherCode: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(64.dp)
    ) {
        val weatherState = WeatherStates.findWeatherByCode(weatherCode)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = date)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(
                    id = weatherState?.icon ?: R.drawable.ic_launcher_background
                ), contentDescription = null, modifier = Modifier.size(48.dp),
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(Modifier.width(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = tempMax.toString())
                Text(text = tempMin.toString(), color = Color.LightGray)
            }
        }
    }
}