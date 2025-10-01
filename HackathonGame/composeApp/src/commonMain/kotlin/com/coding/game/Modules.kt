package com.coding.game

import com.coding.components.pet.di.petModule
import com.coding.components.quiz.di.quizModule
import com.coding.core.network.networkModule
import com.coding.core.settings.settingsModule
import com.coding.course_screen_impl.courseScreenModule
import com.coding.main_screen_impl.mainScreenModule
import com.coding.onboarding.onboarding_impl.onboardingModule
import com.coding.rewards_screen_impl.rewardsScreenModule
import com.coding.quiz_screen_impl.quizScreenModule

private val coreModules
    get() = listOf(
        networkModule,
        settingsModule
    )

private val componentsModules
    get() = listOf(
        petModule,
        quizModule
    )

private val featureModules
    get() = listOf(
        mainScreenModule,
        onboardingModule,
        rewardsScreenModule
        courseScreenModule,
        quizScreenModule
    )

val appModules
    get() = listOf(
        coreModules,
        componentsModules,
        featureModules,
    ).flatten()