package com.coding.course_screen_impl.course_screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.coding.course_screen_impl.course_screen.compose.CourseScreenContent
import com.coding.course_screen_impl.course_screen.model.sampleSections
import com.coding.course_screen_impl.course_screen.mvi.CourseScreenAction
import com.coding.course_screen_impl.course_screen.mvi.CourseScreenEvent
import com.coding.course_screen_impl.course_screen.mvi.CourseScreenState
import com.coding.main_screen_api.MainScreenApi
import com.coding.mvi_koin_voyager.MviView
import com.coding.mvi_koin_voyager.collectEvent
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject

internal class CourseScreen : MviView<CourseScreenAction, CourseScreenEvent, CourseScreenState> {

    @Composable
    override fun content(
        state: CourseScreenState,
        eventFlow: Flow<CourseScreenEvent>,
        pushAction: (CourseScreenAction) -> Unit
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val mainScreenApi = koinInject<MainScreenApi>()

        eventFlow.collectEvent { event ->
            when(event) {
                CourseScreenEvent.NavigateToMainScreen ->
                    navigator.push(mainScreenApi.mainScreen())
            }
        }

        CourseScreenContent(
            sections = sampleSections
        )
    }
}