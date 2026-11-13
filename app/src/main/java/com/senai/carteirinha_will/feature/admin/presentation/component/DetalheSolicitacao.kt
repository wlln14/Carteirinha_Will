package com.senai.carteirinha_will.feature.admin.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senai.carteirinha_will.core.model.PerfilSolicitado
import com.senai.carteirinha_will.feature.admin.domain.model.AtribuicaoDocente
import com.senai.carteirinha_will.feature.admin.presentation.GestaoSolicitacoesUiState


@Composable
fun DetalheSolicitacao(
    uiState: GestaoSolicitacoesUiState,
    onTurmaChange: (String) -> Unit,
    onMatriculaChange: (String) -> Unit,
    onAtribuicaoChange: (AtribuicaoDocente, Boolean) -> Unit,
    onAprovar: () -> Unit,
    onSolicitarRejeicao: () -> Unit,
    onVoltar: () -> Unit
) {
    val candidato = uiState.selecionado ?: return
    Text(candidato.nome, style = MaterialTheme.typography.titleMedium)
    Text("Login: ${candidato.login}")
    Text("Perfil solicitado: ${if (candidato.perfilSolicitado == PerfilSolicitado.ALUNO) "Aluno" else "Professor"}")
    if (candidato.perfilSolicitado == PerfilSolicitado.ALUNO) {
        Text("Curso solicitado: ${candidato.cursoSolicitado}")
        Text("Selecione a turma deste curso")
        uiState.turmasDisponiveis.forEach { turma ->
            Row {
                RadioButton(selected = uiState.turmaSelecionada == turma.codigo,
                    onClick = { onTurmaChange(turma.codigo) })
                Text(turma.codigo, Modifier.padding(top = 12.dp))
            }
        }
        if (uiState.turmasDisponiveis.isEmpty()) Text("Nenhuma turma disponível para o curso solicitado.")
        OutlinedTextField(
            value = uiState.matricula,
            onValueChange = onMatriculaChange,
            label = { Text("Matrícula institucional") },
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        Text("Vincule o professor a uma ou mais turmas e unidades curriculares")
        uiState.turmas.forEach { turma ->
            Text("${turma.codigo} • ${turma.curso}", style = MaterialTheme.typography.titleMedium)
            turma.unidadesCurriculares.forEach { uc ->
                val atribuicao = AtribuicaoDocente(turma.codigo, uc)
                Row {
                    Checkbox(
                        checked = atribuicao in uiState.atribuicoes,
                        onCheckedChange = { marcado -> onAtribuicaoChange(atribuicao, marcado) }
                    )
                    Text(uc, Modifier.padding(top = 12.dp))
                }
            }
        }
    }
    Button(onClick = onAprovar, enabled = uiState.podeAprovar, modifier = Modifier.fillMaxWidth()) {
        Text("Aprovar solicitação")
    }
    OutlinedButton(
        onClick = onSolicitarRejeicao,
        enabled = !uiState.isLoading,
        modifier = Modifier.fillMaxWidth()
    ) { Text("Rejeitar e excluir cadastro") }
    TextButton(onClick = onVoltar) { Text("Voltar à lista") }
}