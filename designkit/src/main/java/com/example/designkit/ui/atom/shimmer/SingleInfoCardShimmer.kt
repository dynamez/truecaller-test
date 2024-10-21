package com.example.designkit.ui.atom.shimmer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview

@Composable
fun SingleInfoCardShimmer(
    modifier: Modifier = Modifier,
    showIcon: Boolean = true,
    showBottomText: Boolean = true,
) {
    Row(
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp, end = 0.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        if (showIcon) {
            ShimmerBox(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(24.dp),
            )
        }

        LineShimmer(
            modifier = Modifier
                .padding(top = 4.dp)
                .weight(0.6f),
            height = 16.dp,
            amount = if (showBottomText) 2 else 1,
            spacedBy = 4.dp,
        )

        if (!showBottomText) {
            LineShimmer(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(0.4f),
                height = 16.dp,
                amount = 1,
                spacedBy = 4.dp,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        Column {
            SingleInfoCardShimmer(
                showIcon = true,
                showBottomText = false,
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.size(4.dp))
            HorizontalDivider()
            SingleInfoCardShimmer(
                showIcon = false,
                showBottomText = false,
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.size(4.dp))
            HorizontalDivider()
            SingleInfoCardShimmer(
                showIcon = true,
                showBottomText = true,
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.size(4.dp))
            HorizontalDivider()
            SingleInfoCardShimmer(
                showIcon = false,
                showBottomText = true,
            )
        }
    }
}
