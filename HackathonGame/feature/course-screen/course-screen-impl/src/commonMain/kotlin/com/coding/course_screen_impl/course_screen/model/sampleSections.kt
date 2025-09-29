package com.coding.course_screen_impl.course_screen.model

val sampleSections = listOf(
    Section(
        title = "Раздел 1. Название",
        items = listOf(
            Item(id = 1, "Теория 1", false, isCompleted = true),
            Item(2, "Тестирование 1.1", false, isCompleted = true),
            Item(3, "Тестирование 1.2", true, isCompleted = true)
        ),
        status = SectionStatus.COMPLETED
    ),
    Section(
        title = "Раздел 2. Название",
        items = listOf(
            Item(4, "Теория 2", false, isCompleted = false),
            Item(5, "Тестирование 2", false, isCompleted = false)
        ),
        status = SectionStatus.IN_PROGRESS
    ),
    Section(
        title = "Раздел 3. Название",
        items = listOf(
            Item(6, "Теория 3", false, isCompleted = false),
            Item(7, "Тестирование 3.1", false, isCompleted = false),
            Item(8, "Тестирование 3.2", false, isCompleted = false)
        ),
        status = SectionStatus.NOT_STARTED
    )
)