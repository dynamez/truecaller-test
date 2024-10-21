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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.GrayCultured
import com.example.designkit.ui.theme.LocalFloat.float_1
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import coil.compose.rememberImagePainter
import com.example.designkit.ui.organism.card.Card

@Composable
fun SelectableCard(
    attrs: AttrsSelectableCard,
    modifier: Modifier = Modifier,
) {
    val imagePainter = rememberImagePainter(attrs.startIcon) {
        placeholder(attrs.startIconBackup)
        error(attrs.startIconBackup)
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.dimen8),
        border = BorderStroke(dimens.dimen1, GrayCultured),
        elevation = dimens.dimen0,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            if (!attrs.hideStartIcon) {
                Spacer(modifier = Modifier.width(dimens.dimen16))
                Image(
                    modifier = Modifier
                        .padding(end = dimens.dimen16)
                        .size(dimens.dimen24),
                    painter = imagePainter,
                    contentDescription = null,
                )
            }

            Column(
                modifier = Modifier.padding(dimens.dimen16),
            ) {
                Text(text = attrs.topText, style = typography.bodyM.bold)

                attrs.middleText?.let {
                    Text(
                        text = it,
                        color = colors.contentDark,
                        style = typography.bodyS.bold,
                    )
                }

                attrs.bottomText?.let {
                    Text(
                        text = it,
                        color = colors.contentDark,
                        style = typography.bodyS,
                    )
                }
            }

            Spacer(modifier = Modifier.weight(float_1))

            if (attrs.checked) {
                Icon(
                    painter = painterResource(attrs.endIcon),
                    contentDescription = null,
                    tint = colors.primary,
                )
            }

            Spacer(Modifier.padding(end = dimens.dimen16))
        }
    }
}

class AttrsSelectableCard(
    val key: String,
    @DrawableRes val startIconBackup: Int,
    val topText: String,
    val bottomText: String? = null,
    @DrawableRes val endIcon: Int,
    val hideStartIcon: Boolean = false,
    val middleText: String? = null,
    val startIcon: String? = null,
    initialCheck: Boolean = false,
) {
    var checked by mutableStateOf(initialCheck)
}

@Preview
@Composable
fun SelectableCardPreview() {
    BasicPreview(M2bColorsTheme.M2B) {
        Column(Modifier.padding(dimens.dimen20)) {
            SelectableCard(
                AttrsSelectableCard(
                    key = "1",
                    startIconBackup = R.drawable.m2b_ic_new_bill,
                    topText = "Cuenta corriente",
                    bottomText = "56418806",
                    middleText = "Saldo $430.000",
                    endIcon = R.drawable.m2b_ic_check,
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
