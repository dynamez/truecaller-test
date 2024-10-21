package com.example.designkit.ui.atom.shimmer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview

@Composable
fun DoubleInfoCardShimmer(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {

        Row(
            modifier = Modifier
                .padding(top = 10.dp, start = 16.dp, end = 0.dp, bottom = 16.dp)
                .fillMaxWidth(),
        ) {
            ShimmerBox(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(24.dp),
            )

            LineShimmer(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(0.4f),
                height = 16.dp,
                amount = 1,
                spacedBy = 4.dp,
            )

            LineShimmer(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(0.6f),
                height = 16.dp,
                amount = 1,
                spacedBy = 4.dp,
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 0.dp, bottom = 16.dp)
        ) {
            ShimmerBox(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(24.dp),
            )

            LineShimmer(
                modifier = Modifier
                    .weight(0.6f),
                height = 16.dp,
                amount = 3,
                spacedBy = 8.dp,
            )

            LineShimmer(
                modifier = Modifier
                    .weight(0.4f),
                height = 24.dp,
                amount = 1,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        DoubleInfoCardShimmer()
    }
}
