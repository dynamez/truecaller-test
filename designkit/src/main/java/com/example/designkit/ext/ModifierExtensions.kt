package com.example.designkit.ext

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Shape
import com.example.designkit.ext.ShimmerDefaults.DELAY
import com.example.designkit.ext.ShimmerDefaults.DURATION
import com.example.designkit.ui.theme.GrayShimmer
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.commons.placeholder.base.PlaceholderHighlight
import com.example.designkit.commons.placeholder.base.placeholder
import com.example.designkit.commons.placeholder.material.shimmer

fun Modifier.shimmer(
    visible: Boolean = true,
    shape: Shape? = null,
    duration: Int = DURATION,
    delay: Int = DELAY,
    easing: Easing = LinearEasing,
): Modifier = composed {
    this.then(
        Modifier.placeholder(
            color = GrayShimmer,
            visible = visible,
            shape = shape ?: M2BTheme.shapes.extraSmall,
            highlight = PlaceholderHighlight.shimmer(
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = duration, delay, easing = easing),
                    repeatMode = RepeatMode.Restart,
                ),
            ),
        ),
    )
}

private object ShimmerDefaults {
    const val DURATION = 1000
    const val DELAY = 200
}

fun Modifier.conditional(condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
    return if (condition) then(modifier(Modifier)) else this
}