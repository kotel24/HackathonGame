package com.coding.quiz_screen_impl.quiz_screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.coding.main_screen_api.MainScreenApi
import com.coding.mvi_koin_voyager.MviView
import com.coding.mvi_koin_voyager.collectEvent
import com.coding.quiz_screen_impl.quiz_screen.compose.QuizScreenContent
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenAction
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenEvent
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenState
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject

internal class QuizScreen : MviView<QuizScreenAction, QuizScreenEvent, QuizScreenState> {

    @Composable
    override fun content(
        state: QuizScreenState,
        eventFlow: Flow<QuizScreenEvent>,
        pushAction: (QuizScreenAction) -> Unit
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val mainScreenApi = koinInject<MainScreenApi>()

        eventFlow.collectEvent { event ->
            when(event) {
                QuizScreenEvent.NavigateToMainScreen ->
                    navigator.push(mainScreenApi.mainScreen())
            }
        }

        QuizScreenContent(
            state = state,
            onBackClick = { pushAction(QuizScreenAction.ClickButtonBackToMainScreen) },
            onSelectAnswer = { index: Int -> pushAction(QuizScreenAction.SelectAnswer(index)) },
            onNext = { pushAction(QuizScreenAction.ClickNext) },
            onRestart = { pushAction(QuizScreenAction.ClickRestart) }
        )
    }
}