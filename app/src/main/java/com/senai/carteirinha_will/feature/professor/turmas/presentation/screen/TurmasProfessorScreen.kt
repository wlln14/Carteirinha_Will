package com.senai.carteirinha_will.feature.professor.turmas.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.feature.professor.model.TurmasProfessor

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun TurmasProfessorScreen(
    turmas: List<TurmasProfessor> = emptyList(),
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme

    if (turmas.isEmpty()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colors.background)
                .padding(horizontal = 24.dp, vertical = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.surface, RoundedCornerShape(16.dp))
                    .padding(24.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .widthCompat(38.dp)
                            .height(4.dp)
                            .background(LaranjaSenai, RoundedCornerShape(4.dp))
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = "Nenhuma turma disponível",
                        style = MaterialTheme.typography.titleLarge,
                        color = colors.onSurface,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Quando as turmas forem disponibilizadas para sua conta, elas aparecerão nesta tela.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = colors.onSurfaceVariant,
                        lineHeight = 21.sp
                    )
                }
            }
        }
        return
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(horizontal = 16.dp, vertical = 18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Suas turmas",
                style = MaterialTheme.typography.titleLarge,
                color = colors.onSurface,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        items(turmas) { turma ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = colors.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = turma.nome,
                        style = MaterialTheme.typography.titleMedium,
                        color = colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    InfoLinhaProfessor(rotulo = "Curso", valor = turma.curso)
                    InfoLinhaProfessor(rotulo = "Alunos", valor = turma.quantidadeAlunos.toString())
                    InfoLinhaProfessor(rotulo = "Horário", valor = turma.horario)
                    InfoLinhaProfessor(rotulo = "Semestre", valor = turma.semestre)
                }
            }
        }
    }
}

@Composable
private fun InfoLinhaProfessor(rotulo: String, valor: String) {
    val colors = MaterialTheme.colorScheme
    androidx.compose.foundation.layout.Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(rotulo, color = colors.onSurfaceVariant, style = MaterialTheme.typography.bodyMedium)
        Text(valor.ifBlank { "Não informado" }, color = colors.onSurface, style = MaterialTheme.typography.bodyMedium)
    }
}
