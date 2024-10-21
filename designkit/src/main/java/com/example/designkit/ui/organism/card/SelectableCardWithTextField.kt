package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.designkit.commons.NotInDS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.atom.TextFieldOutlineRequired
import com.example.designkit.ui.theme.GrayCultured
import com.example.designkit.ui.theme.LocalFloat
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import coil.compose.rememberImagePainter
import com.example.designkit.ui.organism.card.Card

/**
 * SelectableCardWithTextField is a composable that represents a card
 * with a text field and a selectable icon. Made just for retro-compatibility as
 * the view will be modified shortly. It is custom adapted for installments :c
 *
 * @param attrs the attributes of the card.
 * @param modifier the modifier of the card.
 * @param onTextChanged the lambda that will be called when the text field changes.
 */
@NotInDS
@Composable
fun SelectableCardWithTextField(
    attrs: AttrsSelectableCardWithTextField,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val imagePainter = rememberImagePainter(attrs.startIcon) {
        placeholder(attrs.startIconBackup)
        error(attrs.startIconBackup)
    }
    
    var text by remember { mutableStateOf(attrs.initialText) }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(M2BTheme.dimens.dimen8),
        border = BorderStroke(M2BTheme.dimens.dimen1, GrayCultured),
        elevation = M2BTheme.dimens.dimen0,
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (!attrs.hideStartIcon) {
                    Spacer(modifier = Modifier.width(M2BTheme.dimens.dimen16))
                    Image(
                        modifier = Modifier
                            .padding(end = M2BTheme.dimens.dimen16)
                            .size(M2BTheme.dimens.dimen24),
                        painter = imagePainter,
                        contentDescription = null,
                    )
                }

                Column(
                    modifier = Modifier.padding(M2BTheme.dimens.dimen16),
                ) {
                    Text(text = attrs.topText, style = typography.bodyM.bold)
                }

                Spacer(modifier = Modifier.weight(LocalFloat.float_1))

                if (attrs.checked) {
                    Icon(
                        painter = painterResource(attrs.endIcon),
                        contentDescription = null,
                        tint = colors.primary,
                    )
                }
                Spacer(Modifier.padding(end = M2BTheme.dimens.dimen16))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 10.dp),
            ) {
                TextFieldOutlineRequired(
                    label = attrs.textFieldLabel,
                    value = text,
                    onValueChanged = { newValue ->
                        if (newValue.length <= attrs.maxCharacters) {
                            newValue.removePrefix(attrs.removeTrailing).let {
                                text = it
                                onTextChanged(it)
                            }
                        }
                    },
                    validateAlways = true,
                    validator = attrs.validator,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next,
                    ),
                    helperMessageComposable = attrs.helperMessage,
                    textErrorComposable = { attrs.helperErrorMessage(text) },
                )
            }
        }
    }
}

class AttrsSelectableCardWithTextField(
    val key: String,
    @DrawableRes val startIconBackup: Int,
    val topText: String,
    @DrawableRes val endIcon: Int,
    val textFieldLabel: String = "Ingresar cuotas",
    val minValTextField: Int = 1,
    val maxValTextField: Int = 24,
    val maxCharacters: Int = 3,
    val hideStartIcon: Boolean = false,
    val startIcon: String? = null,
    initialCheck: Boolean = false,
    val initialText: String = "",
    val removeTrailing: String = "0",
    val validator: (String) -> Boolean = {
        when {
            it.isBlank() -> false
            !it.isDigitsOnly() -> true
            it.isDigitsOnly() && it.toInt() < minValTextField -> true
            it.isDigitsOnly() && it.toInt() > maxValTextField -> true
            else -> false
        }
    },
    val helperMessage: @Composable () -> Unit = {
        Row(
            modifier = Modifier.padding(start = 8.dp),
        ) {
            Text(
                text = "Mínimo $minValTextField a máximo $maxValTextField cuotas",
                style = typography.bodyM,
                color = colors.onSurface,
            )
        }

    },
    val helperErrorMessage: @Composable (String) -> Unit = {
        Row(
            modifier = Modifier.padding(start = 8.dp),
        ) {
            val digitsValue = it.toIntOrNull() ?: 0
            when {
                !it.isDigitsOnly() -> Text(
                    text = "Ingrese solo números",
                    style = typography.bodyM,
                    color = colors.critiqueDark,
                )
                it.isDigitsOnly() && digitsValue < minValTextField -> Text(
                    text = "El mínimo es $minValTextField cuotas",
                    style = typography.bodyM,
                    color = colors.critiqueDark,
                )
                it.isDigitsOnly() && digitsValue > maxValTextField -> Text(
                    text = "El máximo es $maxValTextField cuotas",
                    style = typography.bodyM,
                    color = colors.critiqueDark,
                )
            }
        }
    },
) {
    var checked by mutableStateOf(initialCheck)
}
