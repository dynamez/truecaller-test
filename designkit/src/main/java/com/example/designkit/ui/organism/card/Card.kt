package com.example.designkit.ui.organism.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Surface
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.M2BTheme

@Composable
@NonRestartableComposable
fun Card(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = M2BTheme.shapes.extraSmall,
    backgroundColor: Color = M2BTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider() {
        Surface(
            modifier = modifier,
            shape = shape,
            color = backgroundColor,
            contentColor = contentColor,
            shadowElevation = elevation,
            border = border,
            interactionSource = interactionSource,
            enabled = enabled,
            onClick = onClick,
            content = content,
        )
    }
}

@Composable
@NonRestartableComposable
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = M2BTheme.shapes.extraSmall,
    backgroundColor: Color = M2BTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider() {
        Surface(
            modifier = modifier,
            shape = shape,
            color = backgroundColor,
            contentColor = contentColor,
            shadowElevation = elevation,
            border = border,
            content = content,
        )
    }
}