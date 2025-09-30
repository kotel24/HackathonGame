package com.coding.quiz_screen_impl

import com.coding.mvi_koin_voyager.provideMviModel
import com.coding.quiz_screen_api.QuizScreenApi
import com.coding.quiz_screen_impl.quiz_screen.QuizScreen
import com.coding.quiz_screen_impl.quiz_screen.QuizScreenModel
import org.koin.dsl.module

val quizScreenModule
    get() = module {
        provideMviModel<QuizScreen> { tag, _ -> QuizScreenModel(tag, get()) }
        single<QuizScreenApi> { QuizScreenImpl() }
    }