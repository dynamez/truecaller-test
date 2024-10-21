package com.example.designkit.ui.organism.card

import com.example.designkit.ui.organism.card.BenefitCardConstants.BENEFIT
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.molecule.pill.ExtendedPillL
import com.example.designkit.R
import coil.compose.rememberImagePainter
import com.example.designkit.ui.atom.BasicPill
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.contentColorFor


@Composable
fun BenefitCard(
    modifier: Modifier = Modifier,
    benefitId: String,
    type: String,
    topImage: String,
    @DrawableRes topImagePlaceHolder: Int,
    @DrawableRes topImageError: Int,
    imagePillText: String,
    pillText: String,
    title: String,
    description: String,
    onClickedCard: (benefitId: String) -> Unit
) {
    val benefitPill = @Composable {
        when (type) {
            BENEFIT -> ExtendedPillL(
                text = pillText,
                icon = R.drawable.m2b_ic_connect,
                backgroundColor = colors.successLighter
            )

            else -> ExtendedPillL(
                text = pillText,
                icon = R.drawable.m2b_ic_gift,
                backgroundColor = colors.primary
            )
        }
    }
    val imagePainter = rememberImagePainter(topImage) {
        placeholder(topImagePlaceHolder)
        error(topImageError)
    }

    Card(
        onClick = { onClickedCard.invoke(benefitId) },
        modifier = modifier,
        shape = shapes.small,
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Column(Modifier.fillMaxWidth()) {
                Box(
                    Modifier
                        .height(128.dp)
                        .fillMaxWidth()
                ) {

                    Image(
                        painter = imagePainter,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = modifier.matchParentSize()
                    )

                    BasicPill(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(16.dp),
                        backgroundColor = colors.primary,
                    ) {
                        Text(
                            text = imagePillText,
                            style = typography.bodyS.bold,
                            color = contentColorFor(backgroundColor = colors.primary),
                        )
                    }

                    Image(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .fillMaxWidth(),
                        painter = painterResource(R.drawable.m2b_card_benefit_waves_decoration),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                benefitPill()

                Text(
                    modifier = Modifier.padding(top = 12.dp),
                    text = title,
                    style = typography.bodyL.bold,
                    textAlign = TextAlign.Start,
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 12.dp),
                    text = description,
                    style = typography.bodyS,
                    color = colors.contentDark,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

private object BenefitCardConstants{
    const val BENEFIT = "BENEFIT"
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4,
    fontScale = 1f,
)
@Composable
private fun Preview() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        BenefitCard(
            type = BENEFIT,
            topImage = "https://i.ibb.co/48kFBRr/image-35.png",
            topImagePlaceHolder = R.drawable.m2b_ic_small_logo_error,
            topImageError = R.drawable.m2b_ic_small_logo_error,
            imagePillText = "Exclusivo con MACH",
            benefitId = "1",
            pillText = "10% OFF",
            title = "Nacho lo logre",
            description = "Ya no se rompe la card",
        ) {

        }
    }
}
