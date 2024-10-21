package com.example.designkit.ui.molecule.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.atom.MPLoader
import com.example.designkit.ui.atom.MachLoaderVariant
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.m2bBackground
import com.example.designkit.ui.theme.m2bContentSoft
import com.example.designkit.ui.theme.m2bPrimaryMain
import com.example.designkit.ui.theme.semiBold

@Composable
fun M2BContextualButtonLoading(
    modifier: Modifier = Modifier,
) {
    M2BFillButtonDefault(
        modifier,
        //interactionSource = NoRippleInteractionSource(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.m2bBackground,
        ),
        onClick = { },
    ) {
        MPLoader(
            variant = MachLoaderVariant.OUTLINE,
        )
    }
}

@Composable
fun M2BContextualButton(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    icon: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val color =
        if (isPressed) MaterialTheme.colorScheme.m2bPrimaryMain.copy(0.20f) else MaterialTheme.colorScheme.m2bBackground

    M2BFillButtonDefault(
        modifier,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = MaterialTheme.colorScheme.m2bPrimaryMain,
            disabledContainerColor = MaterialTheme.colorScheme.m2bBackground,
            disabledContentColor = MaterialTheme.colorScheme.m2bContentSoft,
        ),
        enabled = enabled,
        onClick = onClick,
    ) {
        icon?.let { icon ->
            Box(Modifier.size(24.dp)) {
                icon()
            }
            Spacer(Modifier.size(4.dp))
        }
        ProvideTextStyle(value = M2BTheme.typography.bodyL.semiBold) {
            CompositionLocalProvider(
                LocalContentColor provides MaterialTheme.colorScheme.onSurface,
                content = text,
            )
        }
    }
}
