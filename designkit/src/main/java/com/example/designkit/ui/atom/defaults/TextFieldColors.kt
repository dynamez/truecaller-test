package com.example.designkit.ui.atom.defaults

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.designkit.ui.theme.M2BTheme

@Composable
fun textFieldColors(
    textColor: Color = M2BTheme.colors.contentDark,
    disabledTextColor: Color = Color.White,
    backgroundColor: Color = Color.White,
    cursorColor: Color = M2BTheme.colors.primary,
    errorCursorColor: Color = M2BTheme.colors.critiqueDark,
    focusedBorderColor: Color = M2BTheme.colors.primary,
    unfocusedBorderColor: Color = M2BTheme.colors.contentLight,
    focusedLabelColor: Color = M2BTheme.colors.primary,
    unfocusedLabelColor: Color = M2BTheme.colors.contentDark,
    errorBorderColor: Color = M2BTheme.colors.critiqueDark,
    errorLabelColor: Color = M2BTheme.colors.critiqueDark,
) = OutlinedTextFieldDefaults.colors(
    focusedTextColor = textColor,
    disabledTextColor = disabledTextColor,
    focusedContainerColor = backgroundColor,
    cursorColor = cursorColor,
    errorCursorColor = errorCursorColor,
    focusedBorderColor = focusedBorderColor,
    unfocusedBorderColor = unfocusedBorderColor,
    focusedLabelColor = focusedLabelColor,
    unfocusedLabelColor = unfocusedLabelColor,
    errorBorderColor = errorBorderColor,
    errorLabelColor = errorLabelColor,
)
