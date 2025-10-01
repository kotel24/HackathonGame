package com.coding.main_screen_impl

import com.coding.main_screen_api.MainScreenApi
import com.coding.main_screen_impl.main_screen.MainScreen
import com.coding.main_screen_impl.main_screen.MainScreenModel
import com.coding.mvi_koin_voyager.provideMviModel
import org.koin.dsl.module

val mainScreenModule
    get() = module {
        provideMviModel<MainScreen> { tag, _ -> MainScreenModel(tag, get()) }
        single<MainScreenApi> { MainScreenImpl() }
    }