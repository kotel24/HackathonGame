package com.coding.quiz_screen_impl.quiz_screen

import com.coding.mvi_koin_voyager.MviModel
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenAction
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenEffect
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenEvent
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenState

internal class QuizScreenModel(
    tag: String
) : MviModel<QuizScreenAction, QuizScreenEffect, QuizScreenEvent, QuizScreenState>(
    defaultState = QuizScreenState,
    tag = tag
) {
    override suspend fun actor(action: QuizScreenAction) {
        when (action) {
            is QuizScreenAction.ClickButtonToMainScreen -> {
                push(QuizScreenEvent.NavigateToMainScreen)
            }
        }
    }
}