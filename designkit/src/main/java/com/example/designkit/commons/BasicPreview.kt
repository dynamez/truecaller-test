package com.example.designkit.commons

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2bColorsTheme

@Composable
internal fun BasicPreview(
    colorsTheme: M2bColorsTheme = M2bColorsTheme.M2B,
    content: @Composable () -> Unit,
) {
    M2BTheme(colorsTheme) {
        Surface(content = content)
    }
}
