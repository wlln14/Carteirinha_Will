package com.senai.carteirinha_will.Core.designSystem.Theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.R

private val googleFontProvider = Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val poppinsGoogleFont = GoogleFont("Poppins")

private val Poppins = FontFamily(
    Font(googleFont = poppinsGoogleFont, fontProvider = googleFontProvider, weight = FontWeight.Normal),
    Font(googleFont = poppinsGoogleFont, fontProvider = googleFontProvider, weight = FontWeight.Medium),
    Font(googleFont = poppinsGoogleFont, fontProvider = googleFontProvider, weight = FontWeight.SemiBold),
    Font(googleFont = poppinsGoogleFont, fontProvider = googleFontProvider, weight = FontWeight.Bold)
)

private val defaultTypography = Typography()

private fun TextStyle.withPoppins(): TextStyle = copy(fontFamily = Poppins)

// Tipografia principal do aplicativo com Poppins em todos os estilos do Material 3.
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.withPoppins(),
    displayMedium = defaultTypography.displayMedium.withPoppins(),
    displaySmall = defaultTypography.displaySmall.withPoppins(),
    headlineLarge = defaultTypography.headlineLarge.withPoppins(),
    headlineMedium = defaultTypography.headlineMedium.withPoppins(),
    headlineSmall = defaultTypography.headlineSmall.withPoppins(),
    titleLarge = defaultTypography.titleLarge.withPoppins(),
    titleMedium = defaultTypography.titleMedium.withPoppins(),
    titleSmall = defaultTypography.titleSmall.withPoppins(),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = defaultTypography.bodyMedium.withPoppins(),
    bodySmall = defaultTypography.bodySmall.withPoppins(),
    labelLarge = defaultTypography.labelLarge.withPoppins(),
    labelMedium = defaultTypography.labelMedium.withPoppins(),
    labelSmall = defaultTypography.labelSmall.withPoppins()
)
