package com.coding.core.settings

import com.russhwolf.settings.ExperimentalSettingsApi
import org.koin.core.module.Module
import org.koin.dsl.module

@OptIn(ExperimentalSettingsApi::class)
val settingsModulee
    get() = module {
        single { SettingsRepository(get()) }
    }

expect val settingsModule: Module