package com.example.designkit.ui.atom

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.theme.Animations
import com.example.designkit.ui.theme.Default
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec.Asset
import com.airbnb.lottie.compose.LottieConstants.IterateForever
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimatedImage(
    animation: String,
    modifier: Modifier = Modifier,
    repetitions: Int = IterateForever,
) {
    val composition by rememberLottieComposition(Asset(animation))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = repetitions,
    )
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        AnimatedImage(
            modifier = Modifier
                .size(256.dp),
            animation = Animations.MACHPAY.Default
        )
    }
}
