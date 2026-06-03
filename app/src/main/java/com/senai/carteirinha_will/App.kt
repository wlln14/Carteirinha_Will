package com.senai.carteirinha_will

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinha_will.Core.designSystem.Theme.Carteirinha_WillTheme
import com.senai.carteirinha_will.Navigation.AppNavHost

@Composable
fun App ()
{
    Carteirinha_WillTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController
        )
    }
}