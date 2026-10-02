package com.senai.carteirinha_will.App.Navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinha_will.App.di.AppContainer
import com.senai.carteirinha_will.App.session.SessionViewModel
import com.senai.carteirinha_will.App.session.SessionViewModelFactory
import com.senai.carteirinha_will.feature.Carteirinha.Presentation.screen.CarteirinhaScreen
import com.senai.carteirinha_will.feature.Home_Aluno.presentation.screen.HomeScreen
import com.senai.carteirinha_will.feature.Login.presentation.factory.LoginViewModelFactory
import com.senai.carteirinha_will.feature.Login.presentation.LoginViewModel
import com.senai.carteirinha_will.feature.Login.presentation.screen.LoginScreen
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.factory.UnidadeCurricularViewModelFactory
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    container: AppContainer,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit
) {
    val sessionFactory = remember(container.authTokenStore) {
        SessionViewModelFactory(container.authTokenStore)
    }
    val sessionViewModel: SessionViewModel = viewModel(factory = sessionFactory)
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(route = Routes.Login.route) {
            val loginFactory = remember(container.loginRepository) {
                LoginViewModelFactory(container.loginRepository)
            }
            val loginViewModel: LoginViewModel = viewModel(factory = loginFactory)

            LoginScreen(
                navController = navController,
                viewModel = loginViewModel,
                onLoginSucesso = { usuario ->
                    sessionViewModel.setUsuarioLogado(usuario)
                    navController.navigate(Routes.Home_Aluno.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(route = Routes.Home_Aluno.route) {
            val usuario = usuarioLogado
            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Home_Aluno.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        usuario = usuario,
                        isDarkTheme = isDarkTheme,
                        onToggleDarkTheme = onToggleDarkTheme,
                        onLogout = {
                            sessionViewModel.limparSession()
                            navController.navigate(Routes.Login.route) {
                                popUpTo(Routes.Home_Aluno.route) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }

        composable(route = Routes.Carteirinha.route) {
            if (usuarioLogado == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Carteirinha.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarteirinhaScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }

        composable(route = Routes.UnidadeCurricularAluno.route) {
            if (usuarioLogado == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.UnidadeCurricularAluno.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                val unidadeCurricularFactory = remember(container.unidadeCurricularRepository) {
                    UnidadeCurricularViewModelFactory(container.unidadeCurricularRepository)
                }
                val unidadeCurricularViewModel: UnidadeCurricularViewModel =
                    viewModel(factory = unidadeCurricularFactory)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnidadeCurricularScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = unidadeCurricularViewModel
                    )
                }
            }
        }
    }
}
