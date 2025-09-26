package com.coding.onboarding.onboarding_impl.onboarding

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.coding.main_screen_api.MainScreenApi
import com.coding.mvi_koin_voyager.MviView
import com.coding.mvi_koin_voyager.collectEvent
import com.coding.onboarding.onboarding_impl.onboarding.compose.OnboardingContent
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingAction
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingEvent
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingState
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject

internal class OnboardingScreen : MviView<OnboardingAction, OnboardingEvent, OnboardingState> {

    @Composable
    override fun content(
        state: OnboardingState,
        eventFlow: Flow<OnboardingEvent>,
        pushAction: (OnboardingAction) -> Unit
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val mainScreenApi = koinInject<MainScreenApi>()

        eventFlow.collectEvent { event ->
            when(event) {
                OnboardingEvent.NavigateToMainScreen ->
                    navigator.push(mainScreenApi.mainScreen())
            }
        }

        OnboardingContent(
            onClickToMainScreen = {
                pushAction(OnboardingAction.ClickButtonToMainScreen)
            }
        )
    }
}