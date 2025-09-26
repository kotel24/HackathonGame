package com.coding.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import cafe.adriel.voyager.navigator.Navigator
import com.coding.main_screen_api.MainScreenApi
import com.coding.onboarding.onboarding_api.OnboardingApi
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val mainScreenFeatureApi = koinInject<MainScreenApi>()
            val onboardingFeatureApi = koinInject<OnboardingApi>()
            MaterialTheme {
                Navigator(
                    onboardingFeatureApi.onboardingScreen()
                )
            }
        }
    }
}