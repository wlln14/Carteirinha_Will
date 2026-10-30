package com.senai.carteirinha_will.app.navigation.professor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.senai.carteirinha_will.app.navigation.GraphRoutes
import com.senai.carteirinha_will.app.navigation.ProfileGuard
import com.senai.carteirinha_will.app.ui.AppShell
import com.senai.carteirinha_will.feature.login.domain.model.PerfilAcesso
import com.senai.carteirinha_will.feature.login.domain.model.UsuarioLogado
import com.senai.carteirinha_will.feature.professor.home.presentation.screen.HomeProfessorScreen
import com.senai.carteirinha_will.feature.professor.turmas.domain.repository.TurmasProfessorRepository
import com.senai.carteirinha_will.feature.professor.turmas.presentation.TurmasProfessorViewModel
import com.senai.carteirinha_will.feature.professor.turmas.presentation.factory.TurmasProfessorViewModelFactory
import com.senai.carteirinha_will.feature.professor.turmas.presentation.screen.TurmasProfessorScreen
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.repository.UnidadeCurricularProfessorRepository
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.presentation.UnidadeCurricularProfessorViewModel
import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.presentation.factory.UnidadeCurricularProfessorViewModelFactory
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.presentation.screen.UnidadesCurricularesProfessorScreen
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    navController: NavHostController,
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    turmasProfessorRepository: TurmasProfessorRepository,
    unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = ProfessorRoutes.HOME, route = GraphRoutes.PROFESSOR) {
        composable(ProfessorRoutes.HOME) {
            ProfileGuard(usuarioFlow = usuarioLogadoFlow, perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente, onPerfilInvalido = onPerfilInvalido) { usuario ->
                AppShell(title = "Início", usuarioLogado = usuario, canNavigateBack = false,
                    darkTheme = darkTheme, onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {}, onLogout = onLogout) { innerPadding ->
                    HomeProfessorScreen(usuarioLogado = usuario,
                        onTurmasClick = { navController.navigate(ProfessorRoutes.TURMAS) },
                        onUnidadesCurricularesClick = { navController.navigate(ProfessorRoutes.UNIDADES_CURRICULARES) },
                        modifier = Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
        composable(ProfessorRoutes.TURMAS) {
            ProfileGuard(usuarioFlow = usuarioLogadoFlow, perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente, onPerfilInvalido = onPerfilInvalido) { usuario ->
                val factory = remember(turmasProfessorRepository) { TurmasProfessorViewModelFactory(turmasProfessorRepository) }
                val vm: TurmasProfessorViewModel = viewModel(factory = factory)
                AppShell(title = "Minhas Turmas", usuarioLogado = usuario, canNavigateBack = true,
                    darkTheme = darkTheme, onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() }, onLogout = onLogout) { innerPadding ->
                    TurmasProfessorScreen(viewModel = vm, modifier = Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
        composable(ProfessorRoutes.UNIDADES_CURRICULARES) {
            ProfileGuard(usuarioFlow = usuarioLogadoFlow, perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente, onPerfilInvalido = onPerfilInvalido) { usuario ->
                val factory = remember(unidadeCurricularProfessorRepository) {
                    UnidadeCurricularProfessorViewModelFactory(unidadeCurricularProfessorRepository)
                }
                val vm: UnidadeCurricularProfessorViewModel = viewModel(factory = factory)
                AppShell(title = "Unidades Curriculares", usuarioLogado = usuario, canNavigateBack = true,
                    darkTheme = darkTheme, onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() }, onLogout = onLogout) { innerPadding ->
                    UnidadesCurricularesProfessorScreen(viewModel = vm,
                        modifier = Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}