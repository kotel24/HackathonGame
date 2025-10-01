package com.coding.main_screen_impl.main_screen.mvi

import com.coding.components.pet.domain.model.Pet
import com.coding.mvi_general.MviEffect

internal sealed interface MainScreenEffect : MviEffect {
    data class SetPet(val pet: Pet) : MainScreenEffect
    data object ShowDialogDailyTasks : MainScreenEffect
}