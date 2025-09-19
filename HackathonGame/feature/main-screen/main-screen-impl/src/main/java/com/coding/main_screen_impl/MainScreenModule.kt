package com.coding.main_screen_impl

import org.koin.dsl.module

val mainScreenModule
    get() = module {
        //provideMviModel<MainScreen> { tag, _ -> MainScreenModel(tag) }
        single<MainScreenApi> { MainScreenImpl() }
    }