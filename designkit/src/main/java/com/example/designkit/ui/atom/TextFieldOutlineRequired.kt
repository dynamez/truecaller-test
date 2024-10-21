package com.example.designkit.ui.atom

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.example.designkit.commons.decoratedLabel
import com.example.designkit.ui.atom.defaults.textFieldColors
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import androidx.compose.material3.Text as MaterialText

@Composable
fun TextFieldOutlineRequired(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    validator: (String) -> Boolean,
    modifier: Modifier = Modifier,
    validateAlways: Boolean = false,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    keyboardOptions: KeyboardOptions =
        KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Words,
            imeAction = ImeAction.Next,
        ),
    keyboardActions: KeyboardActions? = null,
    helperMessageComposable: @Composable () -> Unit = {},
    textErrorComposable: @Composable () -> Unit,
) {
    var textInput by remember { mutableStateOf(String()) }
    var textError by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    var wasFocused by remember { mutableStateOf(false) }
    var isNotFocused by remember { mutableStateOf(false) }
    val hasLostFocus by remember { derivedStateOf { wasFocused && isNotFocused } }
    val source = remember { MutableInteractionSource() }

    val keyboardActionsDefault = KeyboardActions {
        textError = validator.invoke(textInput)
        if (textError.not()) focusManager.moveFocus(FocusDirection.Next)
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
                        textError = validator.invoke(textInput)
                    }
                },
            colors = textFieldColors(),
            shape = shapes.small,
            value = value,
            onValueChange = {
                textInput = it
                onValueChanged.invoke(it)
                if (textError) textError = validator.invoke(it)
                if (validateAlways) textError = validator.invoke(it)
            },
            label = {
                MaterialText(
                    text = decoratedLabel(text = label),
                    style = typography.bodyM,
                )
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions ?: keyboardActionsDefault,
            isError = textError,
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

        if (textError) { textErrorComposable() }
        else { helperMessageComposable() }
    }
}
