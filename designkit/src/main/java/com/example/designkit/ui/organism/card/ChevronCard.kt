package com.example.designkit.ui.organism.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.PillS
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.atom.SpacerXXS
import com.example.designkit.ui.theme.LocalFloat
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.theme.semiBold
import com.example.designkit.ui.organism.card.Card

@Composable
fun ChevronCard(
    @DrawableRes localImage: Int,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    title: String? = null,
    description: String? = null,
    pillText: String? = null,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) { }
            .then(modifier),
        border = BorderStroke(1.dp, colors.contentLighter),
        elevation = 0.dp,
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SpacerSM()

            if(imageUrl != null) {
                InternetImage(
                    modifier = Modifier.size(24.dp.scaled),
                    imageUrl = imageUrl,
                    imageBackup = localImage,
                )
            } else {
                Icon(
                    modifier = Modifier.size(24.dp.scaled),
                    painter = painterResource(localImage),
                    contentDescription = null,
                    tint = colors.primary,
                )
            }

            SpacerSM()

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    title?.let {
                        Text(text = it, style = typography.bodyM.semiBold)
                    }

                    pillText?.let {
                        SpacerXXS()

                        PillS(
                            text = it,
                            backgroundColor = colors.success,
                            colorText = colors.contentDarker,
                        )
                    }
                }

                description?.let {
                    Text(text = it, style = typography.bodyS)
                }
            }

            Spacer(modifier = Modifier.weight(LocalFloat.float_1))

            Icon(
                modifier = Modifier.size(24.dp.scaled),
                painter = painterResource(R.drawable.m2b_ic_arrow_right),
                contentDescription = null,
                tint = colors.primary,
            )

            SpacerSM()
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ChevronCard(
        localImage = R.drawable.m2b_ic_mp_circle,
        title = "Title",
        description = "Description",
        pillText = "Pill",
        onClick = {}
    )
}