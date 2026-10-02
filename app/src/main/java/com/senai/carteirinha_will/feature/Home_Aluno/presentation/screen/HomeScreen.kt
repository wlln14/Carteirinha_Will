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
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(38.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Olá, Willian!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = AzulSenai
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Bem-vindo à sua área do aluno.",
                fontSize = 14.sp,
                color = Color(0xFF666666)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F8FA)),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Text(
                    text = "Dados acadêmicos",
                    color = AzulSenai,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "Willian Gama",
                    color = Color(0xFF292929),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Desenvolvimento de Sistemas",
                    color = Color(0xFF666666),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(14.dp))
                Box(
                    modifier = Modifier
                        .width(42.dp)
                        .height(3.dp)
                        .background(LaranjaSenai)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Acesse",
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF292929),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))

        BotaoNavegacao(
            text = "Carteirinha",
            onClick = { navController.navigate(Routes.Carteirinha.route) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(14.dp))
        BotaoNavegacao(
            text = "Unidades curriculares",
            onClick = { navController.navigate(Routes.UnidadeCurricularAluno.route) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(48.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_senai),
            contentDescription = "Logo SENAI",
            modifier = Modifier
                .width(145.dp)
                .padding(bottom = 24.dp)
        )
    }
}
