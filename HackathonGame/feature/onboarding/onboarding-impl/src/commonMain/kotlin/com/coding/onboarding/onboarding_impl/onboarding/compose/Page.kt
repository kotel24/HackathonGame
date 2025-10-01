package com.coding.onboarding.onboarding_impl.onboarding.compose

import org.jetbrains.compose.resources.DrawableResource

data class Page(
    val imageUrl: DrawableResource,
    val title: String,
    val description: String
)