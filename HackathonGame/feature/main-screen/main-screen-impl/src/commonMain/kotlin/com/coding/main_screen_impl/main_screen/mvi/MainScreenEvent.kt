package com.coding.main_screen_impl.main_screen.mvi

import com.coding.mvi_general.MviEvent

internal sealed interface MainScreenEvent : MviEvent {
    data object NavigateToSomething : MainScreenEvent
}