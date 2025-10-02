package com.coding.theory_screen_impl.theory_screen.mvi

import com.coding.mvi_general.MviEvent

internal sealed interface TheoryEvent : MviEvent {
    data class NavigateToDetail(val id: String) : TheoryEvent
}