package com.example.designkit.commons

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.designkit.ui.theme.M2BTheme


@Composable
fun decoratedLabel(text: String, redChar: String = "*"): AnnotatedString =
    buildAnnotatedString {
        text.forEach {
            if (it.toString() == redChar) {
                withStyle(SpanStyle(M2BTheme.colors.critiqueDark)) {
                    append(redChar)
                }
            } else {
                append(it.toString())
            }
        }
    }