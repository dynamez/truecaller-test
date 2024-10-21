package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.SpacerM
import com.example.designkit.ui.atom.SpacerXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.molecule.button.ButtonSmallLight
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.semiBold
import com.example.designkit.ui.organism.card.Card

@Composable
fun CardEmpty(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = CardEmptyDefaults.icon,
    title: String = CardEmptyDefaults.TITLE,
    subtitle: String = CardEmptyDefaults.SUBTITLE,
    buttonText: String? = null,
    onClick: (() -> Unit)? = null,
) {
    Card(
        Modifier
            .padding(horizontal = 20.dp)
            .then(modifier),
        elevation = 0.dp,
        border = BorderStroke(1.dp, M2BTheme.colors.contentLight),
        shape = M2BTheme.shapes.small,
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = M2BTheme.colors.content,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterHorizontally),
            )

            SpacerXS()

            Text(
                text = title,
                style = M2BTheme.typography.bodyS.semiBold,
                textAlign = TextAlign.Center,
            )

            Text(
                text = subtitle,
                style = M2BTheme.typography.bodyS,
                color = M2BTheme.colors.contentDark,
                textAlign = TextAlign.Center,
            )

            SpacerXS()

           onClick?.let {
                ButtonSmallLight(
                    text = buttonText?: CardEmptyDefaults.BUTTON_TEXT,
                    onClick = it,
                )
           }
        }
    }
}

private object CardEmptyDefaults {
    val icon = R.drawable.m2b_ic_car
    const val TITLE = "Aún no tienes vehículos registrados."
    const val SUBTITLE = "Agrega tu vehículo y \n paga de forma automática."
    const val BUTTON_TEXT = "Agregar vehículo"
}

@Preview(showSystemUi = true, showBackground = true, fontScale = 1.0f)
@Composable
private fun Preview() {
    BasicPreview {
        Column(Modifier.fillMaxSize()) {
            SpacerM()

            CardEmpty {}

            SpacerM()

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                Text(text = "Vehículos", style = M2BTheme.typography.bodyL.bold)
                Spacer(modifier = Modifier.weight(1f))
                ButtonSmallLight(text = "Agregar vehículo") {}
            }

            SpacerM()

            CardEmpty()
        }
    }
}