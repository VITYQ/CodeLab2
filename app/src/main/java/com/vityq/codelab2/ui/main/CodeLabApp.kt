package com.vityq.codelab2.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CodeLabApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { CodeLabBottomNav(navController = navController)}) {
        CodeLabNavGraph(navController = navController)
    }
    
}

@Composable
fun CodeLabNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            // Стартовый экран
        }
        composable("lalala") {
            // Еще экран
        }
        composable("lalalala") {
            // Еще экран
        }
    }
}

@Composable
fun CodeLabBottomNav(navController: NavController) {
    val items = listOf("Главная", "Поиск", "Настройки")

    BottomNavigation() {
        items.forEach {
            BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            })
        }
    }
}