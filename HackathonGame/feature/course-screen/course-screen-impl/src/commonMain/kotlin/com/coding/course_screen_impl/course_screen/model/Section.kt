package com.coding.course_screen_impl.course_screen.model

data class Section(
    val title: String,
    val items: List<Item>,
    val status: SectionStatus
)
