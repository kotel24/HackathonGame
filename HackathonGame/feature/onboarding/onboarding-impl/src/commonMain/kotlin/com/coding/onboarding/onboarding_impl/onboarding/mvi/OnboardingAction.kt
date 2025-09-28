package com.coding.onboarding.onboarding_impl.onboarding.mvi

import com.coding.mvi_general.MviAction

internal sealed interface OnboardingAction : MviAction {
    data class ClickButtonToMainScreen(val name: String) : OnboardingAction
}