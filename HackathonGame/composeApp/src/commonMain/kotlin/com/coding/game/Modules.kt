package com.coding.game

import com.coding.components.pet.di.petModule
import com.coding.core.network.networkModule
import com.coding.core.settings.settingsModule
import com.coding.main_screen_impl.mainScreenModule
import com.coding.onboarding.onboarding_impl.onboardingModule

private val coreModules
    get() = listOf(
        networkModule,
        settingsModule
    )

private val componentsModules
    get() = listOf(
        petModule,
    )

private val featureModules
    get() = listOf(
        mainScreenModule,
        onboardingModule
    )

val appModules
    get() = listOf(
        coreModules,
        componentsModules,
        featureModules,
    ).flatten()