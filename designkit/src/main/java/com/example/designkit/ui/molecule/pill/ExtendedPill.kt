package com.example.designkit.ui.molecule.pill

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.R.drawable.m2b_ic_mp_circle
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.contentColorFor


@Composable
fun BasicExtendedPill(
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.primary,
    horizontalPadding: Dp = 12.dp,
    verticalPadding: Dp = 0.dp,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .clip(M2BTheme.shapes.extraLarge)
            .background(backgroundColor)
            .defaultMinSize(24.dp),
    ) {
        Row(
            modifier = Modifier.padding(horizontalPadding, verticalPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            content = content,
        )
    }
}

@Composable
fun ExtendedPillS(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    backgroundColor: Color = colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    BasicExtendedPill(
        modifier = modifier,
        backgroundColor = backgroundColor,
        horizontalPadding = 8.dp,
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(20.dp).padding(end = 4.dp),
                painter = painterResource(id = it),
                contentDescription = null,
                tint = contentColor,
            )
        }
        Text(
            text = text,
            style = typography.bodyXS.bold,
            color = contentColor,
        )
    }
}

@Composable
fun ExtendedPillM(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    backgroundColor: Color = colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    BasicExtendedPill(
        modifier = modifier.defaultMinSize(24.dp),
        backgroundColor = backgroundColor,
        horizontalPadding = 12.dp,
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(20.dp).padding(end = 4.dp),
                painter = painterResource(id = it),
                contentDescription = null,
                tint = contentColor,
            )
        }
        Text(
            text = text,
            style = typography.bodyS.bold,
            color = contentColor,
        )
    }
}

@Composable
fun ExtendedPillL(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    backgroundColor: Color = colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    BasicExtendedPill(
        modifier = modifier.defaultMinSize(28.dp),
        backgroundColor = backgroundColor,
        horizontalPadding = 16.dp,
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(20.dp).padding(end = 4.dp),
                painter = painterResource(id = it),
                contentDescription = null,
                tint = contentColor,
            )
        }
        Text(
            text = text,
            style = typography.bodyS.bold,
            color = contentColor,
        )
    }
}

@Preview(
    showBackground = true,
    fontScale = 1.0f,
)
@Composable
private fun Preview() {
    M2BTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val text = "{00/LABEL}"
            val icon = m2b_ic_mp_circle

            ExtendedPillS(
                text = text,
                icon = icon
            )
            ExtendedPillS(
                text = text,
            )

            ExtendedPillM(
                text = text,
                icon = icon
            )
            ExtendedPillM(
                text = text,
            )

            ExtendedPillL(
                text = text,
                icon = icon
            )
            ExtendedPillL(
                text = text,
            )
        }
    }
}
