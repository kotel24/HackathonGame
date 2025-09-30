package com.coding.components.quiz.domain.usecase

import com.coding.components.quiz.domain.model.Question
import com.coding.components.quiz.domain.repostory.QuizRepository

interface GetQuestionsUseCase {
    suspend operator fun invoke(): Result<List<Question>>
}

internal class GetQuestionsUseCaseImpl(
    private val quizRepository: QuizRepository
) : GetQuestionsUseCase {

    override suspend fun invoke(): Result<List<Question>> =
        quizRepository.getQuestions()
}