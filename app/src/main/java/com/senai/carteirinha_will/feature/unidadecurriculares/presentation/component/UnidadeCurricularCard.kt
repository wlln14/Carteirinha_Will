package com.senai.carteirinha_will.feature.unidadecurriculares.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.feature.unidadecurriculares.Domain.model.UnidadeCurricular

private val AzulSenai = Color(0xFF2145B5)
private val LaranjaSenai = Color(0xFFFF643C)

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = unidadeCurricular.nome,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = AzulSenai
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(LaranjaSenai, RoundedCornerShape(50))
            )

            Text(
                text = "Professor: ${unidadeCurricular.professor}",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF626B7A)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF2F5FC), RoundedCornerShape(12.dp))
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NotaItem(titulo = "Nota 1", valor = unidadeCurricular.nota1.toString(), modifier = Modifier.weight(1f))
                NotaItem(titulo = "Nota 2", valor = unidadeCurricular.nota2.toString(), modifier = Modifier.weight(1f))
                NotaItem(titulo = "Média", valor = unidadeCurricular.media.toString(), modifier = Modifier.weight(1f))
            }

            Text(
                text = "Faltas: ${unidadeCurricular.faltas}",
                modifier = Modifier
                    .background(Color(0xFFFFF0EB), RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFD94D2B),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun NotaItem(
    titulo: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = titulo,
            fontSize = 12.sp,
            color = Color(0xFF697386)
        )
        Text(
            text = valor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AzulSenai
        )
    }
}