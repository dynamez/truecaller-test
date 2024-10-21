package com.example.designkit.ui.molecule.button

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.LocalFloat.float_05
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.theme.semiBold

@Composable
fun BasicButtonContextual(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.primary.copy(alpha = 0.1f),
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    val backGroundColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor else colors.surface

    Button(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.paddingButton),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = M2BTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = backGroundColor,
            contentColor = colors.primary,
            disabledContainerColor = colors.surface,
            disabledContentColor = colors.contentLight
        ),
        content = content
    )

}

@Composable
fun ButtonContextual(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {

    BasicButtonContextual(
        modifier,
        enabled,
        interactionSource,
        onClick = onClick
    ) {
        val color = if (enabled) colors.primary else colors.content

        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = color,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(
            text = text,
            style = M2BTheme.typography.bodyL.semiBold,
            color = color,
        )

    }
}

@Composable
fun ButtonContextualFullWidth(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    ButtonContextual(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        icon = icon,
        enabled = enabled
    ) { onClick.invoke() }
}

@Composable
fun ButtonContextualSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {

    val backGroundColor =
        if (interactionSource.collectIsPressedAsState().value) colors.primary.copy(alpha = float_05)
        else colors.surface

    Button(
        modifier = modifier.height(dimens.buttonSmallHeight.scaled),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen8, vertical = dimens.dimen2),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = M2BTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = backGroundColor,
            contentColor = colors.primary,
            disabledContainerColor = colors.surface,
            disabledContentColor = colors.contentLight
        ),
    ){
        val color = if (enabled) colors.primary else colors.content

        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = color,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(
            text = text,
            style = M2BTheme.typography.bodyS.semiBold,
            color = color,
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    apiLevel = 33,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun Preview(modifier: Modifier = Modifier) {

    M2BTheme(M2bColorsTheme.M2B) {
        Surface {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(dimens.dimen20),
                verticalArrangement = Arrangement.spacedBy(dimens.dimen20)
            ) {
                ButtonContextual(text = "Contextual") {
                }
                ButtonContextualFullWidth(text = "Contextual") {}
                ButtonContextualFullWidth(
                    text = "Contextual", icon = R.drawable.m2b_ic_mp_circle,
                ) {}

            }
        }
    }
}

