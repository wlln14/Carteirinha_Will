package com.senai.carteirinha_will.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.senai.carteirinha_will.app.di.AppContainer
import com.senai.carteirinha_will.app.navigation.aluno.alunoNavGraph
import com.senai.carteirinha_will.app.navigation.auth.authNavGraph
import com.senai.carteirinha_will.app.navigation.professor.professorNavGraph
import com.senai.carteirinha_will.app.session.SessionViewModel
import com.senai.carteirinha_will.app.session.SessionViewModelFactory
import com.senai.carteirinha_will.feature.login.domain.model.PerfilAcesso

@Composable
fun AppNavHost(
    navController: NavHostController,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    container: AppContainer
) {
    val sessionFactory = remember(container.sessionTokenStore) {
        SessionViewModelFactory(sessionTokenStore = container.sessionTokenStore)
    }
    val sessionViewModel: SessionViewModel = viewModel(factory = sessionFactory)

    fun graphFor(perfil: PerfilAcesso) = when (perfil) {
        PerfilAcesso.ALUNO -> GraphRoutes.ALUNO
        PerfilAcesso.PROFESSOR -> GraphRoutes.PROFESSOR
    }
    fun replaceGraph(currentGraph: String, destinationGraph: String) {
        navController.navigate(destinationGraph) {
            popUpTo(currentGraph) { inclusive = true }
            launchSingleTop = true
        }
    }

    NavHost(navController = navController, startDestination = GraphRoutes.AUTH) {
        authNavGraph(
            loginRepository = container.loginRepository,
            onLoginSucesso = { usuario ->
                sessionViewModel.setUsuarioLogado(usuario)
                replaceGraph(GraphRoutes.AUTH, graphFor(usuario.perfil))
            }
        )
        alunoNavGraph(
            navController = navController,
            usuarioLogadoFlow = sessionViewModel.usuarioLogado,
            unidadeCurricularRepository = container.unidadeCurricularRepository,
            darkTheme = darkTheme,
            onDarkThemeChange = onDarkThemeChange,
            onLogout = {
                sessionViewModel.limparSessao()
                replaceGraph(GraphRoutes.ALUNO, GraphRoutes.AUTH)
            },
            onSessaoAusente = { replaceGraph(GraphRoutes.ALUNO, GraphRoutes.AUTH) },
            onPerfilInvalido = { perfil -> replaceGraph(GraphRoutes.ALUNO, graphFor(perfil)) }
        )
        professorNavGraph(
            navController = navController,
            usuarioLogadoFlow = sessionViewModel.usuarioLogado,
            turmasProfessorRepository = container.turmasProfessorRepository,
            unidadeCurricularProfessorRepository = container.unidadeCurricularProfessorRepository,
            darkTheme = darkTheme,
            onDarkThemeChange = onDarkThemeChange,
            onLogout = {
                sessionViewModel.limparSessao()
                replaceGraph(GraphRoutes.PROFESSOR, GraphRoutes.AUTH)
            },
            onSessaoAusente = { replaceGraph(GraphRoutes.PROFESSOR, GraphRoutes.AUTH) },
            onPerfilInvalido = { perfil -> replaceGraph(GraphRoutes.PROFESSOR, graphFor(perfil)) }
        )
    }
}