package com.coding.theory_screen_impl

import com.coding.theory_screen_api.TheoryScreenApi
import com.coding.mvi_koin_voyager.provideMviModel
import com.coding.theory_screen_impl.theory_screen.TheoryScreen
import com.coding.theory_screen_impl.theory_screen.TheoryScreenModel
import org.koin.dsl.module

val theoryScreenModule = module {
    provideMviModel<TheoryScreen> { tag, _ ->
        TheoryScreenModel(tag)
    }

    single<TheoryScreenApi> { TheoryScreenImpl() }
}