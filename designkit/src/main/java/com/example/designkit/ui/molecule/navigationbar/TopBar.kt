package com.example.designkit.ui.molecule.navigationbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.designkit.R
import com.example.designkit.commons.BasicPreview
import com.example.designkit.ui.atom.IconButtonAction
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.atom.TextAction
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    colors: TopAppBarColors,
) {
    CenterAlignedTopAppBar(
        title = title,
        navigationIcon = navigationIcon,
        actions = actions,
        colors = colors,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String? = null,
    @DrawableRes leftIcon: Int? = null,
    leftAction: (() -> Unit)? = null,
    leftActionDescription: String? = null,
    @DrawableRes rightIcon: Int? = null,
    rightAction: (() -> Unit)? = null,
    rightText: String? = null,
    rightActionDescription: String? = null,
) {
    BasicTopBar(
        title = {
            title?.let { Text(text = it, style = M2BTheme.typography.subtitleM.bold) } ?: Unit
        },
        navigationIcon = {
            leftIcon?.let { leftIcon ->
                leftActionDescription?.let {
                    IconButtonAction(
                        icon = leftIcon,
                        onClick = leftAction ?: {},
                        contentDescription = leftActionDescription,
                    )
                } ?: Unit
                }
        },
        actions = {
            rightAction?.let { rightAction ->
                rightIcon?.let { rightIcon ->
                    rightActionDescription?.let { rightActionDescription ->
                        IconButtonAction(
                            icon = rightIcon,
                            onClick = rightAction,
                            contentDescription = rightActionDescription,
                        )
                    }
                } ?: rightText?.let { rightText ->
                    TextAction(
                        text = rightText,
                        onClick = rightAction,
                        style = M2BTheme.typography.bodyXXS,
                    )
                } ?: Unit
            }
        },
        colors = topAppBarColors(
            containerColor = M2BTheme.colors.background,
            navigationIconContentColor = M2BTheme.colors.content,
            titleContentColor = M2BTheme.colors.content,
            actionIconContentColor = M2BTheme.colors.content,
        )
    )
}

@Preview
@Composable
private fun Preview() {
    BasicPreview {
        TopBar(
            title = "Title",
            leftIcon = R.drawable.m2b_icon_back_arrow,
            leftAction = {},
            rightIcon = R.drawable.m2b_ic_icon_close,
            rightAction = {},
        )
    }
}