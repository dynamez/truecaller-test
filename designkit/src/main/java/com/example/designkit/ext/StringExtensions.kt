package com.example.designkit.ext

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.example.designkit.R.drawable.m2b_ic_add_cash
import com.example.designkit.R.drawable.m2b_ic_benefits
import com.example.designkit.R.drawable.m2b_ic_calendar
import com.example.designkit.R.drawable.m2b_ic_cashin
import com.example.designkit.R.drawable.m2b_ic_cashout
import com.example.designkit.R.drawable.m2b_ic_clothes
import com.example.designkit.R.drawable.m2b_ic_collect_payment
import com.example.designkit.R.drawable.m2b_ic_connect
import com.example.designkit.R.drawable.m2b_ic_gift
import com.example.designkit.R.drawable.m2b_ic_iva
import com.example.designkit.R.drawable.m2b_ic_like
import com.example.designkit.R.drawable.m2b_ic_lottery
import com.example.designkit.R.drawable.m2b_ic_new_bill
import com.example.designkit.R.drawable.m2b_ic_shop
import com.example.designkit.R.drawable.m2b_ic_theater
import com.example.designkit.R.drawable.m2b_ic_ticket
import com.example.designkit.R.drawable.m2b_ic_winners
import com.example.designkit.ext.IconConstants.ICON_ADD_MONEY
import com.example.designkit.ext.IconConstants.ICON_BENEFITS
import com.example.designkit.ext.IconConstants.ICON_CALENDAR
import com.example.designkit.ext.IconConstants.ICON_CASH_IN
import com.example.designkit.ext.IconConstants.ICON_CASH_OUT
import com.example.designkit.ext.IconConstants.ICON_CLOTHES
import com.example.designkit.ext.IconConstants.ICON_CONNECT
import com.example.designkit.ext.IconConstants.ICON_GIFT
import com.example.designkit.ext.IconConstants.ICON_IVA
import com.example.designkit.ext.IconConstants.ICON_LIKE
import com.example.designkit.ext.IconConstants.ICON_LOTTERY
import com.example.designkit.ext.IconConstants.ICON_NEW_BILL
import com.example.designkit.ext.IconConstants.ICON_PEOPLE_PAYMENT
import com.example.designkit.ext.IconConstants.ICON_SHOP
import com.example.designkit.ext.IconConstants.ICON_THEATER
import com.example.designkit.ext.IconConstants.ICON_TICKET
import com.example.designkit.ext.IconConstants.ICON_WINNERS
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.PrimaryM2b

fun String.toBoldMarkDown(delimiter: String = "**"): AnnotatedString {
    var newText = this
    return buildAnnotatedString {
        var wordLength: Int
        var startIndex: Int
        var endIndex: Int
        val numberOfBoldOccurrences = (split(delimiter).size - ONE) / TWO
        val areDelimitersClosed = (split(delimiter).size - ONE) % TWO == ZERO

        if (contains(delimiter) && areDelimitersClosed) {
            repeat(numberOfBoldOccurrences) {
                wordLength =
                    newText.substringAfter(delimiter).substringBefore(delimiter).length
                startIndex = newText.indexOf(delimiter)
                endIndex = startIndex + wordLength

                addStyle(
                    SpanStyle(fontWeight = FontWeight.Bold),
                    start = startIndex,
                    end = endIndex,
                )
                newText = newText
                    .replaceFirst(delimiter, String())
                    .replaceFirst(delimiter, String())
            }
            append(newText)
        } else {
            append(filter { it != '*' })
        }
    }
}

@Composable
fun String.toClickableMarkdown(
    tag: String = TAG,
    delimiter: String = "[",
    delimiterEnd: String = "]",
    spanStyle: SpanStyle = SpanStyle(
        color = M2BTheme.colors.primary,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    ),
): AnnotatedString {
    var newText = this
    return buildAnnotatedString {
        if (contains(delimiter) && contains(delimiterEnd)) {
            val wordLength = newText.substringAfter(delimiter).substringBefore(delimiterEnd).length
            val startIndex = newText.indexOf(delimiter)

            addStyle(
                spanStyle,
                start = startIndex,
                end = startIndex + wordLength,
            )
            newText = newText.replaceFirst(delimiter, String()).replaceFirst(delimiterEnd, String())

            pushStringAnnotation(tag, newText)
            append(newText)
        } else {
            append(newText.replace(delimiter, String()).replace(delimiterEnd, String()))
        }
    }
}

fun String.toColorHex(colorFallBack: Color = PrimaryM2b): Color = try {
    Color(android.graphics.Color.parseColor(this.replace("0xFF", "#")))
} catch (e: Exception) {
    colorFallBack
}

fun String.toIconDk(@DrawableRes fallBackIcon: Int = m2b_ic_connect): Int = when (this) {
    ICON_CALENDAR -> m2b_ic_calendar
    ICON_THEATER -> m2b_ic_theater
    ICON_ADD_MONEY -> m2b_ic_add_cash
    ICON_CASH_IN -> m2b_ic_cashin
    ICON_NEW_BILL -> m2b_ic_new_bill
    ICON_CASH_OUT -> m2b_ic_cashout
    ICON_GIFT -> m2b_ic_gift
    ICON_BENEFITS -> m2b_ic_benefits
    ICON_CLOTHES -> m2b_ic_clothes
    ICON_PEOPLE_PAYMENT -> m2b_ic_collect_payment
    ICON_WINNERS -> m2b_ic_winners
    ICON_LIKE -> m2b_ic_like
    ICON_CONNECT -> m2b_ic_connect
    ICON_TICKET -> m2b_ic_ticket
    ICON_IVA -> m2b_ic_iva
    ICON_LOTTERY -> m2b_ic_lottery
    ICON_SHOP -> m2b_ic_shop
    else -> fallBackIcon
}

private object IconConstants {
    const val ICON_CALENDAR = "icon-calendar"
    const val ICON_THEATER = "icon-theater"
    const val ICON_ADD_MONEY = "icon-add-money"
    const val ICON_CASH_IN = "icon-cashin"
    const val ICON_NEW_BILL = "icon-new-bill"
    const val ICON_CASH_OUT = "icon-cashout"
    const val ICON_GIFT = "icon-gift"
    const val ICON_BENEFITS = "icon-benefits"
    const val ICON_CLOTHES = "icon-clothes"
    const val ICON_PEOPLE_PAYMENT = "icon-people-payment"
    const val ICON_WINNERS = "icon-winners"
    const val ICON_LIKE = "icon-like"
    const val ICON_CONNECT = "icon-connect"
    const val ICON_TICKET = "icon-ticket"
    const val ICON_IVA = "icon-iva"
    const val ICON_LOTTERY = "icon-lottery"
    const val ICON_SHOP = "icon-shop"
}


private const val ZERO = 0
private const val ONE = 1
private const val TWO = 2
private const val TAG = "tag"
