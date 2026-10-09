package com.senai.carteirinha_will.Core.designSystem.Theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    // Azul mais claro para manter a identidade SENAI e melhorar o contraste no escuro.
    primary = Color(0xFF5879D6),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFFFF8A65),
    onSecondary = Color(0xFF2B160F),
    tertiary = Color(0xFFE8BE82),
    background = Color(0xFF202735),
    onBackground = Color(0xFFF2F4F8),
    surface = Color(0xFF2A3445),
    onSurface = Color(0xFFF2F4F8),
    surfaceVariant = Color(0xFF354257),
    onSurfaceVariant = Color(0xFFD0D8E5),
    outline = Color(0xFF8492A8),
    error = Color(0xFFFF7B72),
    onError = Color(0xFF35110E)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2145B5),
    onPrimary = Color.White,
    secondary = Color(0xFFFF643C),
    onSecondary = Color.White,
    tertiary = Color(0xFF52658F),
    background = Color(0xFFF5F6F8),
    onBackground = Color(0xFF252525),
    surface = Color.White,
    onSurface = Color(0xFF252525),
    surfaceVariant = Color(0xFFF0F2F6),
    onSurfaceVariant = Color(0xFF626B7A),
    outline = Color(0xFFD5D9E2),
    error = Color(0xFFB3261E),
    onError = Color.White
)

@Composable
fun Carteirinha_WillTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // A paleta própria é usada nos dois modos para preservar a identidade visual do SENAI.
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
