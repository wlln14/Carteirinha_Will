package com.senai.carteirinha_will

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.senai.carteirinha_will.Navigation.Routes
import com.senai.carteirinha_will.R

@Composable
fun HomeScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        // Título
        Text(
            text = "Olá aluno!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2145B5)
        )

        Spacer(modifier = Modifier.height(60.dp))

        // Nome do aluno
        Text(
            text = "Nome do aluno",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Box(
            modifier = Modifier
                .width(250.dp)
                .height(2.dp)
                .background(Color(0xFFFF643C))
        )

        Spacer(modifier = Modifier.height(35.dp))

        // Curso
        Text(
            text = "Curso atual",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Box(
            modifier = Modifier
                .width(250.dp)
                .height(2.dp)
                .background(Color(0xFFFF643C))
        )

        Spacer(modifier = Modifier.height(80.dp))

        // Botão Carteirinha
        Button(
            onClick = {
                navController.navigate(Routes.Carteirinha.route)
            },
            modifier = Modifier
                .width(205.dp)
                .height(50.dp),

            shape = RoundedCornerShape(15.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F56A9)
            )

        ) {

            Text(
                text = "CARTEIRINHA",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.height(35.dp))

        // Botão UCs
        Button(
            onClick = {
                navController.navigate(Routes.UnidadeCurricular.route)
            },
            modifier = Modifier
                .width(205.dp)
                .height(50.dp),

            shape = RoundedCornerShape(15.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F56A9)
            )

        ) {

            Text(
                text = "UCs",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.weight(1f))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_senai),
            contentDescription = "Logo SENAI",
            modifier = Modifier.width(190.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
    }
}