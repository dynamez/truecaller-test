package com.example.designkit.ui.atom

import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.semiBold

@Composable
fun M2BTextAction(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier,
    ) {
        Text(text = text)
    }
}

@Composable
fun TextAction(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = M2BTheme.colors.primary,
    style: TextStyle = typography.bodyXS.semiBold,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier,
        content = { Text(text = text, style = style, color = color) },
    )
}