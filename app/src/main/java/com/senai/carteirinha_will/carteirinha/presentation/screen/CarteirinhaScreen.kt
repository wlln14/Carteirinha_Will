package com.senai.carteirinha_will.carteirinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.R
import com.senai.carteirinha_will.carteirinha.presentation.component.QrCode

@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))


        // Título
        Text(
            text = "Sua carteirinha",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2145B5)
        )


        Spacer(modifier = Modifier.height(40.dp))


        // Foto do aluno
        Box(
            modifier = Modifier
                .size(140.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFFFF643C),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = "Foto do aluno",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )

        }


        Spacer(modifier = Modifier.height(12.dp))


        Text(
            text = "Foto do aluno",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(40.dp))


        // Caixa do QR Code
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(210.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFFFF643C),
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            QrCode(
                conteudo = "90000000001756147983",
                modifier = Modifier.size(170.dp)
            )

        }


        Spacer(modifier = Modifier.weight(1f))


        // Logo SENAI
        Image(
            painter = painterResource(id = R.drawable.logo_senai),
            contentDescription = "Logo SENAI",
            modifier = Modifier.width(190.dp)
        )


        Spacer(modifier = Modifier.height(25.dp))
    }
}