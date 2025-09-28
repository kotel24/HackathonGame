package com.coding.onboarding.onboarding_impl.onboarding

import com.coding.core.settings.SettingsRepository
import com.coding.mvi_koin_voyager.MviModel
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingAction
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingEffect
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingEvent
import com.coding.onboarding.onboarding_impl.onboarding.mvi.OnboardingState

internal class OnboardingModel(
    tag: String,
    private val settingsRepository: SettingsRepository
) : MviModel<OnboardingAction, OnboardingEffect, OnboardingEvent, OnboardingState>(
    defaultState = OnboardingState,
    tag = tag
) {
    override suspend fun actor(action: OnboardingAction) {
        when (action) {
            is OnboardingAction.ClickButtonToMainScreen -> {
                settingsRepository.setOnboardingCompleted(completed = true)
                // saveName(action.name)
                push(OnboardingEvent.NavigateToMainScreen)
            }
        }
    }
}