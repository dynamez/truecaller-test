package com.example.designkit.ui.molecule.alert

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.ext.toBoldMarkDown
import com.example.designkit.ui.atom.SimpleRoundedSquare
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.SpacerXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.organism.card.Card
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.semiBold


@Composable
fun BoxInformation(
    backgroundColor: Color,
    percentageAmount: String,
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
    percentageBoxColor: Color = colors.primary,
    percentageBoxTextColor: Color = colors.surface,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shapes.small,
        backgroundColor = backgroundColor,
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            SimpleRoundedSquare(backgroundColor = percentageBoxColor) {
                Row(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp,
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.padding(),
                        text = percentageAmount,
                        style = typography.subtitleL.bold,
                        color = percentageBoxTextColor,
                    )
                }
            }

            SpacerS()

            Text(
                text = text,
                style = typography.bodyS.semiBold,
                color = textColor,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Composable
fun BoxInformation(
    @DrawableRes icon: Int,
    squareColor:Color,
    backgroundColor: Color,
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
    iconColor: Color = Color.White,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shapes.small,
        backgroundColor = backgroundColor,
        elevation = 0.dp,

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            SimpleRoundedSquare(backgroundColor = squareColor) {
                Icon(
                    modifier = Modifier.padding(8.dp),
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = iconColor,
                )
            }

            SpacerS()

            Text(
                text = text.toBoldMarkDown(),
                style = typography.bodyS.semiBold,
                color = textColor,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        BoxInformation(
            backgroundColor = colors.successLighter,
            percentageBoxColor = colors.successDark,
            percentageAmount = "10",
            text = "por ciento de cashback en toda compra por la tienda oficial.",
            textColor = colors.successDark,
        )
        SpacerXS()

        BoxInformation(
            backgroundColor = colors.successLighter,
            percentageBoxColor = colors.successDark,
            percentageAmount = "10",
            text = "texto corto.",
            textColor = colors.successDark,
        )
        SpacerXS()

        BoxInformation(
            icon = R.drawable.m2b_ic_gift,
            backgroundColor = colors.primaryLighter,
            text = "Participa en los sorteos mensuales de **indumentaria de Colo-Colo** al realizar **compras que acumulen $35.000 en el total** en la tienda oficial.",
            textColor = colors.primary,
            squareColor = colors.primary,
        )
    }
}
