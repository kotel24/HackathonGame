package com.coding.game

import com.coding.components.pet.di.petModule
import com.coding.core.network.networkModule
import com.coding.main_screen_impl.mainScreenModule

private val coreModules
    get() = listOf(
        networkModule
    )

private val componentsModules
    get() = listOf(
        petModule,
    )

private val featureModules
    get() = listOf(
        mainScreenModule,
    )

val appModules
    get() = listOf(
        coreModules,
        componentsModules,
        featureModules,
    ).flatten()