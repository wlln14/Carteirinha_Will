package com.senai.carteirinha_will.Core.designSystem.Theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF9DB5FF),
    onPrimary = Color(0xFF10214D),
    secondary = Color(0xFFFF987A),
    onSecondary = Color(0xFF3B160C),
    tertiary = Color(0xFFFFB86B),
    background = Color(0xFF12151C),
    onBackground = Color(0xFFF1F3F8),
    surface = Color(0xFF202633),
    onSurface = Color(0xFFF1F3F8),
    surfaceVariant = Color(0xFF30394A),
    onSurfaceVariant = Color(0xFFD0D6E2)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun Carteirinha_WillTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
