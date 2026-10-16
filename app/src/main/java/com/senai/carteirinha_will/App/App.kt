package com.senai.carteirinha_will.App

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinha_will.Core.designSystem.Theme.Carteirinha_WillTheme
import com.senai.carteirinha_will.App.Navigation.AppNavHost
import com.senai.carteirinha_will.App.di.AppContainer

@Composable
fun App(container: AppContainer) {
    var isDarkTheme by rememberSaveable { mutableStateOf(false) }

    Carteirinha_WillTheme(
        darkTheme = isDarkTheme,
        dynamicColor = false
    ) {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
            container = container,
            isDarkTheme = isDarkTheme,
            onToggleDarkTheme = { isDarkTheme = !isDarkTheme }
        )
    }
}
