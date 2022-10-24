package com.vityq.codelab2.ui.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun CodeLabApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { CodeLabBottomNav(navController = navController) }) {
        CodeLabNavGraph(navController = navController)
    }

}


@Composable
fun CodeLabBottomNav(navController: NavController) {
    BottomNavigation() {
        val items = listOf(
            BottomNavItems.MainScreen,
            BottomNavItems.SearchScreen,
            BottomNavItems.SettingsScreen
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination?.route
        items.forEach {
            BottomNavigationItem(selected = currentDestination == it.route,
                alwaysShowLabel = false,
                label = { Text(text = it.title) },
                onClick = { navController.navigate(it.route) },
                icon = {
                    Icon(
                        it.icon,
                        contentDescription = null
                    )
                })
        }
    }
}

sealed class BottomNavItems(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object MainScreen : BottomNavItems("Главная", Icons.Default.Home, "mainScreen")
    object SearchScreen : BottomNavItems("Главная", Icons.Default.Search, "searchScreen")
    object SettingsScreen : BottomNavItems("Главная", Icons.Default.Settings, "settingsScreen")
}