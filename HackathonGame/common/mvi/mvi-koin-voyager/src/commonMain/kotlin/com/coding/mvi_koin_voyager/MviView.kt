package com.coding.mvi_koin_voyager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.coding.common.utils.simpleNameOrThrow
import com.coding.mvi_general.MviAction
import com.coding.mvi_general.MviEvent
import com.coding.mvi_general.MviState
import kotlinx.coroutines.flow.Flow
import org.koin.core.qualifier.named

interface MviView<Action : MviAction, Event : MviEvent, State : MviState> : Screen {

    @Composable
    override fun Content() {
        val model = getMviModel<MviModel<Action, *, Event, State>>()
        val state by model.stateFlow.collectAsState()
        content(
            state = state,
            eventFlow = model.eventFlow,
            pushAction = model::push
        )
    }

    @Composable
    fun content(
        state: State,
        eventFlow: Flow<Event>,
        pushAction: (Action) -> Unit,
    )
}

@Composable
private inline fun <reified T : MviModel<*, *, *, *>> MviView<*, *, *>.getMviModel(): T =
    getScreenModel<T>(qualifier = named(this::class.simpleNameOrThrow))

@Composable
inline fun <reified Event : MviEvent> Flow<Event>.collectEvent(
    crossinline onEvent: suspend (Event) -> Unit,
) = LaunchedEffect(Unit) { collect { onEvent(it) } }