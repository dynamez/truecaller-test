package com.example.designkit.ui.molecule.alert

import android.content.res.Configuration
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
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ext.toBoldMarkDown
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.ColorsM2b
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.scaled

@Composable
fun BasicAlert(
    text: @Composable () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
) {
    Card(
        modifier = modifier.then(Modifier.fillMaxWidth()),
        shape = shapes.small,
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = dimens.noElevation)
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
            text.invoke()
        }
    }
}

@Composable
fun BasicAlert(
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
) {
    BasicAlert(
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
        modifier = modifier,
    )
}

@Composable
fun BasicAlertUrl(
    iconUrl: String,
    text: String,
    backgroundColor: Color,
    @DrawableRes iconBackup: Int,
    modifier: Modifier = Modifier,
    showIcon: Boolean = true,
    iconContentDescription: String? = null,
) {
    BasicAlert(
        icon = {
            if (showIcon) {
                InternetImage(
                    modifier = Modifier.size(24.dp.scaled),
                    imageUrl = iconUrl,
                    imageBackup = iconBackup,
                    contentDescription = iconContentDescription
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
        modifier = modifier,
    )
}

@Composable
fun AlertInformative(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlert(text, colors.primaryLighter, modifier, icon)
}

@Composable
fun AlertWarning(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlert(text, colors.warningLighter, modifier, icon)
}

@Composable
fun AlertSuccess(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlert(text, colors.successLighter, modifier, icon)
}

@Composable
fun AlertCritique(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlert(text, colors.critiqueLighter, modifier, icon)
}

@Composable
fun BasicAlertSmall(
    text: @Composable () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
) {
    Card(
        modifier = modifier.then(Modifier.fillMaxWidth()),
        shape = shapes.small,
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = dimens.noElevation)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
        ) {
            icon?.let {
                icon.invoke()
                Spacer(Modifier.size(8.dp))
            }
            text.invoke()
        }
    }
}

@Composable
fun BasicAlertSmall(
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    iconContentDescription: String? = null,
) {
    BasicAlertSmall(
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
        modifier = modifier,
    )
}

@Composable
fun AlertInformativeSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlertSmall(text, colors.primaryLighter, modifier, icon)
}

@Composable
fun AlertWarningSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlertSmall(text, colors.warningLighter, modifier, icon)
}

@Composable
fun AlertSuccessSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlertSmall(text, colors.successLighter, modifier, icon)
}

@Composable
fun AlertCritiqueSmall(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
) {
    BasicAlertSmall(text, colors.critiqueLighter, modifier, icon)
}

@Composable
fun AlertInformativeUrl(
    iconUrl: String,
    text: String,
    modifier: Modifier = Modifier,
    showIcon: Boolean = true,
    @DrawableRes iconBackup: Int = R.drawable.m2b_ic_eye_closed,
) {
    BasicAlertUrl(
        modifier = modifier,
        text = text,
        backgroundColor = colors.primaryLighter,
        iconUrl = iconUrl,
        iconBackup = iconBackup,
        showIcon = showIcon,
    )
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

            AlertInformative(text = shortText, icon = R.drawable.m2b_ic_mp_circle)
            AlertInformative(text, icon = R.drawable.m2b_ic_mp_circle)
            AlertInformative(text)
            AlertWarning(text)
            AlertSuccess(text, icon = R.drawable.m2b_ic_success_circle)
            AlertCritique(text)
        }
    }
}
