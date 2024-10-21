package com.example.designkit.ui.molecule.illustrationmessage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R

@Composable
fun IllustrationMessageResult(
    title: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
    description: String? = null,
    imageDescription: String? = null,
) {
    BasicIllustrationMessage(
        modifier = modifier,
        title = title,
        description = description,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = imageDescription,
            modifier = Modifier.size(width = 150.dp, height = 128.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 279)
@Composable
private fun Preview() {
    IllustrationMessageResult(
        image = R.drawable.m2b_img_error,
        title = "Ocurrió un problema",
        description = "En este momento no podemos continuar.\nPor favor vuelve a intentarlo.",
    )
}