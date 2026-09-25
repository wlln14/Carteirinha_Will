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
import com.senai.carteirinha_will.feature.Home_Aluno.presentation.screen.HomeScreen
import com.senai.carteirinha_will.feature.Login.presentation.screen.LoginScreen
import com.senai.carteirinha_will.feature.Carteirinha.Presentation.screen.CarteirinhaScreen
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.factory.UnidadeCurricularViewModelFactory
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel(),
    container: AppContainer,
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()
    val usuario = usuarioLogado

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {

        composable(route = Routes.Login.route) {
            LoginScreen(
                navController = navController,
                onLoginSucesso = {
                    usuario ->
                        sessionViewModel.setUsuarioLogado(usuario)
                    navController.navigate(Routes.Home_Aluno.route)
                }
            )
        }

        composable(route = Routes.Home_Aluno.route) {
            val usuario = usuarioLogado

            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }

//        composable(route = Routes.Home_Professor.route) {
//            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                HomeProfessor(
//                    modifier = Modifier.padding(innerPadding),
//                    navController = navController
//                )
//            }
//        }

        composable(route = Routes.Carteirinha.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

//        composable(route = Routes.TurmasProfessor.route) {
//            Scaffold(
//                modifier = Modifier.fillMaxSize()
//            ) { innerPadding ->
//                TurmasProfessorScreen(
//                    modifier = Modifier.padding(innerPadding)
//                )
//            }
//        }

        composable(route = Routes.UnidadeCurricularAluno.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }

            } else {
                val unidadeCurricularFactory = remember(
                    container.unidadeCurricularRepository
                ) {
                    UnidadeCurricularViewModelFactory(
                        repository = container.unidadeCurricularRepository
                    )
                }

                val unidadeCurricularViewModel: UnidadeCurricularViewModel = viewModel(
                    factory = unidadeCurricularFactory
                )
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    UnidadeCurricularScreen(
                        modifier =Modifier.padding(innerPadding),
                        viewModel =unidadeCurricularViewModel
                    )
                }
            }
        }

//        composable(route = Routes.UnidadeCurricularProfessor.route) {
//            Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
//                UnidadeCurricularProfessorScreen(
//                    modifier = Modifier.padding(innerPadding)
//                )
//            }
//        }
    }
}