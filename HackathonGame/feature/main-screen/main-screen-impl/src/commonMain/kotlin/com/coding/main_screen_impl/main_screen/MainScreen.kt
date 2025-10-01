package com.coding.main_screen_impl.main_screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.coding.featue.course_screen_api.CourseScreenApi
import com.coding.main_screen_impl.main_screen.compose.MainScreenContent
import com.coding.main_screen_impl.main_screen.mvi.MainScreenAction
import com.coding.main_screen_impl.main_screen.mvi.MainScreenEvent
import com.coding.main_screen_impl.main_screen.mvi.MainScreenState
import com.coding.mvi_koin_voyager.MviView
import com.coding.mvi_koin_voyager.collectEvent
import com.coding.quiz_screen_api.QuizScreenApi
import com.coding.rewards_screen_api.RewardsScreenApi
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject

internal class MainScreen : MviView<MainScreenAction, MainScreenEvent, MainScreenState> {

    @Composable
    override fun content(
        state: MainScreenState,
        eventFlow: Flow<MainScreenEvent>,
        pushAction: (MainScreenAction) -> Unit
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val courseScreenApi = koinInject<CourseScreenApi>()
        // delete it later
        val quizScreenApi = koinInject<QuizScreenApi>()
        val rewardsScreenApi = koinInject<RewardsScreenApi>()

        eventFlow.collectEvent { event ->
            when (event) {
                MainScreenEvent.NavigateToCourseScreen -> {
                    //navigator.push(courseScreenApi.courseScreen())
                    //navigator.push(quizScreenApi.quizScreen())
                    navigator.push(rewardsScreenApi.rewardsScreen())
                }
            }
        }

        MainScreenContent(
            onCourseClick = {
                pushAction(MainScreenAction.ClickButtonOnCourse)
            },
            onDailyTasksClick = {}
        )
    }
}