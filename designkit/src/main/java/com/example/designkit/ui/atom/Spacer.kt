package com.example.designkit.ui.atom

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.LocalFloat.fillRemainingSpace


@Composable
fun SpacerXXS() {
    Spacer(modifier = Modifier.size(4.dp))
}

/**
 * Spacer of 8.dp
 */
@Composable
fun SpacerXS() {
    Spacer(modifier = Modifier.size(8.dp))
}

/**
 * Spacer of 12.dp
 */
@Composable
fun SpacerS() {
    Spacer(modifier = Modifier.size(12.dp))
}

/**
 * Spacer of 16.dp
 */
@Composable
fun SpacerSM() {
    Spacer(modifier = Modifier.size(16.dp))
}

/**
 * Spacer of 16.dp
 */
@Composable
fun SpacerM() {
    Spacer(modifier = Modifier.size(20.dp))
}

/**
 * Spacer of 24.dp
 */
@Composable
fun SpacerML() {
    Spacer(modifier = Modifier.size(24.dp))
}

@Composable
fun SpacerL() {
    Spacer(modifier = Modifier.size(28.dp))
}

/**
 * Spacer of 32.dp
 */
@Composable
fun SpacerXL() {
    Spacer(modifier = Modifier.size(32.dp))
}

@Composable
fun SpacerXXL() {
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun SpacerXXXL() {
    Spacer(modifier = Modifier.size(40.dp))
}

@Composable
fun SpacerXXXXL() {
    Spacer(modifier = Modifier.size(48.dp))
}

@Composable
fun ColumnScope.SpacerFillSpace(){
    Spacer(modifier = Modifier.weight(fillRemainingSpace))
}

@Composable
fun RowScope.SpacerFillSpace(){
    Spacer(modifier = Modifier.weight(fillRemainingSpace))
}
