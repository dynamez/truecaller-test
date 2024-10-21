package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.SpacerM
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.SpacerXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.molecule.pill.ExtendedPillS
import com.example.designkit.ui.theme.ContentLight
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.organism.card.Card

@Composable
fun CardSelectPayMethod(
    attrs: AttrsCardSelectPayMethod,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, ContentLight),
        elevation = dimens.noElevation,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!attrs.hideStartIcon) {
                InternetImage(
                    modifier = Modifier
                        .size(24.dp),
                    imageUrl = attrs.startIcon,
                    imageBackup = R.drawable.m2b_ic_card_credit,
                    contentDescription = null,
                )

                SpacerM()
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = attrs.topText,
                    style = typography.bodyM.bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )

                attrs.middleText?.let {
                    Text(
                        text = it,
                        color = colors.contentDark,
                        style = typography.bodyS.bold,
                    )
                }

                attrs.bottomText?.let {
                    Row {
                        Text(
                            text = it,
                            color = colors.contentDark,
                            style = typography.bodyS,
                        )

                        SpacerXS()

                        attrs.pillText?.let { pillText ->
                            ExtendedPillS(
                                text = pillText,
                                backgroundColor = colors.success
                            )
                        }
                    }
                }
            }

            if (attrs.checked) {
                SpacerM()

                Icon(
                    painter = painterResource(attrs.endIcon),
                    contentDescription = null,
                    tint = colors.primary,
                )
            }
        }
    }
}

class AttrsCardSelectPayMethod(
    val key: String,
    @DrawableRes val startIconBackup: Int,
    val topText: String,
    val bottomText: String? = null,
    @DrawableRes val endIcon: Int,
    val hideStartIcon: Boolean = false,
    val middleText: String? = null,
    val startIcon: String = "",
    val pillText: String? = null,
    initialCheck: Boolean = false,
) {
    var checked by mutableStateOf(initialCheck)
}

@Preview
@Composable
private fun Preview() {
    BasicPreview(M2bColorsTheme.M2B) {
        Column(Modifier.padding(dimens.dimen20)) {
            CardSelectPayMethod(
                AttrsCardSelectPayMethod(
                    key = "1",
                    startIconBackup = R.drawable.m2b_ic_new_bill,
                    topText = "Tarjeta de crédito visa signature",
                    bottomText = "56418806",
                    middleText = "Saldo $430.000",
                    endIcon = R.drawable.m2b_ic_check,
                    pillText = "24 cuotas",
                    initialCheck = true,
                ),
            )
            SpacerS()
            SelectableCard(
                attrs = AttrsSelectableCard(
                    key = "2",
                    startIconBackup = R.drawable.m2b_ic_new_bill,
                    topText = "24 cuotas",
                    bottomText = null,
                    middleText = null,
                    endIcon = R.drawable.m2b_ic_check,
                    initialCheck = true,
                    hideStartIcon = true,
                ),
            )
            SpacerS()
        }
    }
}