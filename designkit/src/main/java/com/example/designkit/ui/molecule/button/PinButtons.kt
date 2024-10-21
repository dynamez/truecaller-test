package com.example.designkit.ui.molecule.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.scaled

@Composable
fun PinNumber(
    pinNumber: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptic = LocalHapticFeedback.current

    Button(
        onClick = {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick(pinNumber)
        },
        shape = M2BTheme.shapes.fullCircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = PinNumberDefaults.backgroundPinColor(interactionSource),
            disabledContainerColor = colors.contentLight,
        ),
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = Modifier
            .defaultMinSize(58.dp.scaled)
            .then(modifier),

    ) {
        Text(
            text = pinNumber,
            style = M2BTheme.typography.headlineXL,
            color = PinNumberDefaults.numberPinColor(interactionSource, enabled),
            modifier = Modifier.align(Alignment.CenterVertically),
        )
    }
}

@Composable
fun PinIcon(
    icon: Int = R.drawable.m2b_ic_delete_keyboard,
    enabled: Boolean = true,
    contentDescription: String? = "Borrar último número ingresado",
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptic = LocalHapticFeedback.current

    Button(
        onClick = {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        },
        shape = M2BTheme.shapes.fullCircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = PinNumberDefaults.backgroundPinIcon(interactionSource),
            disabledContainerColor = colors.surface,
            disabledContentColor = colors.contentLight,
        ),
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = Modifier
            .defaultMinSize(58.dp.scaled)
            .then(Modifier),
        elevation = ButtonDefaults.buttonElevation(),
        contentPadding = PaddingValues(vertical = 6.dp),

    ) {
        Icon(
            modifier = Modifier
                .defaultMinSize(58.dp.scaled)
                .align(Alignment.CenterVertically),
            imageVector = ImageVector.vectorResource(icon),
            tint = PinNumberDefaults.pinTintColor(interactionSource, enabled),
            contentDescription = contentDescription,
        )
    }
}

private object PinNumberDefaults {
    @Composable
    fun backgroundPinColor(interactionSource: MutableInteractionSource) =
        when {
            interactionSource.collectIsPressedAsState().value -> colors.primary
            else -> colors.primaryLighter
        }


    @Composable
    fun numberPinColor(interactionSource: MutableInteractionSource, enabled: Boolean = true) =
        when {
            enabled -> numberPinColorPressed(interactionSource)
            else -> colors.content
        }


    @Composable
    fun backgroundPinIcon(interactionSource: MutableInteractionSource) =
        when {
            interactionSource.collectIsPressedAsState().value -> colors.primary
            else -> colors.surface
        }

    @Composable
    fun pinTintColor(interactionSource: MutableInteractionSource, enabled: Boolean = true) =
        when {
            enabled -> pinTintColorPressed(interactionSource)
            else -> colors.content
        }


    @Composable
    fun pinTintColorPressed(interactionSource: MutableInteractionSource) =
        when {
            interactionSource.collectIsPressedAsState().value -> colors.primaryLighter
            else -> colors.primary
        }


    @Composable
    private fun numberPinColorPressed(interactionSource: MutableInteractionSource) =
        when {
            interactionSource.collectIsPressedAsState().value -> colors.surface
            else -> colors.primary
        }
}