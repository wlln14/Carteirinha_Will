
package com.senai.carteirinha_will.feature.professor.turmas.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.feature.professor.turmas.domain.model.TurmasProfessor

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun TurmasProfessorCard(
    modifier: Modifier = Modifier,
    turma: TurmasProfessor
) {
    val colors = MaterialTheme.colorScheme

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = colors.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Nome da turma
            Text(
                text = turma.nome,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colors.primary
            )

            // Divisor laranja
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(
                        LaranjaSenai,
                        RoundedCornerShape(50)
                    )
            )

            // Curso
            Text(
                text = "Curso: ${turma.curso}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = colors.onSurfaceVariant
            )

            // Quantidade de alunos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colors.surfaceVariant,
                        RoundedCornerShape(12.dp)
                    )
                    .padding(
                        vertical = 12.dp,
                        horizontal = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InformacaoTurma(
                    titulo = "Alunos",
                    valor = turma.quantidadeAlunos.toString(),
                    modifier = Modifier.weight(1f)
                )

                InformacaoTurma(
                    titulo = "Semestre",
                    valor = turma.semestre,
                    modifier = Modifier.weight(1f)
                )
            }

            // Dias da semana
            Text(
                text = "Dias: ${turma.diasSemana}",
                style = MaterialTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant
            )

            // Horário das aulas
            Text(
                text = "Horário: ${turma.horarioInicio} - ${turma.horarioFim}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = colors.onSurface
            )

            // Horário descritivo adicional
            if (turma.horario.isNotBlank()) {
                Text(
                    text = turma.horario,
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.onSurfaceVariant
                )
            }

            // Resumo da turma
            Text(
                text = "${turma.quantidadeAlunos} alunos matriculados",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (colors.surface == Color.White) {
                            Color(0xFFFFF0EB)
                        } else {
                            Color(0xFF3A2928)
                        },
                        RoundedCornerShape(8.dp)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 8.dp
                    ),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = if (colors.surface == Color.White) {
                    Color(0xFFD94D2B)
                } else {
                    Color(0xFFFFA58D)
                },
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun InformacaoTurma(
    titulo: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = titulo,
            fontSize = 12.sp,
            color = colors.onSurfaceVariant
        )

        Text(
            text = valor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colors.primary
        )
    }
}
