package com.coding.rewards_screen_impl.rewards_screen

import com.coding.core.settings.SettingsRepository
import com.coding.mvi_koin_voyager.MviModel
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsAction
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsEffect
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsEvent
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsState

internal class RewardsScreenModel(
    tag: String,
) : MviModel<RewardsAction, RewardsEffect, RewardsEvent, RewardsState>(
    defaultState = RewardsState(),
    tag = tag,
) {

    override suspend fun actor(action: RewardsAction) =
        when (action) {
            RewardsAction.ClickButtonExample -> TODO()
            is RewardsAction.OnRewardClick -> TODO()
        }
}