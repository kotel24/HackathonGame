package com.coding.quiz_screen_impl.quiz_screen.mvi

import com.coding.components.quiz.domain.model.Question
import com.coding.mvi_general.MviEffect

internal sealed interface QuizScreenEffect : MviEffect {
    data class SetQuestions(val questions: List<Question>) : QuizScreenEffect
    data class AnswerSelected(val selectedIndex: Int) : QuizScreenEffect
    data class NextStep(val nextIndex: Int, val correctCount: Int, val isFinished: Boolean) : QuizScreenEffect
    data object ResetQuiz : QuizScreenEffect
}
