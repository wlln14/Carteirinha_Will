package com.senai.carteirinha_will.feature.Home_Aluno.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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

private val AzulSenai = Color(0xFF2145B5)
private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6F8))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulSenai, RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                .padding(horizontal = 24.dp, vertical = 30.dp)
        ) {
            Text(
                text = "ÁREA DO ALUNO",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = "Olá, Willian!",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Bem-vindo à sua área do aluno.",
                color = Color.White.copy(alpha = 0.9f),
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
                color = Color(0xFF292929),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
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
                            .height(58.dp)
                            .background(LaranjaSenai, RoundedCornerShape(4.dp))
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Column {
                        Text(
                            text = "Willian Gama",
                            color = Color(0xFF252525),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Desenvolvimento de Sistemas",
                            color = Color(0xFF666666),
                            fontSize = 13.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Acesso rápido",
                color = Color(0xFF292929),
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

            Spacer(modifier = Modifier.height(34.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_senai),
                contentDescription = "Logo SENAI",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(130.dp)
                    .padding(bottom = 22.dp)
            )
        }
    }
}
