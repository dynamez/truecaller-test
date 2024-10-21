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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.designkit.ui.theme.semiBold

@Composable
fun BasicButtonCritique(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = colors.critiqueDark.copy(alpha = float_05),
    content: @Composable RowScope.() -> Unit,
) {
    val backGroundColor =
        if (interactionSource.collectIsPressedAsState().value) onPressedColor
        else colors.critiqueDark


    Button(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen16),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(dimens.dimen8),
        colors = ButtonDefaults.buttonColors(
            containerColor = backGroundColor,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.contentLight,
            disabledContentColor = colors.surface
        ),
        content = content
    )
}

@Composable
fun ButtonCritique(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButtonCritique(modifier, enabled, onClick) {
        val color = if (enabled) colors.onPrimary else colors.content

        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = color,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }


        Text(text = text, style = M2BTheme.typography.bodyL.semiBold, color = color)

    }
}


@Composable
fun ButtonCritiqueFullWidth(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    ButtonCritique(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        icon = icon,
        enabled = enabled
    ) { onClick.invoke() }
}

@Composable
fun ButtonCritiqueSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButtonCritique(modifier.height(dimens.buttonSmallHeight), enabled, onClick) {
        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = colors.onPrimary
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(text = text, style = M2BTheme.typography.bodyS.semiBold, color = colors.onPrimary)

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
                ButtonCritique(text = "Critique") {
                }
                ButtonCritiqueFullWidth(text = "Critique", enabled = false) {}
                ButtonCritiqueFullWidth(
                    text = "Critique",
                    icon = R.drawable.m2b_ic_mp_circle,
                    enabled = true
                ) {}

                ButtonCritiqueSmall(text = "Small", Modifier.fillMaxWidth()) {
                    
                }

            }
        }
    }
}