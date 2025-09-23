package com.coding.main_screen_impl.main_screen.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import org.jetbrains.compose.resources.stringResource
import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.main_screen_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreenContent(
    onClickButton: () -> Unit,
) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(Res.string.main_screen_title))
                    },
                )
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "This is main screen with pet"
                )
            }
        }
    }
}