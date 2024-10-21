package com.example.designkit.ui.template.result

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.ui.molecule.illustrationmessage.RemoteIllustrationMessageResult
import com.example.designkit.ui.template.result.attrs.AttrsResultTemplate
import com.example.designkit.ui.template.result.internal.AlertResultBottom
import com.example.designkit.ui.template.result.internal.BasicResultTemplate

@Composable
fun RemoteResultTemplate(
    attrs: AttrsResultTemplate,
    modifier: Modifier = Modifier,
    secondaryButtonAction: (() -> Unit)? = null,
    primaryButtonAction: () -> Unit,
) {
    BasicResultTemplate(
        modifier = modifier,
        scrollable = attrs.scrollable,
        illustrationMessage = {
            RemoteIllustrationMessageResult(
                title = attrs.title,
                description = attrs.description,
                imageUrl = attrs.imageUrl.orEmpty(),
                imageBackup = attrs.imageLocal,
                imageDescription = attrs.imageDescription,
            )
        },
    ) {
        AlertResultBottom(
            alertText = attrs.alertText,
            primaryButtonText = attrs.primaryButtonText,
            modifier = modifier,
            secondaryButtonText = attrs.secondaryButtonText,
            alertIcon = attrs.alertIcon,
            secondaryButtonAction = secondaryButtonAction,
            primaryButtonAction = primaryButtonAction,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ResultRemotePreview() {
    RemoteResultTemplate(
        attrs = AttrsResultTemplate(
            title = "Title",
            description = "Description",
            imageLocal = R.drawable.m2b_img_error,
            imageUrl = "https://www.google.com/",
            primaryButtonText = "Primary",
            scrollable = false,
        ),
        primaryButtonAction = {},
    )
}
