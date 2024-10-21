package com.example.designkit.ui.molecule.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.M2BColor
import com.example.designkit.ui.theme.M2BSize
import com.example.designkit.ui.theme.m2bContentSoft
import com.example.designkit.ui.theme.m2bPrimaryMain

@Composable
internal fun M2BFillButtonDefault(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.m2bPrimaryMain,
        contentColor = M2BColor.white,
        disabledContainerColor = MaterialTheme.colorScheme.m2bContentSoft,
        disabledContentColor = M2BColor.white,
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = modifier.height(M2BSize.buttonHeight),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = 16.dp),
        onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(),
        shape = RoundedCornerShape(8.dp),
        colors = colors,
        content = content,
    )
}
