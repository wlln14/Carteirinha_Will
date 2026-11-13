package com.senai.carteirinha_will.feature.admin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senai.carteirinha_will.core.model.PerfilSolicitado
import com.senai.carteirinha_will.feature.admin.domain.model.AtribuicaoDocente
import com.senai.carteirinha_will.feature.admin.presentation.GestaoSolicitacoesUiState
import com.senai.carteirinha_will.feature.admin.presentation.component.DetalheSolicitacao
import com.senai.carteirinha_will.feature.admin.presentation.component.SolicitacaoCard

@Composable
fun GestaoSolicitacoesContent(
    uiState: GestaoSolicitacoesUiState,
    modifier: Modifier = Modifier,
    onAbaChange: (PerfilSolicitado) -> Unit,
    onSelecionarSolicitacao: (String) -> Unit,
    onTurmaChange: (String) -> Unit,
    onMatriculaChange: (String) -> Unit,
    onAtribuicaoChange: (AtribuicaoDocente, Boolean) -> Unit,
    onAprovar: () -> Unit,
    onSolicitarRejeicao: () -> Unit,
    onCancelarRejeicao: () -> Unit,
    onRejeitar: () -> Unit,
    onVoltar: () -> Unit,
    onAtualizar: () -> Unit
) {
    Column(modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Gestão de Solicitações de Acesso", style = MaterialTheme.typography.titleLarge)
        TabRow(selectedTabIndex = if (uiState.aba == PerfilSolicitado.ALUNO) 0 else 1) {
            PerfilSolicitado.entries.forEach { perfil ->
                Tab(selected = uiState.aba == perfil,
                    onClick = { onAbaChange(perfil) },
                    text = { Text(if (perfil == PerfilSolicitado.ALUNO) "Alunos" else "Professores") })
            }
        }
        if (uiState.isLoading) LinearProgressIndicator(Modifier.fillMaxWidth())
        uiState.errorMessage?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        uiState.mensagem?.let { Text(it, color = MaterialTheme.colorScheme.primary) }
        if (uiState.selecionado == null) {
            if (!uiState.isLoading && uiState.pendentes.isEmpty()) {
                Text("Nenhuma solicitação pendente nesta aba.")
            }
            uiState.pendentes.forEach { candidato ->
                SolicitacaoCard(candidato, onClick = { onSelecionarSolicitacao(candidato.id) })
            }
            OutlinedButton(onClick = onAtualizar, enabled = !uiState.isLoading) {
                Text("Atualizar")
            }
        } else {
            DetalheSolicitacao(
                uiState = uiState,
                onTurmaChange = onTurmaChange,
                onMatriculaChange = onMatriculaChange,
                onAtribuicaoChange = onAtribuicaoChange,
                onAprovar = onAprovar,
                onSolicitarRejeicao = onSolicitarRejeicao,
                onVoltar = onVoltar
            )
        }
    }
    if (uiState.confirmarRejeicao && uiState.selecionado != null) {
        AlertDialog(
            onDismissRequest = onCancelarRejeicao,
            title = { Text("Confirmar rejeição") },
            text = { Text("O cadastro será excluído permanentemente. Deseja continuar?") },
            confirmButton = {
                TextButton(onClick = onRejeitar) { Text("Rejeitar e excluir") }
            },
            dismissButton = {
                TextButton(onClick = onCancelarRejeicao) { Text("Cancelar") }
            }
        )
    }
}