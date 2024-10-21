package com.example.designkit.ui.organism.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.PillXl
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.SpacerXL
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.LocalFloat.fillRemainingSpace
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.organism.card.Card

@Composable
fun CardVisualSmall(
    image: String,
    logo: String,
    description: String,
    pillText: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillHeight,
) {
    Card(
        shape = M2BTheme.shapes.smallMedium,
        modifier = Modifier
            .size(width = 220.dp.scaled, height = 234.dp.scaled)
            .semantics(mergeDescendants = true) { }
            .then(modifier),
        elevation = M2BTheme.dimens.noElevation,
    ) {
        Box {

            InternetImage(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(width = 220.dp.scaled, height = 118.dp.scaled),
                imageUrl = image,
                imageBackup = R.drawable.m2b_img_card_visual_error,
                contentScale = contentScale,
                contentDescription = null,
            )

            Card(
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    bottomEnd = 12.dp,
                    bottomStart = 12.dp,
                ),
                modifier = Modifier.align(Alignment.BottomCenter),
                border = BorderStroke(1.dp, colors.contentLight),
                elevation = M2BTheme.dimens.noElevation,
            ) {
                Column(
                    modifier =
                    Modifier
                        .heightIn(min = 134.dp.scaled)
                        .padding(16.dp),
                ) {
                    Row {

                        InternetImage(
                            modifier = Modifier
                                .size(32.dp.scaled)
                                .clip(M2BTheme.shapes.fullCircleShape),
                            imageUrl = logo,
                            imageBackup = R.drawable.m2b_ic_card_visual_error_logo,
                            contentScale = ContentScale.Fit,
                            shimmerShape = M2BTheme.shapes.extraExtraLarge,
                        )

                        Spacer(modifier = Modifier.weight(fillRemainingSpace))

                        pillText?.let {
                            PillXl(pillText, Modifier.align(Alignment.CenterVertically))
                        }
                    }

                    SpacerS()

                    Text(
                        text = description,
                        style = typography.bodyS,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Composable
fun CardVisualSmall(
    attrs: AttrsCardVisual,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillHeight,
    onClick: (attrs: AttrsCardVisual) -> Unit,
) {
    Card(
        shape = M2BTheme.shapes.smallMedium,
        modifier = Modifier
            .size(width = 220.dp.scaled, height = 234.dp.scaled)
            .semantics(mergeDescendants = true) { }
            .then(modifier),
        elevation = M2BTheme.dimens.noElevation,
        onClick = { onClick.invoke(attrs) },
    ) {
        Box {

            InternetImage(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(width = 220.dp.scaled, height = 118.dp.scaled),
                imageUrl = attrs.image,
                imageBackup = R.drawable.m2b_img_card_visual_error,
                contentScale = contentScale,
                contentDescription = null,
            )

            Card(
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    bottomEnd = 12.dp,
                    bottomStart = 12.dp,
                ),
                modifier = Modifier.align(Alignment.BottomCenter),
                border = BorderStroke(1.dp, colors.contentLight),
                elevation = M2BTheme.dimens.noElevation,
            ) {
                Column(
                    modifier =
                    Modifier
                        .heightIn(min = 134.dp.scaled)
                        .padding(16.dp),
                ) {
                    Row {

                        InternetImage(
                            modifier = Modifier
                                .size(32.dp.scaled)
                                .clip(M2BTheme.shapes.fullCircleShape),
                            imageUrl = attrs.logo,
                            imageBackup = R.drawable.m2b_ic_card_visual_error_logo,
                            contentScale = ContentScale.Fit,
                            shimmerShape = M2BTheme.shapes.extraExtraLarge,
                        )

                        Spacer(modifier = Modifier.weight(fillRemainingSpace))

                        attrs.pillText?.let { text ->
                            PillXl(text, Modifier.align(Alignment.CenterVertically))
                        }
                    }

                    SpacerS()

                    Text(
                        text = attrs.description,
                        style = typography.bodyS,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }

    }
}

@Stable
data class AttrsCardVisual(
    val image: String,
    val logo: String,
    val description: String,
    val contentScale: ContentScale = ContentScale.FillHeight,
    val pillText: String? = null,
    val id: String? = null,
    val destination: String? = null,
)

@Stable
data class AttrsCardVisualList(
    val list: List<AttrsCardVisual>,
)

@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.0f,
)
@Composable
private fun PreviewOffer() {
    BasicPreview(M2bColorsTheme.M2B) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
        )
        {
            val attrs = AttrsCardVisual(
                image = "https://i.ibb.co/48kFBRr/image-35.png",
                logo = "https://i.ibb.co/wWLrMN7/UE-circulo.png",
                description = "{Text Description info card}\n" +
                        "{Text Description info card}\n" +
                        "{Text Description info card}\n" +
                        "{Text Description info card}\n" +
                        "{Text Description info card}",
                pillText = "{00/LABEL}",
            )

            val listOfAttrs = AttrsCardVisualList(listOf(attrs, attrs, attrs))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Lo más destacado",
                    style = typography.bodyL.bold,
                    modifier = Modifier.padding(horizontal = 20.dp),
                )

                SpacerS()

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    listOfAttrs.list.forEach {
                        CardVisualSmall(
                            image = it.image,
                            logo = it.logo,
                            description = it.description,
                            pillText = it.pillText,
                        )
                    }
                }

                SpacerXL()

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    listOfAttrs.list.forEach {
                        CardVisualSmall(it, onClick = {})
                    }

                    SpacerXL()
                }
            }
        }
    }
}
