package com.coding.quiz_screen_impl.quiz_screen.mvi

import com.coding.mvi_general.MviEvent

internal sealed interface QuizScreenEvent : MviEvent {
    data object NavigateToBack : QuizScreenEvent
}