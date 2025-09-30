package com.coding.quiz_screen_impl.quiz_screen.mvi

import com.coding.components.quiz.domain.model.Question
import com.coding.mvi_general.MviState

internal data class QuizScreenState(
    val questions: List<Question>,
    val currentIndex: Int,
    val selectedIndex: Int?,
    val correctCount: Int,
    val isFinished: Boolean,
) : MviState {
    companion object {
        val DEFAULT = QuizScreenState(
            questions = emptyList(),
            currentIndex = 0,
            selectedIndex = null,
            correctCount = 0,
            isFinished = false,
        )
    }
}