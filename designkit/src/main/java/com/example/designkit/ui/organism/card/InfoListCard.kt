package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.atom.SpacerXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.organism.card.Card

@Composable
fun InfoListCard(
    @DrawableRes icon: Int,
    firstLabel: String,
    firstText: String,
    attrs: AttrsInfoListCard,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .then(modifier),
        shape = M2BTheme.shapes.small,
        border = BorderStroke(1.dp, M2BTheme.colors.contentLighter),
        backgroundColor = M2BTheme.colors.surface,
        elevation = 0.dp,
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Icon(
                modifier = Modifier.size(24.dp.scaled),
                painter = painterResource(icon),
                contentDescription = null,
                tint = M2BTheme.colors.primary,
            )

            SpacerSM()

            Column {
                Row {
                    Text(
                        text = firstLabel,
                        style = typography.bodyL.bold,
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End),
                        text = firstText,
                        style = typography.bodyL.bold,
                    )
                }

                SpacerXS()
                HorizontalDivider()

                attrs.list.forEach { item ->
                    SpacerXS()

                    Row {
                        Text(text = item.title, style = typography.bodyM)

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.End),
                            text = item.value,
                            textAlign = TextAlign.End,
                            style = if (item.bigValue) typography.bodyM.bold else typography.bodyM,
                        )
                    }
                }
            }
        }
    }
}

@Stable
data class AttrsInfoListCard(
    val list: List<AttrsInfoItem> = emptyList(),
)

@Stable
data class AttrsInfoItem(
    val title: String,
    val value: String,
    val name: String? = null,
    val bigValue: Boolean = false,
)

@Preview(showBackground = true, showSystemUi = true, fontScale = 1.5f)
@Composable
private fun InfoListCardPreview() {
    BasicPreview {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            InfoListCard(
                modifier = Modifier
                    .width(320.dp),
                icon = R.drawable.m2b_ic_new_bill,
                firstLabel = "Total:",
                firstText = "$16.500",
                attrs = AttrsInfoListCard(
                    listOf(
                        AttrsInfoItem(
                            title = "Subtotal:",
                            value = "$15.000",
                        ),
                        AttrsInfoItem(
                            title = "Propina:",
                            value = "$1.500",
                        ),
                    ),
                ),
            )
        }
    }
}
