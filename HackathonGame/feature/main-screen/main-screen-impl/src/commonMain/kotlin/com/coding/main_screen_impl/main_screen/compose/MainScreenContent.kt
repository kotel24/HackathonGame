package com.coding.main_screen_impl.main_screen.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.coding.main_screen_impl.main_screen.compose.components.ActionButtons
import com.coding.main_screen_impl.main_screen.compose.components.AppColors
import com.coding.main_screen_impl.main_screen.compose.components.AppDimens
import com.coding.main_screen_impl.main_screen.compose.components.DrawerMenu
import com.coding.main_screen_impl.main_screen.compose.components.MainTopBar
import com.coding.main_screen_impl.main_screen.compose.components.PetInfo


// ---------- MainScreenContent ----------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(
    petName: String,
    status: String,
    progress: Float = 0.6f, // прогресс (например 60%), будет приходить из БД
    onCourseClick: () -> Unit = {},
    onDailyTasksClick: () -> Unit = {}
) {
    var menuVisible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().background(AppColors.Background)) {
        // TopBar
        MainTopBar {
            menuVisible = !menuVisible
        }

        // Drawer под TopAppBar
        AnimatedVisibility(visible = menuVisible) {
            DrawerMenu { item ->
                menuVisible = false
                // обработка клика
            }
        }

        // Контент
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(AppDimens.Padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PetInfo(petName, status, progress)
            ActionButtons(
                onCourseClick = onCourseClick,
                onDailyTasksClick = onDailyTasksClick
            )
        }
    }
}