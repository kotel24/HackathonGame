package com.coding.course_screen_impl

import cafe.adriel.voyager.core.screen.Screen
import com.coding.course_screen_impl.course_screen.CourseScreen
import com.coding.featue.course_screen_api.CourseScreenApi

internal class CourseScreenImpl : CourseScreenApi {
    override fun courseScreen(): Screen = CourseScreen()
}