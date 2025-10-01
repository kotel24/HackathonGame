package com.coding.onboarding.onboarding_impl.onboarding.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun OnboardingContent(
    onClickToMainScreen: (String) -> Unit
) {
    val pagerState = rememberPagerState { PAGES.size + 1 }

    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF6088E4))
                    .padding(paddingValues)
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .weight(1f)
                        .statusBarsPadding()
                ) { pageIndex ->
                    when {
                        pageIndex < PAGES.size -> {
                            DefaultPage(
                                pagerState = pagerState,
                                page = PAGES[pageIndex]
                            )
                        }
                        else -> {
                            LastPage(
                                pagerState = pagerState,
                                onNameSubmitted = onClickToMainScreen
                            )
                        }
                    }
                }
            }
        }
    }
}