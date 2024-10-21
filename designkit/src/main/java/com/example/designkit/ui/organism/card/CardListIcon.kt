package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
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
import com.example.designkit.ui.atom.SimpleCircle
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.organism.card.Card

@Composable
fun CardListIcon(
    modifier: Modifier = Modifier,
    listOfItems: List<AttrsCardListIcon>,
    color: Color = colors.primary,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = shapes.small,
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            listOfItems.forEachIndexed { index, aboutItem ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    SimpleCircle(
                        modifier = Modifier,
                        size = 40.dp,
                        backgroundColor = color,
                    ) {
                        Icon(
                            painter = painterResource(aboutItem.icon),
                            contentDescription = null,
                            tint = colors.background,
                        )
                    }

                    SpacerS()

                    Column {
                        Text(
                            text = aboutItem.title,
                            style = typography.bodyM.bold,
                            color = color,
                            textAlign = TextAlign.Start,
                        )

                        Text(
                            text = aboutItem.message,
                            style = typography.bodyS,
                            color = colors.contentDark,
                            textAlign = TextAlign.Start,
                        )
                    }
                }
                if (listOfItems.size > 1 && index != listOfItems.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(
                            top = 12.dp,
                            bottom = 24.dp,
                        ),
                        color = color.copy(alpha = 0.5f)
                    )
                }
            }
        }
    }
}

data class AttrsCardListIcon(
    @DrawableRes val icon: Int,
    val title: String,
    val message: String,
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    val title1 = "En un máximo de 5 días"
    val title2 = "Sorteos mensuales"
    val subtitle1 = "Verás tu compra en BciPlus+"
    val subtitle2 = "Abonaremos el cashback en MACH"
    val subtitle3 = "Considera todas las compras que realices desde el inicio al término del mes calendario."

    Column(
        Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceAround,
    ) {

        CardListIcon(
            listOfItems = listOf(
                AttrsCardListIcon(
                    icon = R.drawable.m2b_ic_new_bill,
                    title = title1,
                    message = subtitle1,
                ),
                AttrsCardListIcon(
                    icon = R.drawable.m2b_ic_new_bill,
                    title = title1,
                    message = subtitle2,
                )
            )
        )
        SpacerS()

        CardListIcon(
            listOfItems = listOf(
                AttrsCardListIcon(
                    icon = R.drawable.m2b_ic_new_bill,
                    title = title1,
                    message = subtitle1,
                ),
                AttrsCardListIcon(
                    icon = R.drawable.m2b_ic_new_bill,
                    title = title2,
                    message = subtitle3,
                )

            )
        )
        SpacerS()

        CardListIcon(
            listOfItems = listOf(
                AttrsCardListIcon(
                    icon = R.drawable.m2b_ic_card_credit,
                    title = title2,
                    message = subtitle3,
                )
            )
        )
    }
}
