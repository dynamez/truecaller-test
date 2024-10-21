package com.example.truecallertest.presentation.model

sealed class MainSideEffect {
    data class ShowError(val message: String) : MainSideEffect()
}