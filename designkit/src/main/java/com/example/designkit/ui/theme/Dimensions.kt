package com.example.designkit.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimensions(

    val dimen0: Dp = 0.dp,
    val dimen1: Dp = 1.dp,
    val dimen2: Dp = 2.dp,
    val dimen4: Dp = 4.dp,
    val dimen6: Dp = 6.dp,
    val dimen8: Dp = 8.dp,
    val dimen9: Dp = 9.dp,
    val dimen10: Dp = 10.dp,
    val dimen12: Dp = 12.dp,
    val dimen14: Dp = 14.dp,
    val dimen16: Dp = 16.dp,
    val dimen18: Dp = 18.dp,
    val dimen20: Dp = 20.dp,
    val dimen22: Dp = 22.dp,
    val dimen24: Dp = 24.dp,
    val dimen25: Dp = 25.dp,
    val dimen26: Dp = 26.dp,
    val dimen28: Dp = 28.dp,
    val dimen30: Dp = 30.dp,
    val dimen32: Dp = 32.dp,
    val dimen33: Dp = 33.dp,
    val dimen36: Dp = 36.dp,
    val dimen38: Dp = 38.dp,
    val dimen40: Dp = 40.dp,
    val dimen42: Dp = 42.dp,
    val dimen44: Dp = 44.dp,
    val dimen46: Dp = 46.dp,
    val dimen48: Dp = 48.dp,
    val dimen50: Dp = 50.dp,
    val dimen52: Dp = 52.dp,
    val dimen56: Dp = 56.dp,
    val dimen60: Dp = 60.dp,
    val dimen70: Dp = 70.dp,
    val dimen75: Dp = 75.dp,
    val dimen100: Dp = 100.dp,
    val dimen103: Dp = 103.dp,
    val dimen116: Dp = 116.dp,
    val dimen128: Dp = 128.dp,
    val dimen134: Dp = 134.dp,
    val dimen154: Dp = 154.dp,
    val dimen280: Dp = 280.dp,
    val dimen430: Dp = 430.dp,

    val noElevation: Dp = 0.dp,
    val buttonHeight: Dp = 48.dp,
    val buttonSmallHeight: Dp = 40.dp,
    val paddingButton: Dp = 16.dp,
    val topBarHeight: Dp = 60.dp,
    val iconSize: Dp = 24.dp,
    val screenHorizontalPadding: Dp = 20.dp,
    val illustrationResultInfoVoucher: Dp = 96.dp,


    )

val Dp.scaled: Dp
    @Composable
    get() = (LocalDensity.current.fontScale * value).dp

@Immutable
object LocalFloat {
    const val float_0 = 0f
    const val float_05 = 0.5f
    const val float_1 = 1f
    const val float_180 = 180f
    const val float_360 = 360f
    const val fillRemainingSpace = 1f
}
