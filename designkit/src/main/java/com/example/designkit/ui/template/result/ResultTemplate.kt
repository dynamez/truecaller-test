package com.example.designkit.ui.template.result

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.ui.molecule.illustrationmessage.IllustrationMessageResult
import com.example.designkit.ui.molecule.navigationbar.ScaffoldBackIcon
import com.example.designkit.ui.template.result.attrs.AttrsResultTemplate
import com.example.designkit.ui.template.result.internal.AlertResultBottom
import com.example.designkit.ui.template.result.internal.BasicResultTemplate

@Composable
fun ResultTemplate(
    attrs: AttrsResultTemplate,
    modifier: Modifier = Modifier,
    secondaryButtonAction: (() -> Unit)? = null,
    primaryButtonAction: () -> Unit,
) {
    BasicResultTemplate(
        modifier = modifier,
        scrollable = attrs.scrollable,
        illustrationMessage = {
            IllustrationMessageResult(
                title = attrs.title,
                description = attrs.description,
                image = attrs.imageLocal,
                imageDescription = attrs.imageDescription
            )
        },
    ) {
        AlertResultBottom(
            alertText = attrs.alertText,
            primaryButtonText = attrs.primaryButtonText,
            secondaryButtonText = attrs.secondaryButtonText,
            alertIcon = attrs.alertIcon,
            secondaryButtonAction = secondaryButtonAction,
            primaryButtonAction = primaryButtonAction,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ResultAlertPreview() {
    ResultTemplate(
        AttrsResultTemplate(
            title = "Title",
            description = "Description",
            imageLocal = R.drawable.m2b_img_error,
            alertText = "Alert",
            alertIcon = R.drawable.mb2_ic_info,
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
        ),
        primaryButtonAction = {},
        secondaryButtonAction = {},
    )
}


@Preview(showBackground = true)
@Composable
private fun ScaffoldResultPreview() {
    ScaffoldBackIcon { padding ->
        ResultTemplate(
            modifier = Modifier.padding(padding),
            attrs = AttrsResultTemplate(
                title = "Title",
                description = "Description",
                imageLocal = R.drawable.m2b_img_error,
                primaryButtonText = "Ir al inicio",
            ),
            primaryButtonAction = {},
        )
    }
}

