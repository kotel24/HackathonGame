package com.coding.onboarding.onboarding_impl.onboarding.mvi

import com.coding.mvi_general.MviEvent

internal sealed interface OnboardingEvent : MviEvent {
    data object NavigateToMainScreen : OnboardingEvent
}