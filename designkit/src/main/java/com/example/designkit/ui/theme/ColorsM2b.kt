package com.example.designkit.ui.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

/**
 * To create a m2b set of colors use [m2bColors]
 * To create a mach set of colors use [machColors]
 *
 */
@Stable
class ColorsM2b(
    primary: Color,
    primaryDark: Color,
    primaryLight: Color,
    primaryLighter: Color,
    content: Color,
    contentDark: Color,
    contentDarker: Color,
    contentLight: Color,
    contentLighter: Color,
    success: Color,
    successDark: Color,
    successDarker: Color,
    successLight: Color,
    successLighter: Color,
    critique: Color,
    critiqueDark: Color,
    critiqueDarker: Color,
    critiqueLight: Color,
    critiqueLighter: Color,
    warning: Color,
    warningDark: Color,
    warningDarker: Color,
    warningLight: Color,
    warningLighter: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isLight: Boolean,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var primaryDark by mutableStateOf(primaryDark, structuralEqualityPolicy())
        internal set
    var primaryLight by mutableStateOf(primaryLight, structuralEqualityPolicy())
        internal set
    var primaryLighter by mutableStateOf(primaryLighter, structuralEqualityPolicy())
        internal set
    var content by mutableStateOf(content, structuralEqualityPolicy())
        internal set
    var contentDarker by mutableStateOf(contentDarker, structuralEqualityPolicy())
        internal set
    var contentDark by mutableStateOf(contentDark, structuralEqualityPolicy())
        internal set
    var contentLight by mutableStateOf(contentLight, structuralEqualityPolicy())
        internal set
    var contentLighter by mutableStateOf(contentLighter, structuralEqualityPolicy())
        internal set
    var success by mutableStateOf(success, structuralEqualityPolicy())
        internal set
    var successDarker by mutableStateOf(successDarker, structuralEqualityPolicy())
        internal set
    var successDark by mutableStateOf(successDark, structuralEqualityPolicy())
        internal set
    var successLight by mutableStateOf(successLight, structuralEqualityPolicy())
        internal set
    var successLighter by mutableStateOf(successLighter, structuralEqualityPolicy())
        internal set
    var critique by mutableStateOf(critique, structuralEqualityPolicy())
        internal set
    var critiqueDarker by mutableStateOf(critiqueDarker, structuralEqualityPolicy())
        internal set
    var critiqueDark by mutableStateOf(critiqueDark, structuralEqualityPolicy())
        internal set
    var critiqueLight by mutableStateOf(critiqueLight, structuralEqualityPolicy())
        internal set
    var critiqueLighter by mutableStateOf(critiqueLighter, structuralEqualityPolicy())
        internal set
    var warning by mutableStateOf(warning, structuralEqualityPolicy())
        internal set
    var warningDarker by mutableStateOf(warningDarker, structuralEqualityPolicy())
        internal set
    var warningDark by mutableStateOf(warningDark, structuralEqualityPolicy())
        internal set
    var warningLight by mutableStateOf(warningLight, structuralEqualityPolicy())
        internal set
    var warningLighter by mutableStateOf(warningLighter, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set
    var onBackground by mutableStateOf(onBackground, structuralEqualityPolicy())
        internal set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    var onError by mutableStateOf(onError, structuralEqualityPolicy())
        internal set
    var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
        internal set

    /**
     * Returns a copy of this Colors, optionally overriding some of the values.
     */
    fun copy(
        primary: Color = this.primary,
        primaryDark: Color = this.primaryDark,
        primaryLight: Color = this.primaryLight,
        primaryLighter: Color = this.primaryLighter,
        content: Color = this.content,
        contentDark: Color = this.contentDark,
        contentDarker: Color = this.contentDarker,
        contentLight: Color = this.contentLight,
        contentLighter: Color = this.contentLighter,
        success: Color = this.success,
        successDark: Color = this.successDark,
        successDarker: Color = this.successDarker,
        successLight: Color = this.successLight,
        successLighter: Color = this.successLighter,
        critique: Color = this.critique,
        critiqueDark: Color = this.critiqueDark,
        critiqueDarker: Color = this.critiqueDarker,
        critiqueLight: Color = this.critiqueLight,
        critiqueLighter: Color = this.critiqueLighter,
        warning: Color = this.warning,
        warningDark: Color = this.warningDark,
        warningDarker: Color = this.warningDarker,
        warningLight: Color = this.warningLight,
        warningLighter: Color = this.warningLighter,
        background: Color = this.background,
        surface: Color = this.surface,
        error: Color = this.error,
        onPrimary: Color = this.onPrimary,
        onBackground: Color = this.onBackground,
        onSurface: Color = this.onSurface,
        onError: Color = this.onError,
        isLight: Boolean = this.isLight
    ): ColorsM2b = ColorsM2b(
        primary,
        primaryDark,
        primaryLight,
        primaryLighter,
        content,
        contentDark,
        contentDarker,
        contentLight,
        contentLighter,
        success,
        successDark,
        successDarker,
        successLight,
        successLighter,
        critique,
        critiqueDark,
        critiqueDarker,
        critiqueLight,
        critiqueLighter,
        warning,
        warningDark,
        warningDarker,
        warningLight,
        warningLighter,
        background,
        surface,
        error,
        onPrimary,
        onBackground,
        onSurface,
        onError,
        isLight,
    )
}

fun m2bColors(
    primary: Color = PrimaryM2b,
    primaryDark: Color = PrimaryDarkM2b,
    primaryLight: Color = PrimaryLightM2b,
    primaryLighter: Color = PrimaryLighterM2b,
    content: Color = ContentM2b,
    contentDark: Color = ContentDarkM2b,
    contentDarker: Color = ContentDarkerM2b,
    contentLight: Color = ContentLightM2b,
    contentLighter: Color = ContentLighterM2b,
    success: Color = SuccessM2b,
    successDark: Color = SuccessDarkM2b,
    successDarker: Color = SuccessDarkerM2b,
    successLight: Color = SuccessLightM2b,
    successLighter: Color = SuccessLighterM2b,
    critique: Color = CritiqueM2b,
    critiqueDark: Color = CritiqueDarkM2b,
    critiqueDarker: Color = CritiqueDarkerM2b,
    critiqueLight: Color = CritiqueLightM2b,
    critiqueLighter: Color = CritiqueLighterM2b,
    warning: Color = WarningM2b,
    warningDark: Color = WarningDarkM2b,
    warningDarker: Color = WarningDarkerM2b,
    warningLight: Color = WarningLightM2b,
    warningLighter: Color = WarningLighterM2b,
    background: Color = Color.White,
    surface: Color = Color.White,
    error: Color = critiqueDarker,
    onPrimary: Color = Color.White,
    onBackground: Color = contentDarker,
    onSurface: Color = contentDarker,
    onError: Color = Color.White,
    isLight: Boolean = true,
): ColorsM2b = ColorsM2b(
    primary,
    primaryDark,
    primaryLight,
    primaryLighter,
    content,
    contentDark,
    contentDarker,
    contentLight,
    contentLighter,
    success,
    successDark,
    successDarker,
    successLight,
    successLighter,
    critique,
    critiqueDark,
    critiqueDarker,
    critiqueLight,
    critiqueLighter,
    warning,
    warningDark,
    warningDarker,
    warningLight,
    warningLighter,
    background,
    surface,
    error,
    onPrimary,
    onBackground,
    onSurface,
    onError,
    isLight,
)

fun machColors(
    primary: Color = PrimaryMach,
    primaryDark: Color = PrimaryDarkMach,
    primaryLight: Color = PrimaryLightMach,
    primaryLighter: Color = PrimaryLighterMach,
    content: Color = ContentM2b,
    contentDark: Color = ContentDarkM2b,
    contentDarker: Color = ContentDarkerM2b,
    contentLight: Color = ContentLightM2b,
    contentLighter: Color = ContentLighterM2b,
    success: Color = SuccessM2b,
    successDark: Color = SuccessDarkM2b,
    successDarker: Color = SuccessDarkerM2b,
    successLight: Color = SuccessLightM2b,
    successLighter: Color = SuccessLighterM2b,
    critique: Color = CritiqueM2b,
    critiqueDark: Color = CritiqueDarkM2b,
    critiqueDarker: Color = CritiqueDarkerM2b,
    critiqueLight: Color = CritiqueLightM2b,
    critiqueLighter: Color = CritiqueLighterM2b,
    warning: Color = WarningM2b,
    warningDark: Color = WarningDarkM2b,
    warningDarker: Color = WarningDarkerM2b,
    warningLight: Color = WarningLightM2b,
    warningLighter: Color = WarningLighterM2b,
    background: Color = Color.White,
    surface: Color = Color.White,
    error: Color = critiqueDarker,
    onPrimary: Color = Color.White,
    onBackground: Color = contentDarker,
    onSurface: Color = contentDarker,
    onError: Color = Color.White,
    isLight: Boolean = true,
): ColorsM2b = ColorsM2b(
    primary,
    primaryDark,
    primaryLight,
    primaryLighter,
    content,
    contentDark,
    contentDarker,
    contentLight,
    contentLighter,
    success,
    successDark,
    successDarker,
    successLight,
    successLighter,
    critique,
    critiqueDark,
    critiqueDarker,
    critiqueLight,
    critiqueLighter,
    warning,
    warningDark,
    warningDarker,
    warningLight,
    warningLighter,
    background,
    surface,
    error,
    onPrimary,
    onBackground,
    onSurface,
    onError,
    isLight,
)

fun bciColors(
    primary: Color = PrimaryBci,
    primaryDark: Color = PrimaryDarkBci,
    primaryLight: Color = PrimaryLightBci,
    primaryLighter: Color = PrimaryLighterBci,
    content: Color = ContentM2b,
    contentDark: Color = ContentDarkM2b,
    contentDarker: Color = ContentDarkerM2b,
    contentLight: Color = ContentLightM2b,
    contentLighter: Color = ContentLighterM2b,
    success: Color = SuccessM2b,
    successDark: Color = SuccessDarkM2b,
    successDarker: Color = SuccessDarkerM2b,
    successLight: Color = SuccessLightM2b,
    successLighter: Color = SuccessLighterM2b,
    critique: Color = CritiqueM2b,
    critiqueDark: Color = CritiqueDarkM2b,
    critiqueDarker: Color = CritiqueDarkerM2b,
    critiqueLight: Color = CritiqueLightM2b,
    critiqueLighter: Color = CritiqueLighterM2b,
    warning: Color = WarningM2b,
    warningDark: Color = WarningDarkM2b,
    warningDarker: Color = WarningDarkerM2b,
    warningLight: Color = WarningLightM2b,
    warningLighter: Color = WarningLighterM2b,
    background: Color = Color.White,
    surface: Color = Color.White,
    error: Color = critiqueDarker,
    onPrimary: Color = Color.White,
    onBackground: Color = contentDarker,
    onSurface: Color = contentDarker,
    onError: Color = Color.White,
    isLight: Boolean = true,
): ColorsM2b = ColorsM2b(
    primary,
    primaryDark,
    primaryLight,
    primaryLighter,
    content,
    contentDark,
    contentDarker,
    contentLight,
    contentLighter,
    success,
    successDark,
    successDarker,
    successLight,
    successLighter,
    critique,
    critiqueDark,
    critiqueDarker,
    critiqueLight,
    critiqueLighter,
    warning,
    warningDark,
    warningDarker,
    warningLight,
    warningLighter,
    background,
    surface,
    error,
    onPrimary,
    onBackground,
    onSurface,
    onError,
    isLight,
)

fun ColorsM2b.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        primary -> onPrimary
        background -> onBackground
        surface -> onSurface
        error -> onError
        else -> Color.Unspecified
    }
}

