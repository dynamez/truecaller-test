package com.example.designkit.ui.template

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ext.toBoldMarkDown
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.SpacerFillSpace
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.molecule.button.ButtonFullWidth
import com.example.designkit.ui.molecule.button.OutlinedButtonFullWidth
import com.example.designkit.ui.molecule.illustrationmessage.BasicIllustrationMessage
import com.example.designkit.ui.theme.LocalFloat.fillRemainingSpace
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold

@Deprecated(
    message = "This composable is deprecated due to re-usability issues",
    replaceWith = ReplaceWith(
        "ResultTemplate or ResultRemoteTemplate",
        "com.example.designkit.ui.template.ResultTemplate",
        "com.example.designkit.ui.template.ResultRemoteTemplate",
    ),
)
@Composable
fun ResultTemplate(
    @DrawableRes image: Int,
    title: String,
    description: String,
    buttonText: String = "Reintentar",
    outlinedButtonText: String = "Ir al inicio",
    onOutlinedButtonClicked: () -> Unit,
    onButtonClicked: () -> Unit,
) {
    val modifier = Modifier

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.size(76.dp))

        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = title,
            style = typography.subtitleM.bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = description.toBoldMarkDown(),
            style = typography.bodyM,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.weight(fillRemainingSpace))

        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = dimens.screenHorizontalPadding),
            text = buttonText,
            onClick = onButtonClicked,
        )

        Spacer(modifier = Modifier.size(12.dp))

        OutlinedButtonFullWidth(
            modifier = Modifier.padding(horizontal = dimens.screenHorizontalPadding),
            text = outlinedButtonText,
            onClick = onOutlinedButtonClicked,
        )

        Spacer(modifier = Modifier.size(12.dp))
    }
}

@Deprecated(
    message = "This composable is deprecated due to re-usability issues",
    replaceWith = ReplaceWith(
        "ResultTemplate or ResultRemoteTemplate",
        "com.example.designkit.ui.template.ResultTemplate",
        "com.example.designkit.ui.template.ResultRemoteTemplate",
    ),
)
@Composable
fun ResultTemplate(
    @DrawableRes image: Int,
    title: String,
    description: String,
    buttonText: String = "Ir al inicio",
    onButtonClicked: () -> Unit,
) {
    val modifier = Modifier

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(Modifier.size(92.dp))

        Image(
            painter = painterResource(image),
            contentDescription = String(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = title,
            style = typography.subtitleM.bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = description.toBoldMarkDown(),
            style = typography.bodyM,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.weight(fillRemainingSpace))

        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = dimens.screenHorizontalPadding),
            text = buttonText,
            onClick = onButtonClicked,
        )

        Spacer(modifier = Modifier.size(12.dp))
    }
}

@Deprecated(
    message = "This composable is deprecated due to re-usability issues",
    replaceWith = ReplaceWith(
        "ResultTemplate or ResultRemoteTemplate",
        "com.example.designkit.ui.template.ResultTemplate",
        "com.example.designkit.ui.template.ResultRemoteTemplate",
    ),
)
@Composable
fun ResultTemplate(
    title: String,
    description: String,
    imageUrl: String,
    @DrawableRes localImage: Int,
    imageDescription: String? = null,
    buttonText: String = "Reintentar",
    outlinedButtonText: String = "Ir al inicio",
    onOutlinedButtonClicked: () -> Unit,
    onButtonClicked: () -> Unit,
) {
    val modifier = Modifier

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.size(76.dp))

        InternetImage(
            imageUrl = imageUrl,
            imageBackup = localImage,
            contentDescription = imageDescription,
            modifier = Modifier
                .size(150.dp, 128.dp)
                .align(Alignment.CenterHorizontally),
            shimmerShape = M2BTheme.shapes.fullCircleShape,
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = title,
            style = typography.subtitleM.bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = description.toBoldMarkDown(),
            style = typography.bodyM,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.weight(fillRemainingSpace))

        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = dimens.screenHorizontalPadding),
            text = buttonText,
            onClick = onButtonClicked,
        )

        Spacer(modifier = Modifier.size(12.dp))

        OutlinedButtonFullWidth(
            modifier = Modifier.padding(horizontal = dimens.screenHorizontalPadding),
            text = outlinedButtonText,
            onClick = onOutlinedButtonClicked,
        )

        Spacer(modifier = Modifier.size(12.dp))
    }
}

@Deprecated(
    message = "This composable is deprecated due to re-usability issues",
    replaceWith = ReplaceWith(
        "ResultTemplate or ResultRemoteTemplate",
        "com.example.designkit.ui.template.ResultTemplate",
        "com.example.designkit.ui.template.ResultRemoteTemplate",
    ),
)
@Composable
fun ResultTemplate(
    title: String,
    description: String,
    imageUrl: String,
    @DrawableRes localImage: Int,
    imageDescription: String? = null,
    buttonText: String = "Ir al inicio",
    onButtonClicked: () -> Unit,
) {
    val modifier = Modifier

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(Modifier.size(92.dp))

        InternetImage(
            imageUrl = imageUrl,
            imageBackup = localImage,
            contentDescription = imageDescription,
            modifier = Modifier
                .size(150.dp, 128.dp)
                .align(Alignment.CenterHorizontally),
            shimmerShape = M2BTheme.shapes.fullCircleShape,
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = title,
            style = typography.subtitleM.bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = description.toBoldMarkDown(),
            style = typography.bodyM,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.weight(fillRemainingSpace))

        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = dimens.screenHorizontalPadding),
            text = buttonText,
            onClick = onButtonClicked,
        )

        Spacer(modifier = Modifier.size(12.dp))
    }
}

