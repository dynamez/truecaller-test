package com.example.designkit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.designkit.R

val mpFont = FontFamily(
    Font(R.font.nunito_regular, weight = FontWeight.Normal),
    Font(R.font.nunito_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.nunito_bold, weight = FontWeight.Bold),
)

val MPTypography = Typography()

object MPTextStyle {

    private val a = TextStyle(
        fontFamily = mpFont,
        letterSpacing = 0.sp,
        fontStyle = FontStyle.Normal,
    )

    // 10
    private val a10 = a.copy(
        fontSize = 10.sp,
    )

    val a10Regular = a10.copy(
        fontWeight = FontWeight.Normal,
    )

    val a10SemiBold = a10.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a10Bold = a10.copy(
        fontWeight = FontWeight.Bold,
    )

    // 12
    private val a12 = a.copy(
        fontSize = 12.sp,
    )

    val a12Regular = a12.copy(
        fontWeight = FontWeight.Normal,
    )

    val a12SemiBold = a12.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a12Bold = a12.copy(
        fontWeight = FontWeight.Bold,
    )

    // 14
    private val a14 = a.copy(
        fontSize = 14.sp,
    )

    val a14Regular = a14.copy(
        fontWeight = FontWeight.Normal,
    )

    val a14SemiBold = a14.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a14Bold = a14.copy(
        fontWeight = FontWeight.Bold,
    )

    //endregion

    // 16
    private val a16 = a.copy(
        fontSize = 16.sp,
    )

    val a16Regular = a16.copy(
        fontWeight = FontWeight.Normal,
    )

    val a16SemiBold = a16.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a16Bold = a16.copy(
        fontWeight = FontWeight.Bold,
    )

    // 18
    private val a18 = a.copy(
        fontSize = 18.sp,
    )

    val a18Regular = a18.copy(
        fontWeight = FontWeight.Normal,
    )

    val a18SemiBold = a18.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a18Bold = a18.copy(
        fontWeight = FontWeight.Bold,
    )

    // 20
    private val a20 = a.copy(
        fontSize = 20.sp,
    )

    val a20Regular = a20.copy(
        fontWeight = FontWeight.Normal,
    )

    val a20SemiBold = a20.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a20Bold = a20.copy(
        fontWeight = FontWeight.Bold,
    )

    // 24
    private val a24 = a.copy(
        fontSize = 24.sp,
    )

    val a24Regular = a24.copy()

    val a24SemiBold = a24.copy(
        fontWeight = FontWeight.SemiBold,
    )

    val a24Bold = a24.copy(
        fontWeight = FontWeight.Bold,
    )

    // 28
    private val a28 = a.copy(
        fontSize = 28.sp,
    )

    val a28Regular = a28

    val a28SemiBold = a28.copy(fontWeight = FontWeight.SemiBold)

    val a28Bold = a28.copy(fontWeight = FontWeight.SemiBold)

    // 32
    private val a32 = a.copy(
        fontSize = 32.sp,
    )

    val a32Regular = a32

    val a32SemiBold = a32.copy(fontWeight = FontWeight.SemiBold)

    val a32Bold = a32.copy(fontWeight = FontWeight.Bold)

    // 40
    private val a40 = a.copy(
        fontSize = 40.sp,
    )

    val a40Regular = a40

    val a40SemiBold = a40.copy(fontWeight = FontWeight.SemiBold)

    val a40Bold = a40.copy(fontWeight = FontWeight.Bold)

    // 44
    private val a44 = a.copy(
        fontSize = 44.sp,
    )

    val a44Regular = a44

    val a44SemiBold = a44.copy(fontWeight = FontWeight.SemiBold)

    val a44Bold = a44.copy(fontWeight = FontWeight.Bold)
}

// HeadlineXXL
val Typography.m2bHeadlineXXLRegular: TextStyle
    get() = MPTextStyle.a44Regular.copy(lineHeight = 60.sp)

val Typography.m2bHeadlineXXLSemiBold: TextStyle
    get() = MPTextStyle.a44SemiBold.copy(lineHeight = 60.sp)

val Typography.m2bHeadlineXXLBold: TextStyle
    get() = MPTextStyle.a44Bold.copy(lineHeight = 60.sp)

// HeadlineXL
val Typography.m2bHeadlineXLRegular: TextStyle
    get() = MPTextStyle.a40Regular.copy(lineHeight = 55.sp)

