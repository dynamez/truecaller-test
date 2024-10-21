package com.example.designkit.ui.organism.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.m2bBackground

@Composable
inline fun M2BButtonBoxFullWidth(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.m2bBackground)
            .padding(horizontal = 20.dp, vertical = 12.dp),
    ) {
        content()
    }
}
