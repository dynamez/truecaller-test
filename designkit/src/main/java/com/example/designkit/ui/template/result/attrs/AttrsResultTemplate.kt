package com.example.designkit.ui.template.result.attrs

import androidx.annotation.DrawableRes

data class AttrsResultTemplate(
    val title: String,
    val description: String,
    @DrawableRes val imageLocal: Int,
    val primaryButtonText: String,
    val secondaryButtonText: String? = null,
    val imageUrl: String? = null,
    val imageDescription: String? = null,
    val alertText: String? = null,
    @DrawableRes val alertIcon: Int? = null,
    val scrollable: Boolean = true,
)