package com.coding.rewards_screen_impl

import cafe.adriel.voyager.core.screen.Screen
import com.coding.rewards_screen_api.RewardsScreenApi
import com.coding.rewards_screen_impl.rewards_screen.RewardsScreen

internal class RewardsScreenImpl : RewardsScreenApi {
    override fun rewardsScreen(): Screen = RewardsScreen()
}