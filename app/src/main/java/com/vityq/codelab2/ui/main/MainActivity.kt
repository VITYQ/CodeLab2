package com.vityq.codelab2.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vityq.codelab2.ui.presentation.mainscreen.MainScreen
import com.vityq.codelab2.ui.theme.CodeLab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLab2Theme {
                CodeLabApp()
            }
        }
    }
}