@Deprecated(
    message = "This composable is deprecated due to re-usability issues",
    replaceWith = ReplaceWith(
        "ResultTemplate or ResultRemoteTemplate",
        "com.example.designkit.ui.template.ResultTemplate",
        "com.example.designkit.ui.template.ResultRemoteTemplate",
    ),
)
@Composable
fun ErrorTemplate(
    @DrawableRes image: Int,
    title: String,
    description: String,
    buttonText: String = "Reintentar",
    outlinedButtonText: String = "Ir al inicio",
    onOutlinedButtonClicked: () -> Unit,
    onButtonClicked: () -> Unit,
) {
    ResultTemplate(
        image = image,
        title = title,
        description = description,
        buttonText = buttonText,
        outlinedButtonText = outlinedButtonText,
        onOutlinedButtonClicked = onOutlinedButtonClicked,
        onButtonClicked = onButtonClicked,
    )
}

private const val MORE_VERSATILE_TEMPLATE =
    "Deprecated and replaced for a more versatile template"

@Deprecated(
    message = MORE_VERSATILE_TEMPLATE,
    replaceWith = ReplaceWith(
        "BasicResultTemplate",
        "com.example.designkit.ui.template.result.BasicResultTemplate",
    )
)
@Composable
internal fun BasicResultTemplate(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    image: @Composable () -> Unit,
    buttons: @Composable () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SpacerFillSpace()

        BasicIllustrationMessage(title = title, description = description) {
            image()
        }

        SpacerFillSpace()

        buttons()

        SpacerS()
    }
}

@Deprecated(
    MORE_VERSATILE_TEMPLATE,
    ReplaceWith(
        "ResultTemplate",
        "com.example.designkit.ui.template.result.ResultTemplate",
    )
)
@Composable
fun ResultTemplate(
    attrs: AttrsResultTemplate,
    primaryButtonAction: () -> Unit,
    secondaryButtonAction: () -> Unit,
) {
    BasicResultTemplate(
        title = attrs.title,
        description = attrs.description,
        image = {
            Image(
                painter = painterResource(attrs.image),
                contentDescription = attrs.imageDescription,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        },
    ) {
        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = attrs.buttonText,
            onClick = primaryButtonAction,
        )

        SpacerS()

        OutlinedButtonFullWidth(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = attrs.outlinedButtonText.orEmpty(),
            onClick = secondaryButtonAction,
        )
    }
}

@Deprecated(
    MORE_VERSATILE_TEMPLATE,
    ReplaceWith(
        "ResultTemplate",
        "com.example.designkit.ui.template.result.ResultTemplate",
    )
)
@Composable
fun ResultTemplate(
    attrs: AttrsResultTemplate,
    primaryButtonAction: () -> Unit,
) {
    BasicResultTemplate(
        title = attrs.title,
        description = attrs.description,
        image = {
            Image(
                painter = painterResource(attrs.image),
                contentDescription = attrs.imageDescription,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        },
    ) {
        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = attrs.buttonText,
            onClick = primaryButtonAction,
        )
    }
}

@Deprecated(
    MORE_VERSATILE_TEMPLATE,
    ReplaceWith(
        "ResultTemplate",
        "com.example.designkit.ui.template.result.ResultTemplate",
    )
)
@Composable
fun ResultRemoteTemplate(
    attrs: AttrsResultTemplate,
    primaryButtonAction: () -> Unit,
    secondaryButtonAction: () -> Unit,
) {
    BasicResultTemplate(
        title = attrs.title,
        description = attrs.description,
        image = {
            InternetImage(
                imageUrl = attrs.imageRemote.orEmpty(),
                contentDescription = attrs.imageDescription,
                modifier = Modifier
                    .size(150.dp, 128.dp),
                shimmerShape = M2BTheme.shapes.fullCircleShape,
                imageBackup = attrs.image,
            )
        },
    ) {
        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = attrs.buttonText,
            onClick = primaryButtonAction,
        )

        attrs.outlinedButtonText?.let { buttonText ->
            SpacerS()

            OutlinedButtonFullWidth(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = buttonText,
                onClick = secondaryButtonAction,
            )
        }
    }
}

@Deprecated(
    MORE_VERSATILE_TEMPLATE,
    ReplaceWith(
        "ResultTemplate",
        "com.example.designkit.ui.template.result.ResultTemplate",
    )
)
@Composable
fun ResultRemoteTemplate(
    attrs: AttrsResultTemplate,
    primaryButtonAction: () -> Unit,
) {
    BasicResultTemplate(
        title = attrs.title,
        description = attrs.description,
        image = {
            InternetImage(
                imageUrl = attrs.imageRemote.orEmpty(),
                contentDescription = attrs.imageDescription,
                modifier = Modifier
                    .size(150.dp, 128.dp),
                shimmerShape = M2BTheme.shapes.fullCircleShape,
                imageBackup = attrs.image,
            )
        },
    ) {
        ButtonFullWidth(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = attrs.buttonText,
            onClick = primaryButtonAction,
        )
    }
}

@Stable
data class AttrsResultTemplate(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
    val buttonText: String,
    val outlinedButtonText: String? = null,
    val imageRemote: String? = null,
    val imageDescription: String? = null,
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    val attrs = AttrsResultTemplate(
        image = R.drawable.m2b_img_error,
        title = "El pago no se completó y tampoco se conectó tu cuenta MACH a [Comercio]",
        description = "No se realizaron cobros a tu saldo disponible. Puedes intentarlo nuevamente.",
        buttonText = " Entendido",
        outlinedButtonText = "Ir al Inicio",
    )
    BasicPreview(M2bColorsTheme.M2B) {
        ResultTemplate(
            attrs = attrs,
            primaryButtonAction = {},
            secondaryButtonAction = {},
        )
    }
}
