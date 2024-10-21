package com.example.designkit.ui.atom.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.theme.M2BTheme.dimens

@Composable
fun LineShimmer(
    height: Dp,
    modifier: Modifier = Modifier,
    amount: Int = 1,
    spacedBy: Dp = dimens.dimen0,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacedBy),
    ) {
        repeat(amount) {
            ShimmerBox(
                modifier = Modifier
                    .padding(end = dimens.dimen20)
                    .fillMaxWidth()
                    .height(height),
            )
        }
    }
}

@Composable
fun LineShimmer(
    modifier: Modifier = Modifier,
    height: Dp = 20.dp,
    numberOfLines: Int = 1,
    spacedBy: Dp = 4.dp,
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(spacedBy),
    ) {
        repeat(numberOfLines) {
            ShimmerBox(
                modifier = Modifier.then(modifier.height(height))
            )
        }
    }
}

@Composable
@Preview
private fun LineShimmerPreview() {
    BasicPreview {
        LineShimmer(
            height = dimens.dimen16,
            amount = 4,
            spacedBy = dimens.dimen4,
        )
    }
}
