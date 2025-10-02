package com.coding.theory_screen_impl.theory_screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.coding.mvi_koin_voyager.MviView
import com.coding.mvi_koin_voyager.collectEvent
import com.coding.theory_screen_impl.theory_screen.compose.TheoryScreenContent
import com.coding.theory_screen_impl.theory_screen.mvi.TheoryAction
import com.coding.theory_screen_impl.theory_screen.mvi.TheoryEvent
import com.coding.theory_screen_impl.theory_screen.mvi.TheoryState
import kotlinx.coroutines.flow.Flow

internal class TheoryScreen : MviView<TheoryAction, TheoryEvent, TheoryState> {
    @Composable
    override fun content(
        state: TheoryState,
        eventFlow: Flow<TheoryEvent>,
        pushAction: (TheoryAction) -> Unit
    ) {
        val navigator = LocalNavigator.currentOrThrow

        eventFlow.collectEvent { event ->
            when (event) {
                is TheoryEvent.NavigateToDetail -> {
                    // тут можно будет открыть экран с подробной статьёй
                }
            }
        }

        TheoryScreenContent(
            state = state,
            onArticleClick = { id -> pushAction(TheoryAction.OnArticleClick(id)) }
        )
    }
}