package com.example.designkit.ui.molecule.box

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.molecule.button.Button
import com.example.designkit.ui.molecule.button.ButtonFullWidth
import com.example.designkit.ui.theme.M2BTheme.colors

@Composable
internal fun BasicButtonBox(
    modifier: Modifier = Modifier,
    withElevation: Boolean = false,
    content: @Composable (PaddingValues) -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shadowElevation = if (withElevation) 8.dp else 0.dp,
        color = colors.surface,
    ) {
        content(PaddingValues(horizontal = 20.dp, vertical = 12.dp))
    }

}


@Composable
fun ButtonBox(
    modifier: Modifier = Modifier,
    withElevation: Boolean = false,
    spacedBy: Dp = 12.dp,
    buttons: @Composable ColumnScope.() -> Unit,
) {
    BasicButtonBox(modifier = modifier, withElevation = withElevation) { padding ->
        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(spacedBy),
        ) {
            buttons()
        }
    }
}


@Composable
fun ButtonBoxRow(
    modifier: Modifier = Modifier,
    withElevation: Boolean = false,
    spacedBy: Dp = 16.dp,
    buttons: @Composable RowScope.() -> Unit,
) {
    BasicButtonBox(modifier = modifier, withElevation = withElevation) { padding ->
        Row(
            modifier = Modifier.padding(padding),
            horizontalArrangement = Arrangement.spacedBy(spacedBy),
        ) {
            buttons()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonBoxPreview() {
    ButtonBox(withElevation = true) {
        ButtonFullWidth(
            text = "Primary",
            onClick = {},
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun RowPreview() {
    ButtonBoxRow {
        Button(
            text = "Primary",
            onClick = {},
            modifier = Modifier.weight(1f),
        )
        Button(
            text = "Secondary",
            onClick = {},
            modifier = Modifier.weight(1f),
        )
    }
}