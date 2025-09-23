package com.coding.main_screen_impl.main_screen

import com.coding.main_screen_impl.main_screen.mvi.MainScreenAction
import com.coding.main_screen_impl.main_screen.mvi.MainScreenEffect
import com.coding.main_screen_impl.main_screen.mvi.MainScreenEvent
import com.coding.main_screen_impl.main_screen.mvi.MainScreenState
import com.coding.mvi_koin_voyager.MviModel

internal class MainScreenModel(
    tag: String
) : MviModel<MainScreenAction, MainScreenEffect, MainScreenEvent, MainScreenState>(
    defaultState = MainScreenState,
    tag = tag,
) {

    override suspend fun actor(action: MainScreenAction) =
        when (action) {
            MainScreenAction.ClickButtonExample -> TODO()
        }
}