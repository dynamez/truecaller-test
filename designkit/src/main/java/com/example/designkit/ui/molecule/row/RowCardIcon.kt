package com.example.designkit.ui.molecule.row

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ext.toIconDk
import com.example.designkit.ui.atom.SimpleCircle
import com.example.designkit.ui.atom.SpacerS
import com.example.designkit.ui.atom.SpacerXL
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold

@Composable
fun RowCardIcon(
    title: String?,
    description: String,
    icon : String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {
                contentDescription = "${title.orEmpty()} $description"
            }
            .then(modifier),
    ) {
        SimpleCircle(
            modifier = Modifier.align(Alignment.Top),
            size = 40.dp,
            backgroundColor = colors.primary
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = icon.toIconDk(R.drawable.m2b_ic_gift)),
                contentDescription = null,
                tint = colors.surface,
            )
        }

        SpacerS()

        Column(
            modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
        ) {
            title?.let {
                Text(
                    text = title,
                    style = typography.bodyM.bold,
                    color = colors.primary,
                )
            }
            Text(
                text = description,
                style = typography.bodyS,
            )

        }
    }
}

@Stable
data class AttrsRowCardIcon(
    val title: String?,
    val description: String,
    val icon: String,
)

@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.0f,
)
@Composable
private fun Preview() {
    val attrs = AttrsRowCardIcon(
        title = "{text title}",
        description = "Description",
        icon = "icon-ticket"
    )

    val attrsNoTitle = AttrsRowCardIcon(
        title = null,
        description = "20% de cashback en la venta de abonos",
        icon = "icon-iva"
    )
    BasicPreview {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(36.dp)
        ) {
            RowCardIcon(
                title = attrs.title,
                description = attrs.description,
                icon = attrs.icon,
            )

            SpacerXL()

            RowCardIcon(
                title = attrsNoTitle.title,
                description = attrsNoTitle.description,
                icon = attrsNoTitle.icon,
            )
        }
    }
}
