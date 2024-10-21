package com.example.designkit.ui.template

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.AnimatedImage
import com.example.designkit.ui.atom.CircularLoader
import com.example.designkit.ui.atom.SpacerM
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold

@Composable
fun AnimatedLoaderTemplate(
    animationAsset: String,
    animationSize: Dp,
    modifier: Modifier = Modifier,
    bottomText: String? = null,
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.Center)
                .then(modifier),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AnimatedImage(
                modifier = Modifier
                    .size(animationSize),
                animation = animationAsset,
            )
        }
        bottomText?.let {
            Text(
                modifier = Modifier
                    .align(BottomCenter)
                    .padding(bottom = 16.dp),
                text = it,
                textAlign = TextAlign.Center,
                style = typography.bodyM,
                color = M2BTheme.colors.content,
            )
        }
    }
}

@Composable
fun CircularLoaderTemplate(
    title: String? = null,
    description: String? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .then(Modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularLoader(size = 128.dp, strokeWidth = 8.dp)

        SpacerM()

        title?.let {
            Text(
                modifier = Modifier,
                text = it,
                textAlign = TextAlign.Center,
                style = typography.subtitleM.bold,
            )
        }
        description?.let {
            Text(
                modifier = Modifier,
                text = it,
                textAlign = TextAlign.Center,
                style = typography.bodyM,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        AnimatedLoaderTemplate(
            modifier = Modifier,
            animationAsset = "animations/machpay-simple-animation.json",
            animationSize = 200.dp,
            bottomText = "v1.12.0",
        )
    }
}
