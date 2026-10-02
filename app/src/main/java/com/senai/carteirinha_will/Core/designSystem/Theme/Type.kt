package com.senai.carteirinha_will.Core.designSystem.Theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_will.R

private val googleFontProvider = Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val Poppins = FontFamily(
    Font(GoogleFont("Poppins", weight = FontWeight.Normal), googleFontProvider),
    Font(GoogleFont("Poppins", weight = FontWeight.Medium), googleFontProvider),
    Font(GoogleFont("Poppins", weight = FontWeight.SemiBold), googleFontProvider),
    Font(GoogleFont("Poppins", weight = FontWeight.Bold), googleFontProvider)
)

// Tipografia principal do aplicativo
val Typography = Typography(
    defaultFontFamily = Poppins,
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
