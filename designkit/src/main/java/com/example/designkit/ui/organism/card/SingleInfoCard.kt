package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.LocalFloat
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.organism.card.Card

@Composable
fun SingleInfoCard(
    @DrawableRes icon: Int,
    primaryText: String,
    modifier: Modifier = Modifier,
    iconColor: Color = M2BTheme.colors.primary,
    secondaryText: String? = null,
    bottomText: String? = null,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {},
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, M2BTheme.colors.contentLighter),
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp.scaled),
                painter = painterResource(icon),
                contentDescription = null,
                tint = iconColor,
            )

            SpacerSM()

            Column {
                Row {
                    Text(text = primaryText, style = typography.bodyM)

                    Spacer(modifier = Modifier.weight(LocalFloat.float_1))

                    secondaryText?.let {
                        Text(text = secondaryText, style = typography.bodyL.bold)
                    }
                }

                Row {
                    bottomText?.let {
                        Text(
                            text = bottomText,
                            style = typography.bodyM.bold,
                        )
                    }
                }
            }
        }
    }
}

@Preview(fontScale = 1.5f)
@Composable
private fun SingleInfoCardPreview() {
    M2BTheme {
        Column {
            SingleInfoCard(
                icon = R.drawable.m2b_ic_new_bill,
                primaryText = "Monto:",
                secondaryText = "$15.000",
            )
            Spacer(modifier = Modifier.size(dimens.dimen4))
            SingleInfoCard(
                icon = R.drawable.m2b_ic_new_bill,
                primaryText = "Monto:",
                bottomText = "$15.000",
            )
        }
    }
}
