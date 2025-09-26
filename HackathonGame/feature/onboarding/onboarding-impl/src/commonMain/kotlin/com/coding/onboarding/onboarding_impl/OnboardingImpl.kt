package com.coding.onboarding.onboarding_impl

import cafe.adriel.voyager.core.screen.Screen
import com.coding.onboarding.onboarding_api.OnboardingApi
import com.coding.onboarding.onboarding_impl.onboarding.OnboardingScreen


internal class OnboardingImpl : OnboardingApi {
    override fun onboardingScreen(): Screen = OnboardingScreen()
}