/**
 * The Material, and M2b color system contains pairs of colors that are typically used for the
 * background and content color inside a component. For example, a [Button] typically uses `primary`
 * for its background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [ColorsM2b], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [ColorsM2b.primary], this will return [ColorsM2b.onPrimary].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return
 * the current value of [LocalContentColor] as a best-effort color.
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [ColorsM2b], then returns the current value of [LocalContentColor].
 *
 * @see ColorsM2b.contentColorFor
 */
@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) =
    M2BTheme.colors.contentColorFor(backgroundColor).takeOrElse { LocalContentColor.current }

/**
 * Updates the internal values of the given [ColorsM2b] with values from the [other] [ColorsM2b]. This
 * allows efficiently updating a subset of [ColorsM2b], without recomposing every composable that
 * consumes values from [LocalMaterialColors].
 *
 * Because [ColorsM2b] is very wide-reaching, and used by many expensive composables in the
 * hierarchy, providing a new value to [LocalMaterialColors] causes every composable consuming
 * [LocalMaterialColors] to recompose, which is prohibitively expensive in cases such as animating one
 * color in the theme. Instead, [ColorsM2b] is internally backed by [mutableStateOf], and this
 * function mutates the internal state of [this] to match values in [other]. This means that any
 * changes will mutate the internal state of [this], and only cause composables that are reading
 * the specific changed value to recompose.
 */
