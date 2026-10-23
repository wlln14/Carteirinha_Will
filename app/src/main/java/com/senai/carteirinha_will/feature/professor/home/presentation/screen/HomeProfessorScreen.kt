package com.senai.carteirinha_will.feature.professor.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.core.designsystem.component.NavigationButton
import com.senai.carteirinha_will.core.designsystem.theme.Carteirinha_WillTheme
import com.senai.carteirinha_will.feature.aluno.home.presentation.component.BotaoNavegacao
import com.senai.carteirinha_will.feature.login.domain.model.PerfilAcesso
import com.senai.carteirinha_will.feature.login.domain.model.UsuarioLogado

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun HomeProfessorScreen(
    usuarioLogado: UsuarioLogado,
    onTurmasClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colors.primary,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Text(
                text = "ÁREA DO PROFESSOR",
                color = colors.onPrimary.copy(alpha = 0.85f),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Olá, ${usuarioLogado.nome.substringBefore(" ").ifBlank { "Professor" }}!",
                color = colors.onPrimary,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Bem-vindo à sua área do professor.",
                color = colors.onPrimary.copy(alpha = 0.9f),
                fontSize = 14.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Seus dados",
                color = colors.onSurface,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = colors.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                androidx.compose.foundation.layout.Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(68.dp)
                            .background(LaranjaSenai, RoundedCornerShape(4.dp))
                            .padding(horizontal = 2.dp)
                    )
                    androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = usuarioLogado.nome.ifBlank { "Nome não informado" },
                            color = colors.onSurface,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Professor",
                            color = colors.onSurfaceVariant,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Matrícula: ${usuarioLogado.matricula.ifBlank { "Não informada" }}",
                            color = colors.primary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Acesso rápido",
                color = colors.onSurface,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(14.dp))

            BotaoNavegacao(
                text = "Minhas turmas",
                onClick = onTurmasClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            BotaoNavegacao(
                text = "Unidades curriculares",
                onClick = onUnidadesCurricularesClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "Consulte suas turmas e unidades curriculares pelos atalhos acima.",
                color = colors.onSurfaceVariant,
                fontSize = 13.sp,
                lineHeight = 19.sp,
                modifier = Modifier.padding(bottom = 28.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeProfessorPreview() {
    Carteirinha_WillTheme {
        HomeProfessorScreen(
            usuarioLogado = UsuarioLogado(
                id = "2",
                nome = "Professor Modelo",
                matricula = "PROF20260001",
                perfil = PerfilAcesso.PROFESSOR,
                curso = "",
                turma = "",
                token = "token"
            ),
            onTurmasClick = {},
            onUnidadesCurricularesClick = {}
        )
    }
}
