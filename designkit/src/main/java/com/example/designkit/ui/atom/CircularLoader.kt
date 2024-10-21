package com.example.designkit.ui.atom

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.CircularLoaderDefaults.NINETY
import com.example.designkit.ui.atom.CircularLoaderDefaults.durationInMillis
import com.example.designkit.ui.atom.CircularLoaderDefaults.initialValue
import com.example.designkit.ui.atom.CircularLoaderDefaults.targetValue
import com.example.designkit.ui.theme.LocalFloat.float_0
import com.example.designkit.ui.theme.LocalFloat.float_180
import com.example.designkit.ui.theme.LocalFloat.float_360
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.dimens


@Composable
fun CircularLoader(
    size: Dp,
    strokeWidth: Dp,
    colorPrimary: Color = colors.primary,
    colorSecondary: Color = colors.primaryLight,
    durationMillis: Int = durationInMillis,
) {
    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
    }
    val transition = rememberInfiniteTransition()
    val currentArcStartAngle by transition.animateValue(
        initialValue = initialValue,
        targetValue = targetValue,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing
            )
        )
    )

    Canvas(modifier = Modifier.size(size)) {
        drawArc(
            color = colorPrimary,
            startAngle = float_0,
            sweepAngle = float_360,
            useCenter = false,
            style = stroke
        )

        drawArc(
            color = colorSecondary,
            startAngle = currentArcStartAngle.toFloat() - NINETY,
            sweepAngle = float_180,
            useCenter = false,
            style = stroke
        )
    }
}

private object CircularLoaderDefaults {
    const val initialValue = 0
    const val targetValue = 360
    const val durationInMillis = 1000
    const val NINETY = 90
}

@Preview(showBackground = true)
@Composable
private fun Preview(modifier: Modifier = Modifier) {
    BasicPreview {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(dimens.dimen40, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularLoader(size = dimens.dimen128, strokeWidth = 8.dp)
            CircularLoader(size = dimens.dimen40, strokeWidth = 6.dp)
            CircularLoader(size = dimens.dimen32, strokeWidth = 4.dp)
        }
    }
}