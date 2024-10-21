package com.example.truecallertest.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.truecallertest.presentation.model.Status

@Composable
fun TaskSection(
    title: String,
    status: Status,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val sectionModifier = Modifier
        .fillMaxWidth()
        .animateContentSize()
        .let { if (enabled) it.clickable { expanded = !expanded } else it }

    val alpha = if (enabled) 1f else 0.4f // Adjust alpha as needed
    val contentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
    val surfaceColor = MaterialTheme.colorScheme.surface

    Surface(
        tonalElevation = 2.dp,
        shadowElevation = 2.dp,
        modifier = sectionModifier,
        color = surfaceColor
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { if (enabled) expanded = !expanded },
                        enabled = enabled
                    ) {
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = if (expanded) "Collapse" else "Expand"
                        )
                    }
                }

                when (status) {
                    Status.Loading -> Text("Loading...")
                    Status.Success -> {
                        AnimatedVisibility(visible = expanded) {
                            content()
                        }
                    }

                    Status.Error -> Text("Error loading data.")
                    else -> Unit
                }
            }
        }
    }
}