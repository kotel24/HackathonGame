package com.coding.main_screen_impl

import cafe.adriel.voyager.core.screen.Screen
import com.coding.main_screen_api.MainScreenApi
import com.coding.main_screen_impl.main_screen.MainScreen

internal class MainScreenImpl : MainScreenApi {
    override fun mainScreen(): Screen = MainScreen()
}