val Typography.m2bHeadlineXLSemiBold: TextStyle
    get() = MPTextStyle.a40SemiBold.copy(lineHeight = 55.sp)

val Typography.m2bHeadlineXLBold: TextStyle
    get() = MPTextStyle.a40Bold.copy(lineHeight = 55.sp)

// SubHeadlineL
val Typography.m2bSubHeadlineLRegular: TextStyle
    get() = MPTextStyle.a32Regular.copy(lineHeight = 32.sp)

val Typography.m2bSubHeadlineLSemiBold: TextStyle
    get() = MPTextStyle.a32SemiBold.copy(lineHeight = 32.sp)

val Typography.m2bSubHeadlineLBold: TextStyle
    get() = MPTextStyle.a32Bold.copy(lineHeight = 32.sp)

// SubHeadlineM
val Typography.m2bSubHeadlineMRegular: TextStyle
    get() = MPTextStyle.a28Regular.copy(lineHeight = 34.sp)

val Typography.m2bSubHeadlineMSemiBold: TextStyle
    get() = MPTextStyle.a28SemiBold.copy(lineHeight = 34.sp)

val Typography.m2bSubHeadlineMBold: TextStyle
    get() = MPTextStyle.a28Bold.copy(lineHeight = 34.sp)

// SubTitleL
val Typography.m2bSubTitleLRegular: TextStyle
    get() = MPTextStyle.a24Regular.copy(lineHeight = 33.sp)

val Typography.m2bSubTitleLSemiBold: TextStyle
    get() = MPTextStyle.a24SemiBold.copy(lineHeight = 33.sp)

val Typography.m2bSubTitleLBold: TextStyle
    get() = MPTextStyle.a24Bold.copy(lineHeight = 33.sp)

// SubTitleM
val Typography.m2bSubTitleMRegular: TextStyle
    get() = MPTextStyle.a20Regular.copy(lineHeight = 27.sp)

val Typography.m2bSubTitleMSemiBold: TextStyle
    get() = MPTextStyle.a20SemiBold.copy(lineHeight = 27.sp)

val Typography.m2bSubTitleMBold: TextStyle
    get() = MPTextStyle.a20Bold.copy(lineHeight = 27.sp)

// BodyL
val Typography.m2bBodyLRegular: TextStyle
    get() = MPTextStyle.a18Regular.copy(lineHeight = 25.sp)

val Typography.m2bBodyLSemiBold: TextStyle
    get() = MPTextStyle.a18SemiBold.copy(lineHeight = 25.sp)

val Typography.m2bBodyLBold: TextStyle
    get() = MPTextStyle.a18Bold.copy(lineHeight = 25.sp)

// BodyM
val Typography.m2bBodyMRegular: TextStyle
    get() = MPTextStyle.a16Regular.copy(lineHeight = 22.sp)

val Typography.m2bBodyMSemiBold: TextStyle
    get() = MPTextStyle.a16SemiBold.copy(lineHeight = 22.sp)

val Typography.m2bBodyMBold: TextStyle
    get() = MPTextStyle.a16Bold.copy(lineHeight = 22.sp)

// BodyS
val Typography.m2bBodySRegular: TextStyle
    get() = MPTextStyle.a14Regular.copy(lineHeight = 27.sp)

val Typography.m2bBodySSemiBold: TextStyle
    get() = MPTextStyle.a14SemiBold.copy(lineHeight = 27.sp)

val Typography.m2bBodySBold: TextStyle
    get() = MPTextStyle.a14Bold.copy(lineHeight = 27.sp)

// BodyXS
val Typography.m2bBodyXSRegular: TextStyle
    get() = MPTextStyle.a12Regular.copy(lineHeight = 16.sp)

val Typography.m2bBodyXSSemiBold: TextStyle
    get() = MPTextStyle.a12SemiBold.copy(lineHeight = 16.sp)

val Typography.m2bBodyXSBold: TextStyle
    get() = MPTextStyle.a12Bold.copy(lineHeight = 16.sp)

// BodyXXS
val Typography.m2bBodyXXSRegular: TextStyle
    get() = MPTextStyle.a10Regular.copy(lineHeight = 10.sp)

val Typography.m2bBodyXXSSemiBold: TextStyle
    get() = MPTextStyle.a10SemiBold.copy(lineHeight = 10.sp)

val Typography.m2bBodyXXSBold: TextStyle
    get() = MPTextStyle.a10Bold.copy(lineHeight = 10.sp)
