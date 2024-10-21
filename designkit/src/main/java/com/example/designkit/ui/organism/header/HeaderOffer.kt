package com.example.designkit.ui.organism.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ext.toColorHex
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.PillL
import com.example.designkit.ui.atom.SpacerXL
import com.example.designkit.ui.atom.SpacerXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.organism.card.Card
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled

@Composable
fun HeaderOffer(
    image: String,
    backgroundColor: String,
    pillName: String,
    offerPrice: String,
    realPrice: String?,
    modifier: Modifier = Modifier,
    pillDiscount: String? = null,
) {

    Box(modifier = Modifier
        .background(backgroundColor.toColorHex())
        .semantics(mergeDescendants = true) { }
        .then(modifier)) {

        pillDiscount?.let {
            PillL(
                text = pillDiscount,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp),
            )
        }

        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            InternetImage(
                imageUrl = image,
                contentDescription = null,
                imageBackup = R.drawable.m2b_ic_small_logo_error,
                modifier = Modifier
                    .size(64.dp.scaled)
                    .clip(M2BTheme.shapes.smallMedium),
            )

            SpacerXS()

            PillL(
                text = pillName,
                backgroundColor = colors.contentDarker,
                colorText = colors.surface,
            )

            Text(
                text = offerPrice,
                style = typography.subHeadlineM.bold,
                color = colors.surface,
            )

            realPrice?.let {
                Text(
                    text = realPrice,
                    style = typography.subtitleM,
                    textDecoration = TextDecoration.LineThrough,
                    color = colors.surface,
                )
            }

            SpacerXS()
        }

        Card(
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            modifier = Modifier.align(Alignment.BottomCenter),
            elevation = 0.dp,
        ) {
            Box(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth(),
            )
        }
    }
}

@Stable
data class AttrsHeaderOffer(
    val image: String,
    val backgroundColor: String,
    val pillName: String,
    val offerPrice: String,
    val realPrice: String? = null,
    val pillDiscount: String? = null,
)

@Preview(showBackground = true, showSystemUi = true, fontScale = 1.0f)
@Composable
private fun Preview() {
    val attrs = AttrsHeaderOffer(
        image = "https://i.ibb.co/pjrjmxp/UE.png",
        backgroundColor = "#FFC50625",
        pillDiscount = "40% de dcto",
        pillName = "Catedral",
        offerPrice = "$84.000 / Anual",
        realPrice = " $140.000 / Anual",
    )

    BasicPreview(M2bColorsTheme.M2B) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
        )
        {
            HeaderOffer(
                image = attrs.image,
                backgroundColor = attrs.backgroundColor,
                pillName = attrs.pillName,
                offerPrice = attrs.offerPrice,
                realPrice = null,
                pillDiscount = attrs.pillDiscount,
            )
            SpacerXL()
        }
    }
}
