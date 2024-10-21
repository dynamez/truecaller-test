package com.example.designkit.ui.organism.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.organism.card.Card

@Composable
fun SectionCard(
    modifier: Modifier = Modifier,
    surfaceColor: Color = M2BTheme.colors.primaryLighter,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(color = surfaceColor) {
        Card(
            modifier = modifier.then(Modifier.fillMaxWidth()),
            shape = M2BTheme.shapes.smallMedium,
            elevation = 0.dp,
        ) { Column(modifier = Modifier.fillMaxWidth(), content = content) }
    }
}