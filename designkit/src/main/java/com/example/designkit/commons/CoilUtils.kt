package com.example.designkit.commons

import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter

@OptIn(ExperimentalCoilApi::class)
fun ImagePainter.isCoilImageLoading(): Boolean =
    (this.state is ImagePainter.State.Empty) || (this.state is ImagePainter.State.Loading)
