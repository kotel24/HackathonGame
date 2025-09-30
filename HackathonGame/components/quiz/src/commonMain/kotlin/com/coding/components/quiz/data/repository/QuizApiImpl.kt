package com.coding.components.quiz.data.repository

import com.coding.components.quiz.data.api.QuizApi
import com.coding.components.quiz.data.dto.QuestionDto
import com.coding.components.quiz.data.mapper.toDomain
import com.coding.components.quiz.domain.model.Question
import com.coding.components.quiz.domain.repostory.QuizRepository

internal class QuizRepositoryImpl(
    private val quizApi: QuizApi,
) : QuizRepository {

    override suspend fun getQuestions(): Result<List<Question>> = quizApi
        .getQuestions()
        .map { list -> list.map(QuestionDto::toDomain) }
}