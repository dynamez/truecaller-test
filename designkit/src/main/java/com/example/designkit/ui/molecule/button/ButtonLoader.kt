package com.example.designkit.ui.molecule.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.CircularLoader
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.BlueRibbonLight
import com.example.designkit.ui.theme.LocalFloat.float_05
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.PureWhite
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.theme.semiBold
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ButtonLoader(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.primary.copy(alpha = float_05),
    onClick: () -> Unit,
) {
    val containerColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor
        else colors.primary

    val enabledColor = if (isLoading) colors.primary else colors.contentLight

    Button(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = !isLoading && enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen16),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(dimens.dimen8),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = colors.onPrimary,
            disabledContainerColor = enabledColor,
            disabledContentColor = colors.surface
        ),
    ) {
        ButtonLoaderContent(
            isLoading = isLoading,
            icon = icon,
            text = text,
            colorPrimaryLoader = colors.surface,
            colorSecondaryLoader = colors.primaryLight,
            contentColor = colors.onPrimary
        )
    }
}


@Composable
fun OutlinedButtonLoader(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.primary.copy(alpha = float_05),
    onClick: () -> Unit,
) {
    val containerColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor
        else colors.surface
    val borderColor = if (enabled) colors.primary else colors.contentLight
    val disableContentColor = if (isLoading) colors.primary else colors.contentLight

    OutlinedButton(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = !isLoading && enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen16),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(dimens.dimen8),
        border = BorderStroke(dimens.dimen1, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = colors.primary,
            disabledContentColor = disableContentColor
        ),
    ) {
        ButtonLoaderContent(
            isLoading = isLoading,
            enabled = !isLoading && enabled,
            text = text,
            icon = icon,
            colorPrimaryLoader = colors.primary,
            colorSecondaryLoader = colors.primaryLight,
            contentColor = colors.primary,
            contentColorDisable = colors.contentLight
        )
    }
}


@Composable
fun ButtonContextualLoader(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.primary.copy(alpha = float_05),
    onClick: () -> Unit,
) {
    val containerColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor else colors.surface
    val enabledColor = if (isLoading) colors.surface else colors.content

    Button(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = !isLoading && enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.paddingButton),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(dimens.dimen8),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = colors.primary,
            disabledContainerColor = colors.surface,
            disabledContentColor = PureWhite
        ),
    ) {
        ButtonLoaderContent(
            isLoading = isLoading,
            enabled = !isLoading && enabled,
            text = text,
            icon = icon,
            colorPrimaryLoader = colors.primary,
            colorSecondaryLoader = colors.primaryLight,
            contentColor = colors.primary,
            contentColorDisable = enabledColor
        )
    }
}

@Composable
fun ButtonCritiqueLoader(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.critiqueDark.copy(alpha = float_05),
    onClick: () -> Unit,
) {
    val containerColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor
        else colors.critiqueDark

    val enabledColor = if (isLoading) colors.critiqueDark else colors.contentLight

    Button(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = !isLoading && enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen16),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(dimens.dimen8),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = colors.onPrimary,
            disabledContainerColor = enabledColor,
            disabledContentColor = colors.surface,
        ),
    ) {

        ButtonLoaderContent(
            isLoading = isLoading,
            icon = icon,
            text = text,
            colorPrimaryLoader = colors.surface,
            colorSecondaryLoader = colors.critiqueLight,
            contentColor = colors.onPrimary
        )
    }
}

@Composable
fun ButtonCritiqueSmallLoader(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.critiqueDark.copy(alpha = float_05),
    onClick: () -> Unit,
) {
    val containerColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor
        else colors.critiqueDark

    val enabledColor = if (isLoading) colors.critiqueDark else colors.contentLight

    Button(
        modifier = Modifier.height(dimens.buttonSmallHeight.scaled).then(modifier),
        enabled = !isLoading && enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen8, vertical = dimens.dimen2),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = M2BTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = colors.onPrimary,
            disabledContainerColor = enabledColor,
            disabledContentColor = colors.surface,
        ),
    ) {

        ButtonLoaderContent(
            isLoading = isLoading,
            icon = icon,
            text = text,
            colorPrimaryLoader = colors.surface,
            colorSecondaryLoader = colors.critiqueLight,
            contentColor = colors.onPrimary,
            style = typography.bodyS.semiBold,
        )
    }
}


@Composable
private fun ButtonLoaderContent(
    isLoading: Boolean,
    @DrawableRes icon: Int? = null,
    text: String,
    colorPrimaryLoader: Color,
    colorSecondaryLoader: Color,
    contentColor: Color,
    enabled: Boolean = true,
    contentColorDisable: Color? = null,
    style: TextStyle = typography.bodyL.semiBold,
) {
    when {
        isLoading -> CircularLoader(
            size = dimens.dimen24,
            strokeWidth = dimens.dimen4,
            colorPrimary = colorPrimaryLoader,
            colorSecondary = colorSecondaryLoader,
        )

        else -> {
            icon?.let {
                Icon(
                    modifier = Modifier.size(dimens.dimen24),
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = contentColor,
                )

                Spacer(modifier = Modifier.size(dimens.dimen4))
            }

            Text(
                text = text,
                style = style,
                color = contentColorDisable?.let {
                    if (enabled) contentColor else contentColorDisable
                } ?: contentColor,
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview(modifier: Modifier = Modifier) {
    BasicPreview(M2bColorsTheme.M2B) {
        Column(
            modifier
                .background(BlueRibbonLight)
                .padding(dimens.dimen20)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(dimens.dimen20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var isButtonLoading by remember { mutableStateOf(false) }
            var isOutlinedLoading by remember { mutableStateOf(false) }
            var isContextualLoading by remember { mutableStateOf(false) }
            var isCritiqueLoading by remember { mutableStateOf(false) }
            val scope = rememberCoroutineScope()
            Spacer(modifier.size(dimens.dimen30))
            ButtonLoader(
                text = "Button Loader",
                isLoading = isButtonLoading,
                modifier = modifier.fillMaxWidth(),
                enabled = true
            ) {
                scope.launch {
                    isButtonLoading = !isButtonLoading
                    delay(3000)
                    isButtonLoading = !isButtonLoading
                }
            }


            OutlinedButtonLoader(
                text = "Outlined Loader",
                isLoading = isOutlinedLoading,
                modifier = modifier.fillMaxWidth(),
                enabled = true
            ) {
                scope.launch {
                    isOutlinedLoading = !isOutlinedLoading
                    delay(3000)
                    isOutlinedLoading = !isOutlinedLoading
                }
            }

            ButtonContextualLoader(
                text = "Contextual Loader",
                isLoading = isContextualLoading,
                modifier = modifier.fillMaxWidth(),
                enabled = true
            ) {
                scope.launch {
                    isContextualLoading = !isContextualLoading
                    delay(3000)
                    isContextualLoading = !isContextualLoading
                }
            }

            ButtonCritiqueLoader(
                text = "Critique Loader",
                isLoading = isCritiqueLoading,
                modifier = modifier.fillMaxWidth(),
                enabled = true
            ) {
                scope.launch {
                    isCritiqueLoading = !isCritiqueLoading
                    delay(3000)
                    isCritiqueLoading = !isCritiqueLoading
                }
            }
        }
    }
}