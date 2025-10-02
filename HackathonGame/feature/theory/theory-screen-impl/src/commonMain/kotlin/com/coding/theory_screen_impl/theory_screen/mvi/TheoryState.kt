package com.coding.theory_screen_impl.theory_screen.mvi

import com.coding.theory_screen_impl.theory_screen.compose.TheoryArticle

internal data class TheoryState(
    val isLoading: Boolean = false,
    val articles: List<TheoryArticle> = emptyList()
)