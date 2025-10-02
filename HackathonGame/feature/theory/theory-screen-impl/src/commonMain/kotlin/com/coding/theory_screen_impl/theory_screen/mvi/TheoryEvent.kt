package com.coding.theory_screen_impl.theory_screen.mvi

internal sealed interface TheoryEvent {
    data class NavigateToDetail(val id: String) : TheoryEvent
}