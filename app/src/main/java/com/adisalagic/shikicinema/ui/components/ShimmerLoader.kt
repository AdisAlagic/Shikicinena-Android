package com.adisalagic.shikicinema.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import com.adisalagic.shikicinema.ui.theme.getTheme
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

@Composable
fun getShimmerLoader(): ShimmerDrawable{
    val shimmer = Shimmer.ColorHighlightBuilder()
        .setBaseColor(getTheme().secondary.toArgb())
        .setHighlightColor(getTheme().primary.toArgb())
        .build()
    return ShimmerDrawable().apply {
        setShimmer(shimmer)
    }
}