package com.coding.quiz_screen_impl.quiz_screen.mvi

import com.coding.mvi_general.MviAction

internal sealed interface QuizScreenAction : MviAction {
    data class ClickButtonToMainScreen(val name: String) : QuizScreenAction
}