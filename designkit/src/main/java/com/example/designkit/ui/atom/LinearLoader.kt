package com.example.designkit.ui.atom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors

@Composable
fun LinearLoader(
    modifier: Modifier = Modifier,
    strokeHeight: Dp = 4.dp,
    colorPrimary: Color = colors.primary,
    colorSecondary: Color = colors.contentLight,
    ) {
    LinearProgressIndicator(
        modifier = modifier
            .clip(M2BTheme.shapes.medium)
            .height(strokeHeight)
            .fillMaxWidth()
        ,
        color = colorPrimary,
        trackColor = colorSecondary,
    )
}

@Preview(
    heightDp = 180,
    showBackground = true,
    apiLevel = 33,
)
@Composable
private fun Preview() {
    BasicPreview {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearLoader(modifier = Modifier.width(280.dp))
            LinearLoader(modifier = Modifier.width(154.dp))
            LinearLoader(modifier = Modifier.width(128.dp))
            LinearLoader(modifier = Modifier.width(60.dp))
        }
    }
}
