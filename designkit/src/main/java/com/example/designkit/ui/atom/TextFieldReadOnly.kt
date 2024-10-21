package com.example.designkit.ui.atom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.regular


@Composable
fun TextFieldReadOnly(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = typography.bodyS.regular,
            color = M2BTheme.colors.contentDark,
            modifier = Modifier.padding(start = 8.dp, bottom = 1.dp)
        )
        Text(
            text = value,
            style = typography.bodyM.regular,
            modifier = Modifier.padding(start = 10.dp, bottom = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReadOnlyPreview() {
    TextFieldReadOnly(
        label = "Nombre",
        value = "Alexis",
        modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 20.dp, end = 20.dp)
    )
}