internal fun ColorsM2b.updateColorsFrom(other: ColorsM2b) {
    primary = other.primary
    primaryDark = other.primaryDark
    primaryLight = other.primaryLight
    primaryLighter = other.primaryLighter
    content = other.content
    contentDark = other.contentDark
    contentDarker = other.contentDarker
    contentLight = other.contentLight
    contentLighter = other.contentLighter
    success = other.success
    successDark = other.successDark
    successDarker = other.successDarker
    successLight = other.successLight
    successLighter = other.successLighter
    critique = other.critique
    critiqueDark = other.critiqueDark
    critiqueDarker = other.critiqueDarker
    critiqueLight = other.critiqueLight
    critiqueLighter = other.critiqueLighter
    warning = other.warning
    warningDark = other.warningDark
    warningDarker = other.warningDarker
    warningLight = other.warningLight
    warningLighter = other.warningLighter
    surface = other.surface
    error = other.error
    onPrimary = other.onPrimary
    onBackground = other.onBackground
    onSurface = other.onSurface
    onError = other.onError
    isLight = other.isLight
}


/**
 * CompositionLocal used to pass [Colors] down the tree.
 *
 * Setting the value here is typically done as part of [MaterialTheme], which will
 * automatically handle efficiently updating any changed colors without causing unnecessary
 * recompositions, using [Colors.updateColorsFrom].
 * To retrieve the current value of this CompositionLocal, use [MaterialTheme.colors].
 */

val LocalColors = staticCompositionLocalOf { m2bColors() }
