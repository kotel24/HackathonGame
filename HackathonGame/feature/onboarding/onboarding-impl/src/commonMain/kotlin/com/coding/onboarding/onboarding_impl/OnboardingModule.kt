package com.coding.onboarding.onboarding_impl

import com.coding.core.settings.SettingsRepository
import com.coding.mvi_koin_voyager.provideMviModel
import com.coding.onboarding.onboarding_api.OnboardingApi
import com.coding.onboarding.onboarding_impl.onboarding.OnboardingModel
import com.coding.onboarding.onboarding_impl.onboarding.OnboardingScreen
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val onboardingModule
    get() = module {
        provideMviModel<OnboardingScreen> { tag, _ -> OnboardingModel(tag = tag, settingsRepository = get()) }
        single<OnboardingApi> { OnboardingImpl() }
    }