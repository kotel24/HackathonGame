package com.coding.theory_screen_impl.theory_screen.mvi

import com.coding.mvi_general.MviAction

internal sealed interface TheoryAction : MviAction {
    data class OnArticleClick(val id: String) : TheoryAction
}