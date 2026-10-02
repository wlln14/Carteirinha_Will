package com.senai.carteirinha_will.Core.designSystem.Theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2145B5),
    onPrimary = Color.White,
    secondary = Color(0xFFE9957D),
    onSecondary = Color(0xFF32170F),
    tertiary = Color(0xFFE5B77D),
    background = Color(0xFF191E27),
    onBackground = Color(0xFFF1F3F8),
    surface = Color(0xFF262E3B),
    onSurface = Color(0xFFF1F3F8),
    surfaceVariant = Color(0xFF354052),
    onSurfaceVariant = Color(0xFFD9DFE9),
    outline = Color(0xFF78859A)
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
    outline = Color(0xFFD5D9E2)
)

@Composable
fun Carteirinha_WillTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
