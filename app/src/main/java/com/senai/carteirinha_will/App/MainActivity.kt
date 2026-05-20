package com.senai.carteirinha_will.App

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carteirinha_will.PerfilAluno
import com.senai.carteirinha_will.QrCode
import com.senai.carteirinha_will.R
import com.senai.carteirinha_will.Core.designSystem.Theme.Carteirinha_WillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Carteirinha_WillTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    carteirinhaDigitalApp(modifier = Modifier.Companion.padding(innerPadding))
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun carteirinhaDigitalApp(modifier: Modifier = Modifier.Companion) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "fundo",
                modifier = Modifier.Companion
                    .fillMaxSize()
                    .blur(
                        radiusX = 10.dp,
                        radiusY = 1.dp,
                        edgeTreatment = BlurredEdgeTreatment.Companion.Unbounded
                    ),
                contentScale = ContentScale.Companion.Crop
            )

            Column(
                modifier = Modifier.Companion.fillMaxSize(),
                horizontalAlignment = Alignment.Companion.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "Senai",
                    modifier = Modifier.Companion
                        .clip(RoundedCornerShape(16.dp))
                )

                PerfilAluno(nome = "Willian Gama", curso = "Desenvolvimento de Sistemas")

                QrCode(
                    conteudo = "90000000001756147983"
                )
            }


        }
        }

    }