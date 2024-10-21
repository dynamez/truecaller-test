package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.SpacerML
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.atom.SpacerXXS
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.organism.card.Card

@Composable
fun ReceiptHeaderCard(
    title: String,
    amount: String,
    imageUrl: String,
    @DrawableRes imageBackup: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .then(modifier),
        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
        elevation = 1.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SpacerML()

            InternetImage(
                modifier = Modifier
                    .size(64.dp.scaled),
                imageUrl = imageUrl,
                imageBackup = imageBackup,
                shimmerShape = RoundedCornerShape(64.dp),
            )

            SpacerSM()

            Text(
                text = title,
                style = M2BTheme.typography.subtitleM.bold,
            )

            SpacerXXS()

            Text(
                text = amount,
                style = M2BTheme.typography.subtitleL.bold,
                color = M2BTheme.colors.primary
            )

            SpacerML()
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ReceiptHeaderCard(
        title = "Title",
        amount = "Amount",
        imageUrl = "",
        imageBackup = 0,
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewFullScreen() {
    BasicPreview(M2bColorsTheme.MACH) {
        ReceiptHeaderCard(
            title = "Title",
            amount = "Amount",
            imageUrl = "",
            imageBackup = 0,
        )
    }
}