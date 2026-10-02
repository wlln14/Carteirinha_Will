package com.senai.carteirinha_will.feature.Home_Aluno.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senai.carteirinha_will.App.Navigation.Routes
import com.senai.carteirinha_will.R

private val SenaiBlue = Color(0xFF2145B5)
private val SenaiOrange = Color(0xFFFF643C)

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF4F6FB))
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                .background(
                    Brush.linearGradient(
                        colors = listOf(Color(0xFF18368F), SenaiBlue, Color(0xFF4268D1))
                    )
                )
                .padding(start = 26.dp, end = 26.dp, top = 48.dp, bottom = 42.dp)
        ) {
            Column {
                Text(
                    text = "ÁREA DO ALUNO",
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Olá, Willian!",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Que bom ter você por aqui.",
                    color = Color.White.copy(alpha = 0.88f),
                    fontSize = 15.sp
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Seu perfil acadêmico",
                color = Color(0xFF202A44),
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "ALUNO",
                        color = SenaiBlue,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Willian Gama",
                        color = Color(0xFF202A44),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Desenvolvimento de Sistemas",
                        color = Color(0xFF69738A),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Box(
                        modifier = Modifier
                            .width(54.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(50))
                            .background(SenaiOrange)
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "Acesso rápido",
                color = Color(0xFF202A44),
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(14.dp))

            HomeActionButton(
                title = "Minha carteirinha",
                subtitle = "Acesse seu QR Code e identificação",
                onClick = { navController.navigate(Routes.Carteirinha.route) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            HomeActionButton(
                title = "Unidades curriculares",
                subtitle = "Consulte notas, faltas e professores",
                onClick = { navController.navigate(Routes.UnidadeCurricularAluno.route) },
                outlined = true
            )

            Spacer(modifier = Modifier.height(34.dp))
            androidx.compose.foundation.Image(
                painter = androidx.compose.ui.res.painterResource(id = R.drawable.logo_senai),
                contentDescription = "Logo SENAI",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(150.dp)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
private fun HomeActionButton(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    outlined: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp),
        shape = RoundedCornerShape(18.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (outlined) Color.White else SenaiBlue,
            contentColor = if (outlined) SenaiBlue else Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = if (outlined) 1.dp else 3.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    subtitle,
                    fontSize = 11.sp,
                    color = if (outlined) Color(0xFF69738A) else Color.White.copy(alpha = 0.8f),
                    fontWeight = FontWeight.Normal
                )
            }
            Text("›", fontSize = 30.sp, fontWeight = FontWeight.Normal)
        }
    }
}
