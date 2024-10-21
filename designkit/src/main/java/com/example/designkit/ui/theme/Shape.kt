package com.example.designkit.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.atom.FullCircleShape

@Stable
data class Shapes(
    val extraSmall: RoundedCornerShape = RoundedCornerShape(4.dp),
    val small: RoundedCornerShape = RoundedCornerShape(8.dp),
    val smallMedium: RoundedCornerShape = RoundedCornerShape(12.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(16.dp),
    val mediumLarge: RoundedCornerShape = RoundedCornerShape(20.dp),
    val large: RoundedCornerShape = RoundedCornerShape(24.dp),
    val extraLarge: RoundedCornerShape = RoundedCornerShape(48.dp),
    val extraExtraLarge: RoundedCornerShape = RoundedCornerShape(100.dp),
    val mediumTopRounded : RoundedCornerShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    val fullCircleShape: FullCircleShape = FullCircleShape()
)

val LocalShapes = staticCompositionLocalOf { Shapes() }
