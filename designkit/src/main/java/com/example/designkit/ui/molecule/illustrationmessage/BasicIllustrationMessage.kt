package com.example.designkit.ui.molecule.illustrationmessage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.ext.toBoldMarkDown
import com.example.designkit.ui.atom.SpacerML
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold


@Composable
internal fun BasicIllustrationMessage(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    image: @Composable () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
    ) {
        SpacerSM()

        image()

        SpacerML()

        Text(
            text = title,
            style = typography.subtitleM.bold,
            textAlign = TextAlign.Center,
        )

        if (!description.isNullOrEmpty()) {
            SpacerML()

            Text(
                text = description.toBoldMarkDown(),
                style = typography.bodyM,
                textAlign = TextAlign.Center,
            )
        }

        SpacerSM()
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    BasicIllustrationMessage(
        title = "Basic title",
        description = "Basic description",
    ) {
        Image(
            painter = painterResource(R.drawable.m2b_img_error),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
    }
}
