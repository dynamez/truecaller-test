package com.example.designkit.ui.molecule.navigationbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.theme.M2BTheme

@Composable
fun ScaffoldWithTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    leftAction: (() -> Unit)? = null,
    @DrawableRes leftIcon: Int? = null,
    leftActionDescription: String? = null,
    rightAction: (() -> Unit)? = null,
    @DrawableRes rightIcon: Int? = null,
    rightText: String? = null,
    rightActionDescription: String? = null,
    backgroundTopBarColor: Color = M2BTheme.colors.surface,
    contentTopBarColor: Color = MaterialTheme.colorScheme.primary,
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                title = title,
                leftIcon = leftIcon,
                leftAction = leftAction,
                leftActionDescription = leftActionDescription,
                rightIcon = rightIcon,
                rightAction = rightAction,
                rightText = rightText,
                rightActionDescription = rightActionDescription,
            )
        },
        containerColor = backgroundTopBarColor,
        contentColor = contentTopBarColor,
        snackbarHost = snackbarHost,
    ) {
        content(it)
    }
}

@Composable
fun ScaffoldBackIcon(
    modifier: Modifier = Modifier,
    title: String? = null,
    leftAction: (() -> Unit)? = null,
    @DrawableRes leftIcon: Int = R.drawable.m2b_icon_back_arrow,
    leftActionDescription: String? = null,
    snackbarHost: @Composable () -> Unit = {},
    backgroundTopBarColor: Color = M2BTheme.colors.surface,
    contentTopBarColor: Color = MaterialTheme.colorScheme.primary,
    content: @Composable (PaddingValues) -> Unit,
) {
    val backDescription = leftActionDescription ?: "Back"
    ScaffoldWithTopBar(
        modifier = modifier,
        title = title,
        leftActionDescription = backDescription,
        leftIcon = leftIcon,
        leftAction = leftAction,
        backgroundTopBarColor = backgroundTopBarColor,
        contentTopBarColor = contentTopBarColor,
        snackbarHost = snackbarHost,
        content = { content(it) },
    )
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        ScaffoldWithTopBar(
            title = "Top App Bar",
            leftIcon = R.drawable.m2b_icon_back_arrow,
            leftAction = {},
            rightIcon = R.drawable.m2b_ic_icon_close,
            rightAction = {}
        ) {

        }
    }
}