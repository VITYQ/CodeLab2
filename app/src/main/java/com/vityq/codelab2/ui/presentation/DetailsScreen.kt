package com.vityq.codelab2.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun DetailsScreen() {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Это детальный экран")
    }
}