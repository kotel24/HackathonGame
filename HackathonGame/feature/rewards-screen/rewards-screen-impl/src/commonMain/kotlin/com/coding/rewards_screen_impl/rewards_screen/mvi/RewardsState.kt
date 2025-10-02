package com.coding.rewards_screen_impl.rewards_screen.mvi

import com.coding.mvi_general.MviState
import com.coding.rewards_screen_impl.rewards_screen.compose.Reward

internal data class RewardsState(
    val earnedRewards: List<Reward> = emptyList(),
    val lockedRewards: List<Reward> = emptyList()
) : MviState