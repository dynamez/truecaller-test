package com.example.designkit.ui.organism.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designkit.ext.conditional
import com.example.designkit.ui.atom.PillL
import com.example.designkit.ui.atom.SpacerSM
import com.example.designkit.ui.atom.Text
import com.example.designkit.ui.organism.card.CardOfferDefaults.SELECTED
import com.example.designkit.ui.organism.card.CardOfferDefaults.UN_SELECTED
import com.example.designkit.ui.organism.card.CardOfferDefaults.borderStroke
import com.example.designkit.ui.organism.card.CardOfferDefaults.colorBackgroundCard
import com.example.designkit.ui.organism.card.CardOfferDefaults.colorBackgroundPill
import com.example.designkit.ui.organism.card.CardOfferDefaults.colorBorder
import com.example.designkit.ui.organism.card.CardOfferDefaults.colorPriceText
import com.example.designkit.ui.organism.card.CardOfferDefaults.colorTextPill
import com.example.designkit.ui.organism.card.CardOfferDefaults.horizontalPadding
import com.example.designkit.ui.organism.card.CardOfferDefaults.pillPadding
import com.example.designkit.ui.organism.card.CardOfferDefaults.subtitleAnnotatedStringStyle
import com.example.designkit.ui.theme.M2BTheme
import com.example.designkit.ui.theme.M2BTheme.colors
import com.example.designkit.ui.theme.M2BTheme.typography
import com.example.designkit.ui.theme.M2bColorsTheme
import com.example.designkit.ui.theme.bold
import com.example.designkit.ui.theme.scaled
import com.example.designkit.ui.organism.card.Card


@Composable
fun CardOffer(
    title: String,
    subtitle: String,
    pillText: String?,
    listOfDescription: List<String>,
    modifier: Modifier = Modifier,
    discountedPrice: String? = null,
    selected: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .conditional(enabled) {
                selectable(
                    selected = selected,
                    enabled = true,
                    onClick = onClick,
                )
            }
            .semantics(mergeDescendants = true) {
                stateDescription = if (selected) SELECTED else UN_SELECTED
            }
            .then(modifier),
        shape = M2BTheme.shapes.small,
        border = BorderStroke(borderStroke, colorBorder(selected)),
        backgroundColor = colorBackgroundCard(enabled),
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = horizontalPadding)
                .padding(top = CardOfferDefaults.applyPaddingBasedOnPillText(pillText))
                .fillMaxWidth(),
        ) {
            pillText?.let {
                PillL(
                    modifier = Modifier
                        .padding(top = pillPadding, end = pillPadding)
                        .align(Alignment.End),
                    text = pillText,
                    colorText = colorTextPill(selected, enabled),
                    backgroundColor = colorBackgroundPill(selected, enabled),
                )
            }

            Row {

                SpacerSM()

                RadioButton(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    selected = selected,
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colors.primary,
                        unselectedColor = colors.content,
                        disabledSelectedColor = colors.contentLight,
                    )
                )


                Column(Modifier.padding(horizontal = 16.dp)) {
                    Text(text = title, style = typography.bodyM.bold)
                    Row {
                        Text(
                            text = subtitleAnnotatedStringStyle(subtitle, discountedPrice, enabled),
                            style = typography.bodyM.bold,
                            color = colorPriceText(enabled),
                        )
                    }
                    listOfDescription.forEach { description ->
                        Text(
                            text = "• $description",
                            style = typography.bodyS,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(start = 12.dp.scaled),
                            color = colors.contentDark,
                        )
                    }
                }
            }
        }
    }
}

@Stable
data class AttrsCardOffer(
    val id: String,
    val title: String,
    val subtitle: String,
    val listOfDescription: List<String>,
    val discountedPrice: String? = null,
    val pillText: String?,
    val enabled: Boolean = true,
)

@Stable
data class AttrsCardOfferList(
    val list: List<AttrsCardOffer>,
)

@Stable
data class CardOfferColors(
    val colorBorderSelected: Color,
    val colorBorderUnSelected: Color,
    val backgroundColorSelectedPill: Color,
    val backgroundColorUnSelectedPill: Color,
    val backgroundColorDisabledPill: Color,
    val colorSelectedTextPill: Color,
    val colorUnselectedTextPill: Color,
    val colorDisabledTextPill: Color,
    val colorPriceText: Color,
    val backgroundColor: Color,
)

object CardOfferDefaults {

    val pillPadding = 8.dp
    val horizontalPadding = 20.dp
    val borderStroke = 1.dp

    const val SELECTED = "selecionado"
    const val UN_SELECTED = "no selecionado"

