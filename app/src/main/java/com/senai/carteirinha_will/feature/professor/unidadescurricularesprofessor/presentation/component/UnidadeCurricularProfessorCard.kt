package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.presentation.component

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
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.model.UnidadeCurricularProfessor

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun UnidadeCurricularProfessorCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricularProfessor
) {
    val colors = MaterialTheme.colorScheme

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = colors.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = unidadeCurricular.nome,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colors.primary
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(LaranjaSenai, RoundedCornerShape(50))
            )

            Text(
                text = "Turma: ${unidadeCurricular.turma}",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.surfaceVariant, RoundedCornerShape(12.dp))
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InformacaoUnidade(
                    titulo = "Carga horária",
                    valor = "${unidadeCurricular.cargaHoraria} h",
                    modifier = Modifier.weight(1f)
                )
                InformacaoUnidade(
                    titulo = "Total de aulas",
                    valor = unidadeCurricular.quantidadeAulas.toString(),
                    modifier = Modifier.weight(1f)
                )
                InformacaoUnidade(
                    titulo = "Realizadas",
                    valor = unidadeCurricular.aulasRealizadas.toString(),
                    modifier = Modifier.weight(1f)
                )
            }

            Text(
                text = "Dias: ${unidadeCurricular.diasSemana.joinToString(" • ") { it.lowercase().replaceFirstChar(Char::uppercase) }.ifBlank { "Não informado" }}",
                style = MaterialTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant
            )

            Text(
                text = "Horário: ${unidadeCurricular.horarioInicio} - ${unidadeCurricular.horarioFim}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = colors.onSurface
            )

            val percentual = if (unidadeCurricular.quantidadeAulas > 0) {
                (unidadeCurricular.aulasRealizadas * 100 / unidadeCurricular.quantidadeAulas).coerceIn(0, 100)
            } else {
                0
            }

            Text(
                text = "$percentual% das aulas realizadas",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (colors.surface == Color.White) Color(0xFFFFF0EB) else Color(0xFF3A2928),
                        RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = if (colors.surface == Color.White) Color(0xFFD94D2B) else Color(0xFFFFA58D),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun InformacaoUnidade(
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
            color = colors.onSurfaceVariant,
        )
        Text(
            text = valor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colors.primary
        )
    }
}
