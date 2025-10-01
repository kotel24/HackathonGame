package com.coding.rewards_screen_impl

import com.coding.rewards_screen_api.RewardsScreenApi
import com.coding.mvi_koin_voyager.provideMviModel
import com.coding.rewards_screen_impl.rewards_screen.RewardsScreen
import com.coding.rewards_screen_impl.rewards_screen.RewardsScreenModel
import org.koin.dsl.module

val rewardsScreenModule
    get() = module {
        // Регистрируем модель для RewardsScreen
        provideMviModel<RewardsScreen> { tag, _ ->
            RewardsScreenModel(
                tag
            )
        }

        // Экспортируем API экрана
        single<RewardsScreenApi> { RewardsScreenImpl() }
    }