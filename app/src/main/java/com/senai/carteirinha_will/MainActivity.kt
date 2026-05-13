package com.senai.carteirinha_will

import android.graphics.BlurMaskFilter
import android.media.Image
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.ui.theme.Carteirinha_WillTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Carteirinha_WillTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    carteirinhaDigitalApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun carteirinhaDigitalApp(modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "fundo",
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radiusX = 10.dp,
                    radiusY = 1.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                ),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Senai",
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
            Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = "Foto de Perfil",
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp,
                            Color.White,
                            CircleShape)
            )


                Row() {
                    Text(
                        text = "Nome: ",
                        fontSize = 30.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Willian Gama",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }


                Row() {
                    Text(
                        text = "Curso: ",
                        fontSize = 30.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Desenvolvimento de Sistemas",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            QrCode(
                conteudo = "90000000001756147983"
            )
        }


    }
}

}

