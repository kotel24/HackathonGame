package com.coding.main_screen_impl

import cafe.adriel.voyager.core.screen.Screen

internal class MainScreenImpl : MainScreenApi {
    override fun mainScreen(): Screen = MainScreen()
}