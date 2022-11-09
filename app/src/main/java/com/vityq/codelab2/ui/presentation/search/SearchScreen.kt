package com.vityq.codelab2.ui.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vityq.codelab2.ui.presentation.search.SearchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel()) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Log.d("check net", "${viewModel.date}")
        itemsIndexed(viewModel.date) { index, item ->
            DailyWeatherCard(
                tempMax = viewModel.tempMax[index].toInt(),
                tempMin = viewModel.tempMin[index].toInt(),
                date = viewModel.date[index],
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = "Понедельник, 4")
            Spacer(modifier = Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = tempMax.toString())
                Text(text = tempMin.toString(), color = Color.LightGray)
            }
        }
    }
}