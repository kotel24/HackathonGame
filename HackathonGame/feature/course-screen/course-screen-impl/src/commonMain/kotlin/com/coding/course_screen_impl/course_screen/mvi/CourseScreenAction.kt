package com.coding.course_screen_impl.course_screen.mvi

import com.coding.mvi_general.MviAction

internal sealed interface CourseScreenAction : MviAction {
    data object ClickButtonToMainScreen : CourseScreenAction
}