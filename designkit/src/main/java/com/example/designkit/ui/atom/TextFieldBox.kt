package com.example.designkit.ui.atom

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.decoratedLabel
import com.example.designkit.ui.atom.ValidationResult.Invalid
import com.example.designkit.ui.atom.ValidationResult.Valid
import com.example.designkit.ui.atom.defaults.textFieldColors
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import androidx.compose.material3.Text as MaterialText

@Composable
fun TextFieldBox(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    validator: (String) -> ValidationResult,
    modifier: Modifier = Modifier,
    validateAlways: Boolean = false,
    keyboardOptions: KeyboardOptions =
        KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Words,
            imeAction = ImeAction.Next,
        ),
    keyboardActions: KeyboardActions? = null,
    helperMessage : String = "",
    initialErrorMessage: String? = null,
) {
    var textInput by remember { mutableStateOf(String()) }
    val focusManager = LocalFocusManager.current
    var wasFocused by remember { mutableStateOf(false) }
    var isNotFocused by remember { mutableStateOf(false) }
    val hasLostFocus by remember { derivedStateOf { wasFocused && isNotFocused } }
    val source = remember { MutableInteractionSource() }
    var externalErrorMessage by remember { mutableStateOf(initialErrorMessage) }

    var validationResult : ValidationResult by remember {
        mutableStateOf(Valid)
    }

    val keyboardActionsDefault = KeyboardActions {
        if (validationResult.isValid.not()) focusManager.moveFocus(FocusDirection.Next)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    isNotFocused = it.isFocused.not()
                    if (hasLostFocus) {
                        validationResult = validator.invoke(textInput)
                    }
                },
            colors = textFieldColors(),
            shape = shapes.small,
            value = value,
            onValueChange = {
                textInput = it
                onValueChanged.invoke(it)
                if (validationResult.isValid.not() || validateAlways) {
                    validationResult = validator.invoke(it)
                }
                externalErrorMessage = null
            },
            label = {
                MaterialText(
                    text = decoratedLabel(text = label),
                    style = typography.bodyM,
                )
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions ?: keyboardActionsDefault,
            isError = externalErrorMessage != null || validationResult.isValid.not(),
            interactionSource = source.also { interactionSource ->
                LaunchedEffect(interactionSource) {
                    interactionSource.interactions.collect { interaction ->
                        if (interaction is PressInteraction.Press) {
                            wasFocused = true
                        }
                    }
                }
            }
        )

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = (validationResult as? Invalid)?.message ?: externalErrorMessage ?: helperMessage,
            style = typography.bodyM,
            color = when {
                externalErrorMessage != null -> {
                    colors.critiqueDark
                }
                validationResult.isValid -> {
                    colors.contentDarker
                }
                else -> {
                    colors.critiqueDark
                }
            },
        )
    }
}

sealed class ValidationResult {
    object Valid : ValidationResult() {
        override val isValid: Boolean = true
    }
    data class Invalid(val message: String) : ValidationResult() {
        override val isValid: Boolean = false
    }

    abstract val isValid: Boolean
}
