package com.senai.carteirinha_will.App

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinha_will.Core.designSystem.Theme.Carteirinha_WillTheme
import com.senai.carteirinha_will.App.Navigation.AppNavHost
import com.senai.carteirinha_will.App.di.AppContainer

@Composable
fun App (container: AppContainer)
{
    Carteirinha_WillTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
            container = container
        )
    }
}