package com.coding.onboarding.onboarding_impl.onboarding.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun OnboardingContent(
    onClickToMainScreen: () -> Unit
) {
    MaterialTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
            ) {
                Text(
                    text = "This is onboarding"
                )
                Button(
                    onClick = onClickToMainScreen,
                    content = {
                        Text(
                            text = "Click"
                        )
                    }
                )
            }
        }
    }
}