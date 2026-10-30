package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.model.UnidadeCurricularProfessor
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.presentation.component.UnidadeCurricularProfessorCard

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun UnidadesCurricularesProfessorScreen(
    unidades: List<UnidadeCurricularProfessor> = emptyList(),
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        if (unidades.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(24.dp)
                    .background(colors.surface, RoundedCornerShape(18.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Box(
                    modifier = Modifier
                        .width(58.dp)
                        .height(4.dp)
                        .background(LaranjaSenai, RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "Nenhuma unidade curricular disponível",
                    style = MaterialTheme.typography.titleLarge,
                    color = colors.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "As unidades curriculares aparecerão aqui quando forem disponibilizadas para sua conta.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.onSurfaceVariant,
                    lineHeight = 21.sp
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(
                    start = 18.dp,
                    top = 24.dp,
                    end = 18.dp,
                    bottom = 24.dp
                )
            ) {
                item {
                    Column(modifier = Modifier.padding(bottom = 6.dp)) {
                        Text(
                            text = "Suas unidades curriculares",
                            fontSize = 27.sp,
                            fontWeight = FontWeight.Bold,
                            color = colors.primary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Box(
                            modifier = Modifier
                                .width(58.dp)
                                .height(4.dp)
                                .background(LaranjaSenai, RoundedCornerShape(50))
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Acompanhe as turmas, horários e andamento das aulas",
                            fontSize = 14.sp,
                            color = colors.onSurfaceVariant
                        )
                    }
                }

                items(unidades, key = { it.id }) { unidade ->
                    UnidadeCurricularProfessorCard(
                        modifier = Modifier.fillMaxWidth(),
                        unidadeCurricular = unidade
                    )
                }
            }
        }
    }
}
