package com.example.designkit.ui.atom

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.decoratedLabel
import com.example.designkit.ui.atom.defaults.textFieldColors
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

private const val DELAY_TIME = 100L

@Composable
fun TextFieldForModal(
    label: String,
    modifier: Modifier = Modifier,
    requiredFieldMessage: String = "Este campo es obligatorio",
    onSelectedOption: () -> String = { "" },
    scope: CoroutineScope = rememberCoroutineScope(),
    onClick: () -> Unit
) {
    var selectedOption by remember { mutableStateOf(onSelectedOption) }
    var hasValueChanged by remember { mutableStateOf(false) }
    val source = remember { MutableInteractionSource() }
    val isRequiredField = remember { label.contains("*") }
    val focusManager = LocalFocusManager.current
    val textFieldError by remember {
        derivedStateOf {
            hasValueChanged && selectedOption.invoke().isEmpty()
        }
    }

    OutlinedTextField(
        label = {
            Text(
                text = decoratedLabel(text = label),
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.m2b_ic_down_arrow),
                contentDescription = String()
            )
        },
        modifier = modifier.fillMaxWidth(),
        colors = textFieldColors(),
        shape = shapes.small,
        value = selectedOption.invoke(),
        onValueChange = { selectedOption = onSelectedOption },
        readOnly = true,
        enabled = true,
        interactionSource = source.also { interactionSource ->
            LaunchedEffect(interactionSource, scope) {
                interactionSource.interactions.collect { interaction ->
                    if (interaction is PressInteraction.Release) {
                        focusManager.clearFocus(true)
                        onClick.invoke()
                        delay(DELAY_TIME)
                        hasValueChanged = true
                    }
                }
            }
        },
        isError = if (isRequiredField) textFieldError else false
    )

    if (isRequiredField && textFieldError) {
        Text(
            modifier = modifier.padding(top = 4.dp, start = 8.dp),
            text = requiredFieldMessage,
            style = typography.bodyXS,
            color = colors.critiqueDark,
            textAlign = TextAlign.Start,
        )
    }
}
