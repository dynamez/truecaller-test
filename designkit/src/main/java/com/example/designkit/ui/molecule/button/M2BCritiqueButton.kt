package com.example.designkit.ui.molecule.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.atom.MPLoader
import com.example.designkit.ui.atom.MachLoaderVariant
import com.example.designkit.ui.theme.M2BColor
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.m2bContentForeground
import com.example.designkit.ui.theme.m2bContentSoft
import com.example.designkit.ui.theme.m2bErrorMain
import com.example.designkit.ui.theme.semiBold

@Composable
fun M2BCritiqueButton(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    icon: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val color =
        if (isPressed) MaterialTheme.colorScheme.m2bErrorMain.copy(alpha = 0.40f) else MaterialTheme.colorScheme.m2bErrorMain

    M2BFillButtonDefault(
        modifier,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = M2BColor.white,
            disabledContainerColor = MaterialTheme.colorScheme.m2bContentSoft,
            disabledContentColor = M2BColor.white,
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

@Composable
fun M2BCritiqueButtonLoading(
    modifier: Modifier = Modifier,
) {
    M2BFillButtonDefault(
        modifier,
        //interactionSource = NoRippleInteractionSource(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.m2bErrorMain,
            contentColor = MaterialTheme.colorScheme.m2bContentForeground,
            disabledContainerColor = MaterialTheme.colorScheme.m2bContentSoft,
            disabledContentColor = MaterialTheme.colorScheme.m2bContentForeground,
        ),
        onClick = { },
    ) {
        MPLoader(
            variant = MachLoaderVariant.PRIMARY,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun M2BCritiqueButtonPreview() {
    M2BTheme {
        M2BCritiqueButton(Modifier.fillMaxWidth(), text = { Text(text = "Critique") }, onClick = {})
    }
}
