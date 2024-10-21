package com.example.designkit.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val MachPayBlue = Color(0xFF0064FF)
val BlueRibbon = Color(0xFF0064FF)
val BlueRibbonCake = Color(0xFF66A3FF)
val BlueRibbonLight = Color(0xFFE5F0FF)
val PureWhite = Color(0xffffffff)
val UiGrayGothic = Color(0xff222222)
val ContentLight = Color(0xffD3D3D3)
val GrayCultured = Color(0xffF1F1F1)
val GrayQueen = Color(0xFF555555)
val GrayMine = Color(0xFF888888)
val GreenSpring = Color(0xFF00EE88)
val GreenSpringLight = Color(0xFFCCFFE9)
val GreenSpringDark = Color(0xFF008226)
val RedLip = Color(0xFFED0000)
val VioletMach = Color(0xFF6200EE)
val WhitePerl = Color(0xffFDFDFD)
val GrayBottom = Color(0xffB6B6B6)
val GrayShimmer = Color(0xFFD8D8D8)
val CritiqueMain: Color = Color(0xFFF8554B)

// new Palette M2B

val PrimaryDarkM2b = Color(0xFF003ED0)
val PrimaryM2b = Color(0xFF0064FF)
val PrimaryLightM2b = Color(0xFF66A3FF)
val PrimaryLighterM2b = Color(0xFFE5F0FF)

val PrimaryDarkMach = Color(0xFF440099)
val PrimaryMach = Color(0xFF6200EE)
val PrimaryLightMach = Color(0xFFC28EFF)
val PrimaryLighterMach = Color(0xFFF5EEFF)

val PrimaryDarkBci = Color(0xFF166918)
val PrimaryBci = Color(0xFF22892B)
val PrimaryLightBci = Color(0xFFA9D0AA)
val PrimaryLighterBci = Color(0xFFD4E7D5)

val SuccessM2b = Color(0xFF00EE88)
val SuccessDarkM2b = Color(0xFF008226)
val SuccessDarkerM2b = Color(0xFF004E17)
val SuccessLightM2b = Color(0xFF80FFC8)
val SuccessLighterM2b = Color(0xFFCCFFE9)

val CritiqueM2b: Color = Color(0xFFF8554B)
val CritiqueDarkM2b: Color = Color(0xFFD51408)
val CritiqueDarkerM2b: Color = Color(0xFF800C04)
val CritiqueLightM2b: Color = Color(0xFFFB9B95)
val CritiqueLighterM2b: Color = Color(0xFFFEE0DE)

val WarningM2b: Color = Color(0xFFFFCF26)
val WarningDarkM2b: Color = Color(0xFFEE9B00)
val WarningDarkerM2b: Color = Color(0xFF8F5D00)
val WarningLightM2b: Color = Color(0xFFFFE769)
val WarningLighterM2b: Color = Color(0xFFFFFBD6)


val ContentM2b: Color = Color(0xFF999999)
val ContentDarkM2b: Color = Color(0xFF666666)
val ContentDarkerM2b: Color = Color(0xFF333333)
val ContentLightM2b: Color = Color(0xFFD8D8D8)
val ContentLighterM2b: Color = Color(0xFFF6F6F6)



object M2BColor {
    // Ribbon
    val ribbonDark = Color(0, 62, 208)
    val ribbonMain = Color(0, 100, 255)
    val ribbonCake = Color(102, 163, 255)
    val ribbonLight = Color(229, 240, 255)

    // Lip
    val lipRed = Color(237, 0, 0)

    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val Teal200 = Color(0xFF03DAC5)

    val white = Color(255, 255, 255)

    // Gray Number Scale
    val grayDark = Color(51, 51, 51)
    val grayDisabled = Color(216, 216, 216)
    val graySilver = Color(153, 153, 153)

    // Content
    val m2bGrayGothic = Color(34, 34, 34)
    val m2bGrayQueen = Color(85, 85, 85)
    val m2bGrayMine = Color(136, 136, 136)
    val m2bGrayDisabled = Color(211, 211, 211)

    val statusBarColor = Color.White
}

// primary
@get:Composable
val ColorScheme.m2bPrimaryDark: Color
    get() = M2BColor.ribbonDark

@get:Composable
val ColorScheme.m2bPrimaryMain: Color
    get() = M2BColor.ribbonMain

@get:Composable
val ColorScheme.m2bPrimaryLight: Color
    get() = M2BColor.ribbonLight

// content
@get:Composable
val ColorScheme.m2bContentBold: Color
    get() = M2BColor.m2bGrayGothic

@get:Composable
val ColorScheme.m2bContentMain: Color
    get() = M2BColor.m2bGrayMine

@get:Composable
val ColorScheme.m2bContentSoft: Color
    get() = M2BColor.m2bGrayDisabled

@get:Composable
val ColorScheme.m2bContentForeground: Color
    get() = M2BColor.white

// error
@get:Composable
val ColorScheme.m2bErrorMain: Color
    get() = M2BColor.lipRed

// background
@get:Composable
val ColorScheme.m2bBackground: Color
    get() = M2BColor.white
