package com.senai.carteirinha_will.feature.Login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinha_will.Navigation.Routes
import com.senai.carteirinha_will.R
import com.senai.carteirinha_will.feature.Login.domain.model.UsuarioLogado
import com.senai.carteirinha_will.feature.Login.presentation.LoginEvent
import com.senai.carteirinha_will.feature.Login.presentation.LoginViewModel

@Composable
fun LoginScreen(navController: NavController,
                modifier: Modifier = Modifier,
                viewModel: LoginViewModel = viewModel(),
                onLoginSucesso: (UsuarioLogado) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let {
            usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
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

        OutlinedTextField(
            value = uiState.usuario,
            onValueChange = { value ->
                viewModel.onEvent(LoginEvent.OnUsuarioChange(value))
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
            ),
            isError = uiState.erroMensage != null
        )

        Spacer(modifier = Modifier.height(35.dp))

        Box(
            modifier = Modifier
                .width(120.dp)
                .height(2.dp)
                .background(Color(0xFFFF5B3D))
        )

        Spacer(modifier = Modifier.height(35.dp))

        OutlinedTextField(
            value = uiState.senha,
            onValueChange = { value ->
                viewModel.onEvent(LoginEvent.OnSenhaChange(value))
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
            ),
            isError = uiState.erroMensage != null
        )

        uiState.erroMensage?.let { error ->
            Text(
                text = "Usuário ou senha inválidos",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth(0.85f)
                    .padding(0.dp, 25.dp, 0.dp, 0.dp)
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = {
                viewModel.onEvent(LoginEvent.OnEntrarClick)
            },

            shape = RoundedCornerShape(50.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF643C)
            ),

            modifier = Modifier
                .width(120.dp)
                .height(45.dp)

        ) {

            if (uiState.isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth(0.60f)
                        .height(5.dp),
                        color = Color.White,
                        trackColor = Color(0xFFFF643C)
                )
            } else {
                Text(
                    text = "ENTRAR",
                    color = Color(0xFF2145B5),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.logo_senai),
            contentDescription = "Logo SENAI",
            modifier = Modifier.width(180.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
    }
}

//@Composable
//@Preview(showSystemUi = true)
//fun LoginScreenPreview(){
//    LoginScreen(navController = rememberNavController())
//}