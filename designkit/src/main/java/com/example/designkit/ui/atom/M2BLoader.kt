package com.example.designkit.ui.atom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MPLoader(variant: MachLoaderVariant = MachLoaderVariant.PRIMARY) = Box(
    Modifier
        .width(24.dp)
        .height(24.dp),
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(if (variant != MachLoaderVariant.PRIMARY) "animations/loader-btn.json" else "animations/loader-btn-white.json"))
    LottieAnimation(composition, iterations = LottieConstants.IterateForever)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    MPLoader()
}

enum class MachLoaderVariant {
    PRIMARY, OUTLINE
}
