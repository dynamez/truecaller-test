package com.example.designkit.ui.molecule.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ext.disabled
import com.example.designkit.ui.atom.InternetImage
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.molecule.button.ButtonContextualSmall
import com.example.designkit.ui.molecule.row.RowItemPartnerDefaults.CONNECTION
import com.example.designkit.ui.molecule.row.RowItemPartnerDefaults.DELETE
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.dimens
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled


@Composable
fun RowItemPartner(
    attrs: AttrsRowItemPartner,
    modifier: Modifier = Modifier,
    onClickedAction: (AttrsRowItemPartner) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(vertical = dimens.dimen16, horizontal = dimens.dimen20)
            .semantics(mergeDescendants = true) {}
            .fillMaxWidth()
            .then(modifier),
    ) {
        InternetImage(
            imageUrl = attrs.logo,
            imageBackup = R.drawable.m2b_ic_row_item_partmer_error,
            modifier = Modifier
                .clip(M2BTheme.shapes.smallMedium)
                .size(dimens.dimen48.scaled)
                .align(Alignment.CenterVertically),
            shimmerShape = M2BTheme.shapes.smallMedium,
            colorFilter = RowItemPartnerDefaults.colorFilter(attrs.isEnabled),
        )

        Spacer(Modifier.size(dimens.dimen16))

        Column(Modifier.weight(.5f)) {
            Text(text = attrs.title, style = typography.bodyM.bold)
            Text(text = attrs.description, style = typography.bodyS)
        }

        ButtonContextualSmall(
            text = attrs.textActionText,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(.25f),
            enabled = attrs.isEnabled,
            onClick = { onClickedAction.invoke(attrs) }
        )
    }
}

data class AttrsRowItemPartner(
    val id: String,
    val logo: String,
    val title: String,
    val description: String,
    val isEnabled: Boolean = true,
    val type: String = CONNECTION,
    val textActionText: String = DELETE,
)

private object RowItemPartnerDefaults {
    const val DELETE = "Eliminar"
    const val CONNECTION = "CONNECTION"
    fun colorFilter(isEnabled: Boolean = true) = if (isEnabled) null else ColorFilter.disabled()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.0f,
)
@Composable
private fun Preview(modifier: Modifier = Modifier) {

    BasicPreview(M2bColorsTheme.M2B) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(dimens.dimen20),
            verticalArrangement = Arrangement.spacedBy(dimens.dimen20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) { RowItemPartner(attrs, onClickedAction = {}) }
    }
}

private val attrs = AttrsRowItemPartner(
    logo = "https://shorturl.at/cgjEN",
    title = "Bipay",
    description = "Activa desde 08/11/2023",
    textActionText = "Eliminar",
    id = "123",
)