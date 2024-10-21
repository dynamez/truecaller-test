package com.example.designkit.ui.template.result.internal

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.molecule.alert.AlertInformative
import com.example.designkit.ui.molecule.box.ButtonBox
import com.example.designkit.ui.molecule.button.ButtonFullWidth
import com.example.designkit.ui.molecule.button.OutlinedButtonFullWidth

@Composable
internal fun AlertResultBottom(
    alertText: String?,
    primaryButtonText: String,
    modifier: Modifier = Modifier,
    secondaryButtonText: String? = null,
    @DrawableRes alertIcon: Int? = null,
    secondaryButtonAction: (() -> Unit)? = null,
    primaryButtonAction: () -> Unit,
) {
    Column(modifier = modifier) {
        alertText?.let {
            AlertInformative(
                text = alertText,
                icon = alertIcon,
                modifier = Modifier.padding(horizontal = 20.dp),
            )

            SpacerSM()
        }

        ButtonBox {
            ButtonFullWidth(
                text = primaryButtonText,
                onClick = primaryButtonAction,
            )

            if (secondaryButtonText != null && secondaryButtonAction != null) {
                OutlinedButtonFullWidth(
                    text = secondaryButtonText,
                    onClick = secondaryButtonAction,
                )
            }
        }
    }
}