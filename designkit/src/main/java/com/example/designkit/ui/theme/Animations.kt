package com.example.designkit.ui.theme

object Animations {
    object ButtonLoader
    object MACHPAY
}

val Animations.ButtonLoader.Primary: String
    get() = "animations/loader-btn.json"

val Animations.ButtonLoader.Outline: String
    get() = "animations/loader-btn-white.json"

val Animations.MACHPAY.Default: String
    get() = "animations/machpay-animation.json"

val Animations.MACHPAY.Simple: String
    get() = "animations/machpay-simple-animation.json"
