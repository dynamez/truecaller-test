package com.example.designkit.ui.molecule.alert

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.molecule.button.ButtonSmallCritique
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.commons.NotInDS
import com.example.designkit.ext.toBoldMarkDown
import com.example.designkit.ui.atom.SpacerXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.ColorsM2b
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.scaled

@NotInDS
@Composable
fun BasicAlertAction(
    text: @Composable () -> Unit,
    action: @Composable () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    actionText: String,
) {
    Card(
        modifier = modifier.then(Modifier.fillMaxWidth()),
        shape = shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.noElevation
        ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
        ) {
            icon?.let {
                icon.invoke()
                Spacer(Modifier.size(8.dp))
            }

            Column(modifier = Modifier.weight(1f)) {
                text.invoke()
            }

            if(actionText.isNotEmpty()) {
                SpacerXS()

                action.invoke()
            }
        }
    }
}

@NotInDS
@Composable
fun BasicAlertAction(
    text: String,
    backgroundColor: Color,
    actionText: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
    button: @Composable () -> Unit,
) {
    BasicAlertAction(
        modifier = modifier,
        icon = icon?.let {
            {
                Icon(
                    painter = painterResource(icon),
                    modifier = Modifier.size(24.dp.scaled),
                    contentDescription = iconContentDescription,
                    tint = colors.contentAlertColorFor(backgroundColor),
                )
            }
        },
        text = {
            Text(
                text = text.toBoldMarkDown(),
                style = typography.bodyS,
                color = colors.contentAlertColorFor(backgroundColor),
            )
        },
        backgroundColor = backgroundColor,
        actionText = actionText,
        action = { button.invoke() }
    )
}

@NotInDS
@Composable
fun AlertActionInformative(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
    actionText: String,
    action: () -> Unit,
) {
    BasicAlertAction(
        modifier = modifier,
        text = text,
        backgroundColor = colors.primaryLighter,
        actionText = actionText,
        icon = icon,
        iconContentDescription = iconContentDescription,
    ) {
        action()
    }
}

@NotInDS
@Composable
fun AlertActionWarning(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
    actionText: String,
    action: () -> Unit,
) {
    BasicAlertAction(
        modifier = modifier,
        text = text,
        backgroundColor = colors.warningLighter,
        actionText = actionText,
        icon = icon,
        iconContentDescription = iconContentDescription,
    ) {
        action()
    }
}

@NotInDS
@Composable
fun AlertActionSuccess(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
    actionText: String,
    action: () -> Unit,
) {
    BasicAlertAction(
        modifier = modifier,
        text = text,
        backgroundColor = colors.successLighter,
        actionText = actionText,
        icon = icon,
        iconContentDescription = iconContentDescription,
    ) {
        action()
    }
}

@NotInDS
@Composable
fun AlertActionCritique(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
    actionText: String,
    action: () -> Unit,
) {
    BasicAlertAction(
        modifier = modifier,
        text = text,
        backgroundColor = colors.critiqueLighter,
        actionText = actionText,
        icon = icon,
        iconContentDescription = iconContentDescription,
    ) {
        ButtonSmallCritique(
            modifier = Modifier.padding(top = 7.dp),
            text = actionText,
            onClick = action,
        )
    }
}

private fun ColorsM2b.contentAlertColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        primaryLighter -> primary
        warningLighter -> warningDarker
        successLighter -> successDarker
        critiqueLighter -> critiqueDarker
        else -> Color.Unspecified
    }
}

@Preview
@Composable
private fun Preview() {
    BasicPreview(M2bColorsTheme.M2B) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val shortText = "Recuerda validar tu compra con el comercio y disfrutar de tu producto."
            val text = "{Texto para información neutra/alerta/error/éxito. " +
                    "**Puede incluir label en bold.**\n" +
                    "Responsive text: font-family: ‘Nunito’; font-size: 14px; " +
                    "font-weight: regular/bold;}"
            val actionText = "Pagar"
            AlertActionSuccess(text = text, actionText = actionText) {}
            AlertActionWarning(text = text, actionText = actionText) {}
            AlertActionInformative(text = text, actionText = actionText) {}
            AlertActionCritique(icon = R.drawable.m2b_ic_report, text = text, actionText = actionText) {}
        }
    }
}
