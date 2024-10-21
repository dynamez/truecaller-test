package com.example.designkit.ui.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.commons.isCoilImageLoading
import com.example.designkit.ext.shimmer
import com.example.designkit.ui.theme.M2BTheme
import coil.compose.rememberImagePainter

@Composable
fun InternetImage(
    imageUrl: String,
    @DrawableRes imageBackup: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    shimmerShape: Shape = M2BTheme.shapes.extraSmall,
    colorFilter: ColorFilter? = null,
    alpha: Float = DefaultAlpha,
    alignment: Alignment = Alignment.Center,
    isLoading: (Boolean) -> Unit = {},
) {
    val imagePainter = rememberImagePainter(data = imageUrl) { error(imageBackup) }

    val imageIsLoading by remember { derivedStateOf { imagePainter.isCoilImageLoading() } }
        .also { isLoading(it.value) }

    Image(
        modifier = Modifier
            .shimmer(
                visible = imageIsLoading,
                shape = shimmerShape
            )
            .then(modifier),
        painter = imagePainter,
        contentScale = contentScale,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        alignment = alignment,
        alpha = alpha,
    )
}

@Composable
fun UnboundInternetImage(
    imageUrl: String,
    @DrawableRes imageBackup: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    shimmerShape: Shape = M2BTheme.shapes.extraSmall,
    colorFilter: ColorFilter? = null,
    alpha: Float = DefaultAlpha,
    alignment: Alignment = Alignment.Center,
    unboundAlignment: Alignment.Vertical = Alignment.CenterVertically,
    isLoading: (Boolean) -> Unit = {},
) {
    val imagePainter = rememberImagePainter(data = imageUrl) { error(imageBackup) }

    val imageIsLoading by remember { derivedStateOf { imagePainter.isCoilImageLoading() } }
        .also { isLoading(it.value) }

    Image(
        modifier = Modifier
            .wrapContentHeight(align = unboundAlignment, unbounded = true)
            .shimmer(
                visible = imageIsLoading,
                shape = shimmerShape
            )
            .then(modifier),
        painter = imagePainter,
        contentScale = contentScale,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        alignment = alignment,
        alpha = alpha,
    )
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        InternetImage(
            modifier = Modifier.size(100.dp),
            imageUrl = "https://api-staging.soymach.com/p2m/images/success/qr.png",
            imageBackup = R.drawable.m2b_ic_mach_circle_violet,
        )
    }
}