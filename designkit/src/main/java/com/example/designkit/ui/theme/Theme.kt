package com.example.designkit.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.designkit.commons.rememberSystemUiController


@Composable
fun M2BTheme(
    colorsTheme: M2bColorsTheme = M2bColorsTheme.M2B,
    statusBarColor: Color = Color.White,
    darkIconsStatusBar: Boolean = true,
    navigationBarColor: Color = Color.Transparent,
    darkIconsNavBar: Boolean = true,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    val colors = when (colorsTheme) {
        M2bColorsTheme.M2B -> colorsMaterialM2b()
        M2bColorsTheme.MACH -> colorsMaterialMach()
        M2bColorsTheme.BCI -> colorsMaterialBci()
    }

    val rememberedColors = remember(colorsTheme) {
        when (colorsTheme) {
            M2bColorsTheme.M2B -> m2bColors()
            M2bColorsTheme.MACH -> machColors()
            M2bColorsTheme.BCI -> bciColors()
        }
    }


    DisposableEffect(systemUiController) {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = darkIconsStatusBar
        )
        systemUiController.setNavigationBarColor(
            color = navigationBarColor,
            darkIcons = darkIconsNavBar
        )

        onDispose {}
    }

    CompositionLocalProvider(
        LocalTypography provides TypographyM2B(),
        LocalDimensions provides Dimensions(),
        LocalShapes provides Shapes(),
        LocalMaterialColors provides colors,
        LocalColors provides rememberedColors,
    ) {
        MaterialTheme(
            colorScheme = colors,
            content = content
        )
    }
}

object M2BTheme {
    val typography: TypographyM2B
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimens: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val colorsMaterial: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalMaterialColors.current

    val colors: ColorsM2b
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

enum class M2bColorsTheme {
    M2B, MACH, BCI
}

fun colorsMaterialM2b() = lightColorScheme(
    primary = BlueRibbon,
    background = PureWhite,
    surface = PureWhite,
    onPrimary = PureWhite,
    onBackground = UiGrayGothic,
    onSurface = UiGrayGothic
)

fun colorsMaterialMach() = lightColorScheme(
    primary = VioletMach,
    background = PureWhite,
    surface = PureWhite,
    onPrimary = PureWhite,
    onBackground = UiGrayGothic,
    onSurface = UiGrayGothic
)

fun colorsMaterialBci() = lightColorScheme(
    primary = PrimaryBci,
    background = PureWhite,
    surface = PureWhite,
    onPrimary = PureWhite,
    onBackground = UiGrayGothic,
    onSurface = UiGrayGothic
)


val LocalTypography = staticCompositionLocalOf { TypographyM2B() }
val LocalDimensions = staticCompositionLocalOf { Dimensions() }
val LocalMaterialColors = staticCompositionLocalOf { colorsMaterialM2b() }
