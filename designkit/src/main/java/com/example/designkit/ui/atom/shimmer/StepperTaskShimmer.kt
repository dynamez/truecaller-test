package com.example.designkit.ui.atom.shimmer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.theme.M2BTheme.dimens

@Composable
fun StepperTaskShimmer(
    modifier: Modifier = Modifier,
    lineHeight: Dp = dimens.dimen16,
    lineAmount: Int = 1,
    spacedBy: Dp = dimens.dimen0,
) {
    Row(modifier = modifier) {
        ShimmerBox(
            Modifier
                .size(dimens.dimen24)
                .clip(shape = RoundedCornerShape(dimens.dimen24)),
        )

        Spacer(Modifier.width(dimens.dimen16))

        LineShimmer(
            height = lineHeight,
            amount = lineAmount,
            spacedBy = spacedBy,
        )
    }
}

@Composable
@Preview
private fun StepperTaskShimmerPreview() {
    BasicPreview {
        StepperTaskShimmer(
            lineAmount = 2,
            spacedBy = dimens.dimen4,
        )
    }
}
