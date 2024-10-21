package com.example.designkit.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.shapes
import com.example.designkit.ui.theme.bold

@Composable
fun SimpleCircle(
    modifier: Modifier = Modifier,
    size: Dp,
    backgroundColor: Color,
    content: @Composable BoxScope.() -> Unit,
) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(backgroundColor),
            contentAlignment = Alignment.Center,
        ) {
            content.invoke(this)
        }
    }
}

@Composable
fun SimpleCircle(
    modifier: Modifier = Modifier,
    size: Dp,
    backgroundColor: Color,
) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(backgroundColor),
        )
    }
}

@Composable
fun SimpleRoundedSquare(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    shape: RoundedCornerShape = shapes.small,
    content: @Composable BoxScope.() -> Unit,

) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(shape)
                .background(backgroundColor),
        ) {
            content.invoke(this)
        }
    }
}

class FullCircleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val diameter = minOf(size.width, size.height)
        val radius = diameter / 2
        val left = (size.width - diameter) / 2
        val top = (size.height - diameter) / 2
        val right = left + diameter
        val bottom = top + diameter
        val rect = Rect(left, top, right, bottom)
        return Outline.Generic(Path().apply {
            addRoundRect(RoundRect(rect, CornerRadius(radius, radius)))
        })
    }
}

@Composable
@Preview
private fun Preview() {
    BasicPreview() {
        Column(
            modifier = Modifier.padding(M2BTheme.dimens.dimen75),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SimpleCircle(
                size = M2BTheme.dimens.dimen40,
                backgroundColor = M2BTheme.colors.primary,
            ) {
                Icon(
                    painter = painterResource(R.drawable.m2b_ic_check),
                    contentDescription = null,
                    tint = M2BTheme.colors.background,
                )
            }
            Spacer(modifier = Modifier.size(M2BTheme.dimens.dimen40))

            SimpleCircle(size = M2BTheme.dimens.dimen128, backgroundColor = M2BTheme.colors.primary)

            Spacer(modifier = Modifier.size(M2BTheme.dimens.dimen40))

            SimpleRoundedSquare(backgroundColor = M2BTheme.colors.primary) {
                Text(
                    modifier = Modifier.padding(M2BTheme.dimens.dimen8),
                    text = "10",
                    style = M2BTheme.typography.subtitleL.bold,
                    color = M2BTheme.colors.contentLighter,
                )
            }
        }
    }
}
