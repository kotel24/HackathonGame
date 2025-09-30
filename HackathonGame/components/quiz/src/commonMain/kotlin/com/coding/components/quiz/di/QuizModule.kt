package com.coding.components.quiz.di

import com.coding.components.quiz.data.api.QuizApi
import com.coding.components.quiz.data.api.QuizApiImpl
import com.coding.components.quiz.data.repository.QuizRepositoryImpl
import com.coding.components.quiz.domain.repostory.QuizRepository
import com.coding.components.quiz.domain.usecase.GetQuestionsUseCase
import com.coding.components.quiz.domain.usecase.GetQuestionsUseCaseImpl
import org.koin.dsl.module

val quizModule
    get() = module {
        single<QuizApi> { QuizApiImpl(get()) }
        single<QuizRepository> { QuizRepositoryImpl(get()) }
        single<GetQuestionsUseCase> { GetQuestionsUseCaseImpl(get()) }
    }