    @Composable
    fun cardOfferColors(
        colorBorderSelected: Color = colors.primary,
        colorBorderUnSelected: Color = colors.contentLight,
        backgroundColorSelectedPill: Color = colors.primary,
        backgroundColorUnSelectedPill: Color = colors.primaryLighter,
        backgroundColorDisabledPill: Color = colors.successLighter,
        colorSelectedTextPill: Color = colors.surface,
        colorUnselectedTextPill: Color = colors.primary,
        colorDisabledTextPill: Color = colors.successDarker,
        colorPriceText: Color = colors.primary,
        backgroundColor: Color = colors.surface,
    ) = CardOfferColors(
        colorBorderSelected = colorBorderSelected,
        colorBorderUnSelected = colorBorderUnSelected,
        backgroundColorSelectedPill = backgroundColorSelectedPill,
        backgroundColorUnSelectedPill = backgroundColorUnSelectedPill,
        backgroundColorDisabledPill = backgroundColorDisabledPill,
        colorSelectedTextPill = colorSelectedTextPill,
        colorUnselectedTextPill = colorUnselectedTextPill,
        colorDisabledTextPill = colorDisabledTextPill,
        colorPriceText = colorPriceText,
        backgroundColor = backgroundColor,
    )

    @Composable
    fun colorBorder(isSelected: Boolean) =
        if (isSelected) cardOfferColors().colorBorderSelected
        else cardOfferColors().colorBorderUnSelected


    @Composable
    fun colorBackgroundPill(isSelected: Boolean, isEnabled: Boolean = true) =
        when (isEnabled) {
            true -> {
                if (isSelected) cardOfferColors().backgroundColorSelectedPill
                else cardOfferColors().backgroundColorUnSelectedPill
            }

            false -> cardOfferColors().backgroundColorDisabledPill
        }

    @Composable
    fun colorTextPill(isSelected: Boolean, isEnabled: Boolean) =
        when (isEnabled) {
            true -> {
                if (isSelected) cardOfferColors().colorSelectedTextPill
                else cardOfferColors().colorUnselectedTextPill
            }

            false -> cardOfferColors().colorDisabledTextPill
        }


    @Composable
    fun colorPriceText(isEnabled: Boolean) =
        if (isEnabled) cardOfferColors().colorPriceText
        else colors.content

    @Composable
    fun colorBackgroundCard(isEnabled: Boolean) =
        if (isEnabled) cardOfferColors().backgroundColor
        else colors.contentLighter

    @Composable
    fun subtitleAnnotatedStringStyle(subtitle: String, discountedPrice: String?, enabled: Boolean) =
        buildAnnotatedString {
            val styleSubtitle = SpanStyle(
                color = colorPriceText(enabled),
                fontWeight = FontWeight.Bold,
            )
            val discountedPriceStyle = SpanStyle(
                color = colors.contentDark,
                textDecoration = TextDecoration.LineThrough,
                fontWeight = FontWeight.Normal,
            )

            withStyle(styleSubtitle) {
                append(subtitle)
            }
            append(" ")
            discountedPrice?.let { price ->
                withStyle(discountedPriceStyle) {
                    append(price)
                }
            }
        }

    @Composable
    fun applyPaddingBasedOnPillText(pillText: String?) = 0.dp.takeIf { pillText != null } ?: 20.dp
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    fontScale = 1.0f
)
@Composable
private fun Preview() {
    M2BTheme(M2bColorsTheme.M2B) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
                .selectableGroup()
                .verticalScroll(rememberScrollState()),

            ) {

            val attrsCard = AttrsCardOffer(
                id = "1",
                title = "Una Descripcion muy larga que no cabe en el espacio disponible",
                subtitle = "$250.000/Anual",
                listOfDescription = listOf(
                    "description 1",
                    "un texto muy largo que no entra bien en el contenido",
                    "description 3"
                ),
                pillText = "{00/LABEL}",
            )

            val listOfAttrsCard = AttrsCardOfferList(
                list = listOf(
                    attrsCard,
                    attrsCard.copy(id = "2", discountedPrice = "$300.000"),
                    attrsCard.copy(id = "3", pillText = null),
                    attrsCard.copy(id = "4", enabled = false),
                )
            )


            val (selectedOption, onOptionSelected) = remember {
                mutableStateOf(listOfAttrsCard.list[0])
            }

            listOfAttrsCard.list.forEach { attrs ->

                CardOffer(
                    modifier = Modifier,
                    pillText = attrs.pillText,
                    title = attrs.title,
                    subtitle = attrs.subtitle,
                    discountedPrice = attrs.discountedPrice,
                    listOfDescription = attrs.listOfDescription,
                    selected = (attrs.id == selectedOption.id),
                    enabled = attrs.enabled,
                    onClick = { onOptionSelected(attrs) }
                )

                SpacerSM()
            }
        }
    }
}