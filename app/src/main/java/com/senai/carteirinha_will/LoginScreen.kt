package com.senai.carteirinha_will.Screens

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senai.carteirinha_will.Navigation.Routes
import com.senai.carteirinha_will.R

@Composable
fun LoginScreen(navController: NavController) {

    // Guarda o texto digitado no campo Login
    var login by remember {
        mutableStateOf("")
    }

    // Guarda o texto digitado no campo Senha
    var senha by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 40.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.weight(1f))

        // Campo Login
        OutlinedTextField(
            value = login,
            onValueChange = {
                login = it
            },
            placeholder = {
                Text(
                    text = "Login",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            },
            shape = RoundedCornerShape(18.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF2145B5),
                unfocusedBorderColor = Color(0xFF2145B5),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        // Linha vermelha
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(2.dp)
                .background(Color(0xFFFF5B3D))
        )

        Spacer(modifier = Modifier.height(35.dp))

        // Campo Senha
        OutlinedTextField(
            value = senha,
            onValueChange = {
                senha = it
            },
            placeholder = {
                Text(
                    text = "Senha",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(18.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF2145B5),
                unfocusedBorderColor = Color(0xFF2145B5),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        // Botão
        Button(
            onClick = {
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Login.route) {
                        inclusive = true
                    }
                }
            },

            shape = RoundedCornerShape(50.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF643C)
            ),

            modifier = Modifier
                .width(120.dp)
                .height(45.dp)

        ) {

            Text(
                text = "ENTRAR",
                color = Color(0xFF2145B5),
                fontWeight = FontWeight.Bold
            )

        }

        Spacer(modifier = Modifier.weight(1f))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_senai),
            contentDescription = "Logo SENAI",
            modifier = Modifier.width(180.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
    }
}