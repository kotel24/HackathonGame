package com.coding.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.coding.core.settings.CheckOnboardingCompletedUseCase
import com.coding.main_screen_api.MainScreenApi
import com.coding.onboarding.onboarding_api.OnboardingApi
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val checkOnboardingUseCase = koinInject<CheckOnboardingCompletedUseCase>()
            val mainScreenFeatureApi = koinInject<MainScreenApi>()
            val onboardingFeatureApi = koinInject<OnboardingApi>()

            val isOnboardingCompleted by produceState<Boolean?>(initialValue = null) {
                value = checkOnboardingUseCase()
            }
            MaterialTheme {
                when (isOnboardingCompleted) {
                    null -> {
                        // пока заглушка надо заменить TODO()
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }
                    true -> {
                        Navigator(mainScreenFeatureApi.mainScreen())
                    }
                    false -> {
                        Navigator(onboardingFeatureApi.onboardingScreen())
                    }
                }
            }
        }
    }
}