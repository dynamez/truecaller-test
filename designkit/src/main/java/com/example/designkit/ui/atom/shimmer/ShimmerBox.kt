package com.example.designkit.ui.atom.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ext.shimmer
import com.example.designkit.ui.theme.M2BTheme.dimens

@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.shimmer(),
    )
}

@Composable
@Preview(showBackground = true)
private fun ShimmerBoxPreview() {
    BasicPreview {
        ShimmerBox(
            Modifier
                .size(dimens.dimen30),
        )
    }
}
