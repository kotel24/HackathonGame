package com.coding.onboarding.onboarding_impl.onboarding.compose

import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.first_page
import ru.braveowlet.simple_mvi_example.core.resources.second_page

val PAGES = listOf(
    Page(
        imageUrl = Res.drawable.first_page,
        title = "Твой цифровой друг",
        description = "Изучай теорию и проходи тесты, чтобы растить питомца!"
    ),
    Page(
        imageUrl = Res.drawable.second_page,
        title = "Ваш прогресс",
        description = "Первый шаг к финансовой грамотности"
    )
)