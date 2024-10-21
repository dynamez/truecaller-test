package com.example.designkit.ui.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.designkit.R
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.dimens

@Composable
fun M2BIconAction(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    IconButton(
        onClick = onClick,
        content = content,
    )
}

@Composable
fun M2BBackIconAction(onClick: () -> Unit) = M2BIconAction(onClick, content = {
    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = ImageVector.vectorResource(id = R.drawable.m2b_icon_back_arrow),
        contentDescription = "Back",
    )
})

@Composable
fun M2BCloseIconAction(onClick: () -> Unit) = M2BIconAction(onClick, content = {
    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = ImageVector.vectorResource(id = R.drawable.m2b_ic_icon_close),
        contentDescription = "Close",
    )
})

@Composable
fun IconButtonAction(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        ) {
        Icon(
            modifier = Modifier.size(dimens.iconSize),
            imageVector = ImageVector.vectorResource(icon),
            tint = M2BTheme.colors.primary,
            contentDescription = contentDescription,
        )
    }
}

@Composable
fun BackIconAction(onClick: () -> Unit) {
    IconButtonAction(
        modifier = Modifier,
        icon = R.drawable.m2b_icon_back_arrow,
        contentDescription = "Volver",
        onClick = onClick,
    )
}

@Composable
fun CloseIconAction(onClick: () -> Unit) {
    IconButtonAction(
        icon = R.drawable.m2b_ic_icon_close,
        contentDescription = "Cerrar",
        onClick = onClick,
    )
}

@Composable
fun SupportIconAction(onClick: () -> Unit) {
    IconButtonAction(
        icon = R.drawable.m2b_ic_icon_support,
        contentDescription = "Ayuda",
        onClick = onClick,

    )
}

