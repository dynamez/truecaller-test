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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.R.drawable.m2b_ic_card_credit
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.molecule.button.ButtonSmallLight
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import coil.compose.rememberImagePainter
import com.example.designkit.ui.organism.card.Card

@Composable
fun DoubleInfoCard(
    attrs: AttrsDoubleInfoCard,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = M2BTheme.shapes.small,
        border = BorderStroke(1.dp, M2BTheme.colors.contentLighter),
        backgroundColor = M2BTheme.colors.surface,
        elevation = 0.dp,
    ) {
        val imagePainter = rememberImagePainter(attrs.secondIcon) {
            placeholder(m2b_ic_card_credit)
            error(m2b_ic_card_credit)
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Icon(
                    modifier = Modifier.size(24.dp.scaled),
                    painter = painterResource(attrs.firstIcon),
                    contentDescription = null,
                    tint = M2BTheme.colors.primary,
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = attrs.topFirstText,
                    style = typography.bodyM,
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = attrs.topSecondText,
                    style = typography.bodyM.bold,
                )
            }

            HorizontalDivider()

            Row(modifier = Modifier.padding(top = 16.dp)) {
                Image(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(24.dp.scaled),
                    painter = imagePainter,
                    contentDescription = null,
                )

                Column {
                    Row {
                        Text(
                            text = attrs.bottomFirstText,
                            style = typography.bodyM,
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        attrs.buttonText?.let {
                            ButtonSmallLight(
                                text = attrs.buttonText,
                                onClick = attrs.buttonAction,
                                enabled = attrs.isButtonEnabled,
                            )
                        }
                    }

                    Text(
                        modifier = Modifier.padding(top = 9.dp),
                        text = attrs.bottomSecondText,
                        style = typography.bodyM.bold,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )

                    Text(
                        text = attrs.bottomThirdText,
                        style = typography.bodyS,
                    )

                    attrs.bottomFourthText?.let {
                        Row(
                            Modifier.padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = attrs.bottomFourthText,
                                style = typography.bodyM,
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            attrs.bottomFifthText?.let {
                                Text(
                                    text = attrs.bottomFifthText,
                                    style = typography.bodyM.bold,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class AttrsDoubleInfoCard(
    val topFirstText: String,
    val topSecondText: String,
    val bottomFirstText: String,
    val bottomSecondText: String,
    val bottomThirdText: String,
    @DrawableRes val firstIcon: Int,
    val secondIcon: String,
    val buttonText: String? = null,
    val isButtonEnabled: Boolean = false,
    val bottomFourthText: String? = null,
    val bottomFifthText: String? = null,
    val buttonAction: () -> Unit,
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DoubleInfoCardPreview() {
    BasicPreview {
        Column(Modifier.padding(2.dp)) {
            DoubleInfoCard(
                AttrsDoubleInfoCard(
                    topFirstText = "Pago a: ",
                    topSecondText = "Comercio",
                    bottomFirstText = "Medio de pago:",
                    bottomSecondText = "Tarjeta de Créditodasdsadsadsafasfsafsafsafasfsaf",
                    bottomThirdText = "***1234",
                    bottomFourthText = "Saldo:",
                    bottomFifthText = "$2.000.000",
                    firstIcon = R.drawable.m2b_ic_shop,
                    secondIcon = "",
                    buttonText = "Cambiar",
                    buttonAction = {},
                ),
            )
        }
    }
}
