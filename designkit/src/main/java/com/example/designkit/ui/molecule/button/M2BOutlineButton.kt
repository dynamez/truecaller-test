package com.example.designkit.ui.molecule.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import com.example.designkit.ui.theme.M2BSize
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.m2bContentSoft
import com.example.designkit.ui.theme.m2bPrimaryMain
import com.example.designkit.ui.theme.semiBold

@Composable
private fun M2BOutlineButtonDefault(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val color =
        if (isPressed) MaterialTheme.colorScheme.m2bPrimaryMain.copy(0.20f) else M2BColor.white

    OutlinedButton(
        modifier = modifier.height(M2BSize.buttonHeight),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = 16.dp),
        onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            1.dp,
            if (enabled) MaterialTheme.colorScheme.m2bPrimaryMain else MaterialTheme.colorScheme.m2bContentSoft,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = color,
            contentColor = MaterialTheme.colorScheme.m2bPrimaryMain,
            disabledContentColor = MaterialTheme.colorScheme.m2bContentSoft,
        ),
        content = content,
    )
}

@Composable
fun M2BOutlineButtonLoading(
    modifier: Modifier = Modifier,
) {
    M2BOutlineButtonDefault(
        modifier,
//        interactionSource = NoRippleInteractionSource(),
        onClick = { },
    ) {
        MPLoader(
            variant = MachLoaderVariant.OUTLINE,
        )
    }
}

@Composable
fun MPOutlineButton(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    icon: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    M2BOutlineButtonDefault(
        modifier,
        interactionSource = interactionSource,
        enabled = enabled,
        onClick = onClick,
    ) {
        icon?.let { icon ->
            Box(Modifier.size(24.dp)) {
                icon()
            }
            Spacer(modifier = Modifier.size(4.dp))
        }
        ProvideTextStyle(value = M2BTheme.typography.bodyL.semiBold) {
            CompositionLocalProvider(
                LocalContentColor provides MaterialTheme.colorScheme.onSurface,
                content = text,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun M2BOutlineButtonPreview() {
    M2BTheme {
        MPOutlineButton(
            Modifier.fillMaxWidth(),
            text = { Text(text = "Outline Variant") },
            onClick = {},
        )
    }
}
