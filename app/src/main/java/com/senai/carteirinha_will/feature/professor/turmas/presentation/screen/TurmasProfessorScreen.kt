package com.senai.carteirinha_will.feature.professor.turmas.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senai.carteirinha_will.feature.professor.turmas.presentation.TurmasProfessorViewModel
import com.senai.carteirinha_will.feature.professor.turmas.presentation.component.TurmasProfessorCard

@Composable
fun TurmasProfessorScreen(
    modifier: Modifier = Modifier,
    viewModel: TurmasProfessorViewModel
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val colors = MaterialTheme.colorScheme
    LaunchedEffect(viewModel) { viewModel.carregar() }

    Box(modifier.fillMaxSize().background(colors.background)) {
        when {
            state.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
            state.errorMessage != null -> Column(Modifier.align(Alignment.Center).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Não foi possível carregar as turmas", fontWeight = FontWeight.Bold, color = colors.primary)
                Spacer(Modifier.height(8.dp))
                Text(state.errorMessage ?: "", color = colors.onSurfaceVariant)
            }
            state.unidades.isEmpty() -> Text("Nenhuma turma encontrada.", Modifier.align(Alignment.Center), color = colors.onSurfaceVariant)
            else -> LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(18.dp)
            ) {
                item {
                    Column(Modifier.padding(bottom = 6.dp)) {
                        Text("Suas turmas", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = colors.primary)
                        Spacer(Modifier.height(6.dp))
                        Text("Consulte suas turmas, horários e alunos", color = colors.onSurfaceVariant)
                    }
                }
                items(state.unidades, key = { it.id }) { turma ->
                    TurmasProfessorCard(modifier = Modifier.fillMaxWidth(), turma = turma)
                }
            }
        }
    }
}