package com.vityq.codelab2.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vityq.codelab2.ui.presentation.mainscreen.MainScreen

@Composable
fun CodeLabNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable(BottomNavItems.MainScreen.route) {
            MainScreen()
        }
        composable(BottomNavItems.SearchScreen.route) {
            // Еще экран
        }
        composable(BottomNavItems.SettingsScreen.route) {
            // Еще экран
        }
    }
}