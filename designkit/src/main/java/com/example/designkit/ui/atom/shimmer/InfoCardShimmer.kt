package com.example.designkit.ui.atom.shimmer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.organism.card.Card
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.shapes

@Composable
fun InfoCardShimmer(
    modifier: Modifier = Modifier,
    lineHeight: Dp,
    linesAmount: Int,
    showIcon: Boolean = true,
) {
    Card(
        modifier = modifier,
        shape = shapes.small,
        border = BorderStroke(dimens.dimen1, M2BTheme.colors.contentLight),
        elevation = dimens.noElevation,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(dimens.dimen20))

            if (showIcon) {
                ShimmerBox(
                    modifier = Modifier
                        .size(dimens.dimen24),
                )
                Spacer(modifier = Modifier.width(dimens.dimen16))
            }

            Column {
                Spacer(modifier = Modifier.height(dimens.dimen20))
                LineShimmer(
                    height = lineHeight,
                    amount = linesAmount,
                    spacedBy = dimens.dimen4,
                )
                Spacer(modifier = Modifier.height(dimens.dimen20))
            }
        }
    }
}

@Composable
@Preview
private fun InfoCardShimmerPreview() {
    BasicPreview {
        Column() {
            InfoCardShimmer(
                lineHeight = dimens.dimen16,
                linesAmount = 4,
            )
        }
    }
}
