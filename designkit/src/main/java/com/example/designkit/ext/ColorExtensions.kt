package com.example.designkit.ext

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

fun ColorFilter.Companion.disabled() = colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
