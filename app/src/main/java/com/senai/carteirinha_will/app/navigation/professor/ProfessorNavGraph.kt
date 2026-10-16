package com.senai.carteirinha_will.app.navigation.professor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.senai.carteirinha_will.app.navigation.GraphRoutes
import com.senai.carteirinha_will.app.navigation.ProfileGuard
import com.senai.carteirinha_will.app.ui.AppShell
import com.senai.carteirinha_will.feature.login.domain.model.PerfilAcesso
import com.senai.carteirinha_will.feature.login.domain.model.UsuarioLogado
import com.senai.carteirinha_will.feature.professor.home.presentation.screen.HomeProfessorScreen
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = ProfessorRoutes.HOME, route = GraphRoutes.PROFESSOR) {
        composable(route = ProfessorRoutes.HOME) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = onLogout
                ) { innerPadding ->
                    HomeProfessorScreen(
                        usuarioLogado = usuario,
                        onTurmasClick = {},
                        onUnidadesCurricularesClick = {},
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}
