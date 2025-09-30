package com.coding.quiz_screen_impl.quiz_screen.mvi

import com.coding.mvi_general.MviAction

internal sealed interface QuizScreenAction : MviAction {
    object ClickButtonBackToMainScreen : QuizScreenAction
    data class SelectAnswer(val index: Int) : QuizScreenAction
    object ClickNext : QuizScreenAction
    object ClickRestart : QuizScreenAction
}