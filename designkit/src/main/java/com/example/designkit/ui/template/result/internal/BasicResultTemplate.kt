package com.example.designkit.ui.template.result.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.ui.atom.SpacerFillSpace
import com.example.designkit.ui.molecule.box.ButtonBox
import com.example.designkit.ui.molecule.button.ButtonFullWidth
import com.example.designkit.ui.molecule.illustrationmessage.IllustrationMessageResult
import com.example.designkit.ui.molecule.navigationbar.ScaffoldBackIcon

@Composable
internal fun BasicResultTemplate(
    illustrationMessage: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
    scrollable: Boolean = true,
    bottomContent: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState(), enabled = scrollable),
        ) {
            SpacerFillSpace()

            illustrationMessage()

            SpacerFillSpace()
        }

        bottomContent()
    }
}


@Preview(showBackground = true)
@Composable
private fun BasicResultPreview() {
    ScaffoldBackIcon { padding ->
        BasicResultTemplate(
            modifier = Modifier.padding(padding),
            illustrationMessage = {
                IllustrationMessageResult(
                    title = "Basic title",
                    image = R.drawable.m2b_img_error,
                )
            },
        ) {
            ButtonBox {
                ButtonFullWidth("Button") { }
            }
        }
    }
}
