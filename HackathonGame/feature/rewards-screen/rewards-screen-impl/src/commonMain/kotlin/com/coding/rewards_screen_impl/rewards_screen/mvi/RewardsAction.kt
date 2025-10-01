package com.coding.rewards_screen_impl.rewards_screen.mvi

import com.coding.mvi_general.MviAction

internal sealed interface RewardsAction : MviAction {
    data object ClickButtonExample : RewardsAction

    data class OnRewardClick(val rewardId: String) : RewardsAction
}