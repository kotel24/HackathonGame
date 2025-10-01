package com.coding.main_screen_impl.main_screen.mvi

import com.coding.mvi_general.MviState
import com.coding.components.pet.domain.model.Pet

internal data class MainScreenState(
    val pet: Pet?
) : MviState {
    companion object {
        val DEFAULT = MainScreenState(
            pet = null
        )
    }
}