package com.senai.carteirinha_will.Navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinha_will.HomeScreen
import com.senai.carteirinha_will.Screens.LoginScreen
import com.senai.carteirinha_will.carteirinha.presentation.screen.CarteirinhaScreen
import com.senai.carteirinha_will.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {

        composable(route = Routes.Login.route) {
            LoginScreen(
                navController = navController
            )
        }

        composable(route = Routes.Home.route) {
            HomeScreen(
                navController = navController
            )
        }

        composable(route = Routes.Carteirinha.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

        composable(route = Routes.UnidadeCurricular.route) {
            UnidadeCurricularScreen()
        }
    }
}