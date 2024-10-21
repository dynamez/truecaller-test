package com.example.designkit.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.sp
import com.example.designkit.R

@Immutable
data class TypographyM2B(

    val bodyXXS: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 10.sp,
        fontWeight = Normal,
    ),

    val bodyXS: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 12.sp,
        fontWeight = Normal,
    ),

    val bodyS: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 14.sp,
        fontWeight = Normal,
    ),

    val bodyM: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 16.sp,
        fontWeight = Normal,
    ),

    val bodyL: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 18.sp,
        fontWeight = Normal,
    ),

    val subtitleM: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 20.sp,
        fontWeight = Normal,
    ),

    val subtitleL: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 24.sp,
        fontWeight = Normal,
    ),

    val subHeadlineM: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 28.sp,
        fontWeight = Normal,
    ),

    val subHeadlineL: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 32.sp,
        fontWeight = Normal,
    ),

    val headlineXL: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 40.sp,
        fontWeight = Normal,
    ),

    val headlineXXL: TextStyle = TextStyle(
        fontFamily = fontM2b,
        fontSize = 44.sp,
        fontWeight = Normal,
    ),
)

val TextStyle.regular: TextStyle
    get() = copy(fontWeight = Normal)


/**
 * Adds a weight of 600 to the style.
 */
val TextStyle.semiBold: TextStyle
    get() = copy(fontWeight = SemiBold)

/**
 * Adds a weight of 700 to the style.
 */
val TextStyle.bold: TextStyle
    get() = copy(fontWeight = Bold)

val fontM2b = FontFamily(
    Font(R.font.nunito_regular, Normal),
    Font(R.font.nunito_semi_bold, SemiBold),
    Font(R.font.nunito_bold, Bold),
)
