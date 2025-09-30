package com.coding.components.quiz.data.api

import com.coding.components.quiz.data.dto.QuestionDto
import com.coding.core.network.fetchForGet
import io.ktor.client.HttpClient

internal interface QuizApi {
    suspend fun getQuestions(): Result<List<QuestionDto>>
}

internal class QuizApiImpl(
    private val httpClient: HttpClient
) : QuizApi {

    override suspend fun getQuestions(): Result<List<QuestionDto>> =
        // TODO()
        httpClient.fetchForGet<List<QuestionDto>>("https://")
}