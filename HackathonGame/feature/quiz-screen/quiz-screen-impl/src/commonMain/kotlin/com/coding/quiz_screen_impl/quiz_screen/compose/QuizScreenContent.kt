package com.coding.quiz_screen_impl.quiz_screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.coding.quiz_screen_impl.quiz_screen.mvi.QuizScreenState
import org.jetbrains.compose.resources.painterResource
import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.arrow_2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun QuizScreenContent(
    state: QuizScreenState,
    onBackClick: () -> Unit,
    onSelectAnswer: (Int) -> Unit,
    onNext: () -> Unit,
    onRestart: () -> Unit,
) {
    MaterialTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Викторина") },
                    navigationIcon = {
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.arrow_2),
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
                )
            }
        ) { innerPadding ->
            QuizStep(
                state = state,
                contentPadding = innerPadding,
                onSelectAnswer = onSelectAnswer,
                onNext = onNext,
                onRestart = onRestart
            )
        }
    }
}

@Composable
private fun QuizStep(
    state: QuizScreenState,
    contentPadding: PaddingValues,
    onSelectAnswer: (Int) -> Unit,
    onNext: () -> Unit,
    onRestart: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.White)
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = contentPadding.calculateTopPadding() + 8.dp,
                bottom = contentPadding.calculateBottomPadding() + 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        when {
            state.isFinished -> {
                Text(
                    text = "Результат: ${state.correctCount} из ${state.questions.size}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
                Button(onClick = onRestart, modifier = Modifier.fillMaxWidth()) {
                    Text("Заново")
                }
            }

            state.questions.isEmpty() -> {
                Text(text = "Загрузка вопросов...", style = MaterialTheme.typography.titleMedium)
            }

            else -> {
                val current = state.questions[state.currentIndex]
                Text(
                    text = "Вопрос ${state.currentIndex + 1} из ${state.questions.size}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = current.question,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
                current.variants.forEachIndexed { index, variant ->
                    val selected = state.selectedIndex == index
                    if (selected) {
                        Button(
                            onClick = { onSelectAnswer(index) },
                            modifier = Modifier.fillMaxWidth()
                        ) { Text(variant) }
                    } else {
                        OutlinedButton(
                            onClick = { onSelectAnswer(index) },
                            modifier = Modifier.fillMaxWidth()
                        ) { Text(variant) }
                    }
                }
                val isLast = state.currentIndex == state.questions.lastIndex
                Button(
                    onClick = onNext,
                    enabled = state.selectedIndex != null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) { Text(if (isLast) "Завершить" else "Далее") }
            }
        }
    }
}
