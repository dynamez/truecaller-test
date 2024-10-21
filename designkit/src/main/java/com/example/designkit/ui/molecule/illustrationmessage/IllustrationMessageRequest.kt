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
fun IllustrationMessageRequest(
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
            modifier = Modifier.size(256.dp)
        )
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 522)
@Composable
private fun Preview() {
    IllustrationMessageRequest(
        image = R.drawable.m2b_illustration_request_04_qr,
        title = "Paga rápido y fácil en el transporte público con bip!QR",
        description = "Con tu app MACH podrás generar un código bip!QR para pagar tu pasaje en buses, metro y metrotren en la región Metropolitana." +
                "\n\nRecarga con tu saldo MACH, sin filas ni activaciones en los tótem."
    )
}