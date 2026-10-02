package com.senai.carteirinha_will.feature.Home_Aluno.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senai.carteirinha_will.App.Navigation.Routes
import com.senai.carteirinha_will.R
import com.senai.carteirinha_will.feature.Home_Aluno.component.BotaoNavegacao
import com.senai.carteirinha_will.feature.Login.domain.model.UsuarioLogado

private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun HomeScreen(
    navController: NavController,
    usuario: UsuarioLogado,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    onLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme
    val backgroundColor = colors.background
    val cardColor = colors.surface
    val primaryTextColor = colors.onSurface
    val secondaryTextColor = colors.onSurfaceVariant
    val turmaColor = colors.primary

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.primary, RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                .padding(horizontal = 24.dp, vertical = 22.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ÁREA DO ALUNO",
                    color = colors.onPrimary.copy(alpha = 0.85f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(
                        onClick = onToggleDarkTheme,
                        colors = ButtonDefaults.textButtonColors(contentColor = colors.onPrimary),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = if (isDarkTheme) "☀ Claro" else "☾ Escuro",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    TextButton(
                        onClick = onLogout,
                        colors = ButtonDefaults.textButtonColors(contentColor = colors.onPrimary),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text("Sair", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }

            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = "Olá, ${usuario.nome.substringBefore(" ").ifBlank { "Aluno" }}!",
                color = colors.onPrimary,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Bem-vindo à sua área do aluno.",
                color = colors.onPrimary.copy(alpha = 0.9f),
                fontSize = 14.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Seus dados",
                color = primaryTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(4.dp)
                            .height(76.dp)
                            .background(LaranjaSenai, RoundedCornerShape(4.dp))
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = usuario.nome.ifBlank { "Nome não informado" },
                            color = primaryTextColor,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = usuario.curso.ifBlank { "Curso não informado" },
                            color = secondaryTextColor,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Turma: ${usuario.turma.ifBlank { "Não informada" }}",
                            color = turmaColor,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Acesso rápido",
                color = primaryTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(14.dp))

            BotaoNavegacao(
                text = "Minha carteirinha",
                onClick = { navController.navigate(Routes.Carteirinha.route) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            BotaoNavegacao(
                text = "Unidades curriculares",
                onClick = { navController.navigate(Routes.UnidadeCurricularAluno.route) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 28.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_senai),
                    contentDescription = "Logo SENAI",
                    modifier = Modifier.width(120.dp)
                )
            }
        }
    }
}
