package com.example.designkit.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold

@Composable
fun BasicPill(
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.primary,
    horizontalPadding: Dp = 12.dp,
    verticalPadding: Dp = 4.dp,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .clip(M2BTheme.shapes.extraLarge)
            .background(backgroundColor)
            .defaultMinSize(20.dp),
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
fun PillS(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.primary,
    colorText: Color = colors.surface,
) {
    BasicPill(
        modifier = Modifier
            .then(modifier),
        backgroundColor = backgroundColor,
        horizontalPadding = 4.dp,
        verticalPadding = 0.dp,
    ) {
        Text(
            text = text,
            style = typography.bodyXXS.bold,
            textAlign = TextAlign.Center,
            color = colorText,
        )
    }
}

@Composable
fun PillM(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.primary,
    colorText: Color = colors.surface,
) {
    BasicPill(
        modifier = Modifier
            .then(modifier),
        backgroundColor = backgroundColor,
        horizontalPadding = 8.dp,
        verticalPadding = 4.dp,
    ) {
        Text(
            text = text,
            style = typography.bodyXXS.bold,
            textAlign = TextAlign.Center,
            color = colorText,
        )
    }
}

@Composable
fun PillL(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.primary,
    colorText: Color = colors.surface,

    ) {
    BasicPill(
        modifier = modifier,
        backgroundColor = backgroundColor,
        horizontalPadding = 10.dp,
        verticalPadding = 4.dp,
    ) {
        Text(
            text = text,
            style = typography.bodyXS.bold,
            textAlign = TextAlign.Center,
            color = colorText,
        )
    }
}

@Composable
fun PillXl(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.primary,
    colorText: Color = colors.surface,
) {
    BasicPill(
        modifier = Modifier
            .then(modifier),
        backgroundColor = backgroundColor,
        horizontalPadding = 12.dp,
        verticalPadding = 4.dp,
    ) {
        Text(
            text = text,
            style = typography.bodyS.bold,
            textAlign = TextAlign.Center,
            color = colorText,
        )
    }
}

@Composable
@Deprecated("Use ExtendedPill", replaceWith = ReplaceWith("ExtendedPillL"))
fun PillExtended(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colors.contentDarker,
    colorText: Color = colors.surface,

    ) {
    BasicPill(
        modifier = Modifier
            .then(modifier),
        backgroundColor = backgroundColor,
        horizontalPadding = 8.dp,
        verticalPadding = 4.dp,
    ) {
        Text(
            text = text,
            style = typography.bodyXS.bold,
            textAlign = TextAlign.Center,
            color = colorText,
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.0f,
)
@Composable
fun PreviewPill() {
    M2BTheme(M2bColorsTheme.M2B) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val text = "{00/LABEL}"
            SpacerXL()
            PillS(text)
            PillM(text)
            PillL(text)
            PillXl(text)
            PillExtended(text)
        }
    }
}
