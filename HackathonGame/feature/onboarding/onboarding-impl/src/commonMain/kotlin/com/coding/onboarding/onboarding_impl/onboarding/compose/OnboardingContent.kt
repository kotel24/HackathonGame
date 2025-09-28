package com.coding.onboarding.onboarding_impl.onboarding.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun OnboardingContent(
    onClickToMainScreen: (String) -> Unit
) {
    val pagerState = rememberPagerState { PAGES.size + 1 }
    val scope = rememberCoroutineScope()

    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                                page = PAGES[pageIndex],
                                scope = scope
                            )
                        }
                        else -> {
                            LastPage(
                                onNameSubmitted = onClickToMainScreen
                            )
                        }
                    }
                }

                PageIndicator(
                    pagerState = pagerState,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        }
    }
}