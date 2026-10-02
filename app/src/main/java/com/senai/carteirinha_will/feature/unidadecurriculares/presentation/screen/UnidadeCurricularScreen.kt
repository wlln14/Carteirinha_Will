package com.senai.carteirinha_will.feature.unidadecurriculares.presentation.screen

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senai.carteirinha_will.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    viewModel: UnidadeCurricularViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val errorMessage = uiState.errorMessage
    val colors = MaterialTheme.colorScheme

    LaunchedEffect(Unit) { viewModel.carregar() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = colors.primary
                )
            }

            errorMessage != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(24.dp)
                        .background(colors.surface, RoundedCornerShape(18.dp))
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Não foi possível carregar as unidades",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = colors.primary
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = errorMessage,
                        color = colors.onSurfaceVariant
                    )
                }
            }

            uiState.listaUnidadesCurriculares.isEmpty() -> {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Nenhuma unidade curricular encontrada.",
                        color = AzulSenai,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Suas disciplinas aparecerão aqui.",
                        color = colors.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                }
            }

            else -> {
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
                                text = "Unidades Curriculares",
                                fontSize = 27.sp,
                                fontWeight = FontWeight.Bold,
                                color = AzulSenai
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
                                text = "Acompanhe suas notas e frequência",
                                fontSize = 14.sp,
                                color = colors.onSurfaceVariant
                            )
                        }
                    }

                    items(uiState.listaUnidadesCurriculares) { unidadeCurricular ->
                        UnidadeCurricularCard(
                            modifier = Modifier.fillMaxWidth(),
                            unidadeCurricular = unidadeCurricular
                        )
                    }
                }
            }
        }
    }
}