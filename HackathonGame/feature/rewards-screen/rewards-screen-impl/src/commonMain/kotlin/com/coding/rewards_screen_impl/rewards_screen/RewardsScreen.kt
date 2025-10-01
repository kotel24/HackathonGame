package com.coding.rewards_screen_impl.rewards_screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.coding.mvi_koin_voyager.MviView
import com.coding.mvi_koin_voyager.collectEvent
import com.coding.rewards_screen_impl.rewards_screen.compose.RewardsScreenContent
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsAction
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsEffect
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsEvent
import com.coding.rewards_screen_impl.rewards_screen.mvi.RewardsState
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject

internal class RewardsScreen : MviView<RewardsAction, RewardsEvent, RewardsState> {

    @Composable
    override fun content(
        state: RewardsState,
        eventFlow: Flow<RewardsEvent>,
        pushAction: (RewardsAction) -> Unit
    ) {
        val navigator = LocalNavigator.currentOrThrow

        // Обработка событий
        eventFlow.collectEvent { event ->
            when (event) {
                RewardsEvent.NavigateToMainScreen -> navigator.pop()
            }
        }

        // Подключаем UI
        RewardsScreenContent(
            wonRewards = state.earnedRewards,
            availableRewards = state.lockedRewards,
            onRewardClick = { reward ->
                pushAction(RewardsAction.OnRewardClick(reward.id))
            }
        )
    }
}