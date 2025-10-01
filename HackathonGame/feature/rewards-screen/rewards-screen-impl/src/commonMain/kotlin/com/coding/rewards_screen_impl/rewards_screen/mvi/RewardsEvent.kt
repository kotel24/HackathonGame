package com.coding.rewards_screen_impl.rewards_screen.mvi

import com.coding.mvi_general.MviEvent

internal sealed interface RewardsEvent : MviEvent {
    data object NavigateToMainScreen : RewardsEvent
}