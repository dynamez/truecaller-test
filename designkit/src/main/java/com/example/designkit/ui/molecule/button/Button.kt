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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.commons.NotInDS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.LocalFloat.float_05
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.theme.semiBold

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = M2BTheme.colors.primary.copy(alpha = float_05),
    content: @Composable RowScope.() -> Unit,
) {
    val backgroundColor =
        if (interactionSource.collectIsPressedAsState().value) {
            onPressedColor
        } else {
            M2BTheme.colors.primary
        }

    Button(
        modifier = modifier.height(dimens.buttonHeight),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = dimens.dimen16),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(dimens.dimen8),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = M2BTheme.colors.onPrimary,
            disabledContainerColor = M2BTheme.colors.contentLight,
            disabledContentColor = M2BTheme.colors.content,
        ),
        content = content,
    )
}

@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButton(modifier, enabled, onClick) {
        val color = if (enabled) M2BTheme.colors.surface else M2BTheme.colors.content
        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = color,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(text = text, style = typography.bodyL, color = color)
    }
}

@Composable
fun ButtonFullWidth(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        icon = icon,
        enabled = enabled,
    ) { onClick.invoke() }
}

@Composable
fun ButtonSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BasicButton(modifier.height(dimens.buttonSmallHeight), enabled, onClick) {
        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = M2BTheme.colors.onPrimary,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(text = text, style = typography.bodyS, color = M2BTheme.colors.onPrimary)
    }
}

@Composable
fun ButtonSmallFullWidth(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    ButtonSmall(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        icon = icon,
        enabled = enabled,
    ) { onClick.invoke() }
}

@Composable
fun ButtonDefaults.noElevation() = this.buttonElevation()

@Composable
fun BasicButtonSmall(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onPressedColor: Color = M2BTheme.colors.primary.copy(alpha = float_05),
    backgroundColor: Color = M2BTheme.colors.primaryLighter,
    contentColor: Color = M2BTheme.colors.primary,
    disabledBackgroundColor: Color = M2BTheme.colors.contentLighter,
    disabledContentColor: Color = M2BTheme.colors.content,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    val background =
        if (interactionSource.collectIsPressedAsState().value) {
            onPressedColor
        } else {
            backgroundColor
        }

    Button(
        modifier = modifier.height(24.dp.scaled),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = 8.dp),
        onClick = onClick,
        elevation = ButtonDefaults.noElevation(),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = background,
            contentColor = contentColor,
            disabledContainerColor = disabledBackgroundColor,
            disabledContentColor = disabledContentColor,
        ),
        content = content,
    )
}

@Composable
fun ButtonSmallLight(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val color = if (enabled) M2BTheme.colors.primary else M2BTheme.colors.content

    BasicButtonSmall(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
    ) {
        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = M2BTheme.colors.primary,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(
            text = text,
            style = typography.bodyXS.bold,
            color = color,
            textAlign = TextAlign.Center,
        )
    }
}

@NotInDS
@Composable
fun ButtonSmallCritique(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val color = if (enabled) M2BTheme.colors.critiqueDark else M2BTheme.colors.content

    BasicButtonSmall(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        backgroundColor = M2BTheme.colors.critiqueLight,
        contentColor = M2BTheme.colors.critique,
    ) {
        icon?.let { icon ->
            Icon(
                modifier = Modifier.size(dimens.dimen24),
                painter = painterResource(icon),
                contentDescription = String(),
                tint = M2BTheme.colors.primary,
            )

            Spacer(modifier = Modifier.size(dimens.dimen4))
        }

        Text(
            text = text,
            style = typography.bodyXS.bold,
            color = color,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    apiLevel = 33,
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun Preview(modifier: Modifier = Modifier) {
    BasicPreview(M2bColorsTheme.M2B) {
        Column(
            modifier
                .fillMaxSize()
                .padding(dimens.dimen20),
            verticalArrangement = Arrangement.spacedBy(dimens.dimen20),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Normal", style = typography.subHeadlineM.semiBold)

            Button(text = "Primary") {}

            ButtonFullWidth(text = "Primary") {}

            ButtonFullWidth(
                text = "Primary",
                icon = R.drawable.m2b_ic_mp_circle,
                enabled = true,
            ) {}

            ButtonFullWidth(text = "Primary", enabled = false) {}

            Text(text = "Small", style = typography.subHeadlineM.semiBold)

            ButtonSmall(text = "Primary") {}

            ButtonSmallFullWidth(text = "Primary") {}

            ButtonSmallFullWidth(text = "Primary", enabled = false) {}

            ButtonSmallFullWidth(
                text = "Primary",
                icon = R.drawable.m2b_ic_mp_circle,
                enabled = true,
            ) {}

            ButtonSmallLight(text = "ButtonSmallReal") {}
        }
    }
}
