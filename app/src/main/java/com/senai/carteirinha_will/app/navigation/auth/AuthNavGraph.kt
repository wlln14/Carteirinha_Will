package com.senai.carteirinha_will.app.navigation.auth

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.senai.carteirinha_will.app.navigation.GraphRoutes
import com.senai.carteirinha_will.feature.login.domain.model.UsuarioLogado
import com.senai.carteirinha_will.feature.login.domain.repository.LoginRepository
import com.senai.carteirinha_will.feature.login.presentation.LoginViewModel
import com.senai.carteirinha_will.feature.login.presentation.factory.LoginViewModelFactory
import com.senai.carteirinha_will.feature.login.presentation.screen.LoginScreen

fun NavGraphBuilder.authNavGraph(
    loginRepository: LoginRepository,
    onLoginSucesso: (UsuarioLogado) -> Unit
) {
    navigation(
        startDestination = AuthRoutes.LOGIN,
        route = GraphRoutes.AUTH
    ) {
        composable(route = AuthRoutes.LOGIN) {
            val factory = remember(loginRepository) {
                LoginViewModelFactory(
                    repository = loginRepository
                )
            }

            val loginViewModel: LoginViewModel = viewModel(
                factory = factory
            )

            LoginScreen(
                viewModel = loginViewModel,
                onLoginSucesso = onLoginSucesso
            )
        }
    }
}