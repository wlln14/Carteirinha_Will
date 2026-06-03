package com.senai.carteirinha_will

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Email"
                )
            }
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Senha"
                )
            }
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(.6f)
        ) {
            Text (
                text = "Entrar"
            )
        }
    }
}
    @Preview(showBackground = true, 
        showSystemUi = true)
    @Composable fun LoginScreenPreview() {
        LoginScreen()
    }
