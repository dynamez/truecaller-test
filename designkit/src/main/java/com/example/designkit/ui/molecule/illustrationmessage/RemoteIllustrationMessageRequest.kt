package com.example.designkit.ui.molecule.illustrationmessage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.molecule.illustrationmessage.BasicIllustrationMessage
import com.example.designkit.ui.theme.M2BTheme

@Composable
fun RemoteIllustrationMessageRequest(
    title: String,
    description: String,
    imageUrl: String,
    imageDescription: String,
    @DrawableRes imageBackup: Int,
    modifier: Modifier = Modifier,
) {
    BasicIllustrationMessage(
        modifier = modifier,
        title = title,
        description = description,
    ) {
        InternetImage(
            imageUrl = imageUrl,
            contentDescription = imageDescription,
            modifier = Modifier.size(256.dp),
            shimmerShape = M2BTheme.shapes.fullCircleShape,
            imageBackup = imageBackup,
        )
    }
}