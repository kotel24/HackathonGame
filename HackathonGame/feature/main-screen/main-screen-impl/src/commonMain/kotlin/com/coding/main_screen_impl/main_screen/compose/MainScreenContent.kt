package com.coding.main_screen_impl.main_screen.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.bear
import ru.braveowlet.simple_mvi_example.core.resources.logo
import ru.braveowlet.simple_mvi_example.core.resources.menu

// ---------- Стили ----------
object AppDimens {
    val Padding = 16.dp
    val PetImageSize = 180.dp
    val PetCircleSize = 300.dp
}

object AppColors {
    val Background = Color(0xFF2E2E2E)
    val TopBar = Color.White
    val TopBarContent = Color.Black
    val PetName = Color.White
    val PetStatus = Color.LightGray
    val ButtonPrimaryBg = Color.LightGray
    val ButtonPrimaryText = Color.Black
    val ButtonSecondaryBg = Color.Gray
    val ButtonSecondaryText = Color.White
    val ProgressBarBg = Color.LightGray
    val ProgressBarFg = Color.DarkGray
}

// ---------- TopAppBar ----------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Image(
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = "Лого",
                    modifier = Modifier
                        .size(118.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(AppDimens.Padding))
                Text(
                    "Ваш цифровой друг",
                    fontSize = 18.sp,
                    color = AppColors.TopBarContent
                )
            }
        },
        actions = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    painter = painterResource(Res.drawable.menu),
                    contentDescription = "Меню",
                    tint = AppColors.TopBarContent
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppColors.TopBar,
            titleContentColor = AppColors.TopBarContent
        )
    )
}

// ---------- DrawerMenu (Row) ----------
@Composable
fun DrawerMenu(onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(vertical = 4.dp), // тоньше
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf("Игры", "Награды", "Мини-игры", "Профиль").forEach { item ->
            TextButton(
                onClick = { onItemClick(item) },
                modifier = Modifier
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(50))
                    .padding(horizontal = 8.dp)
            ) {
                Text(item, color = Color.Black)
            }
        }
    }
}

// ---------- PetInfo с прогрессом ----------
@Composable
fun PetInfo(
    petName: String,
    status: String,
    streakDays: Int,
    progress: Float // теперь от 0f до 1f, из БД
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = petName,
            color = AppColors.PetName,
            fontSize = 28.sp
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = status,
            color = AppColors.PetStatus,
            fontSize = 18.sp
        )

        Spacer(Modifier.height(24.dp))

        Box(contentAlignment = Alignment.Center) {
            val size = AppDimens.PetCircleSize

            Canvas(modifier = Modifier.size(size)) {
                val strokeWidth = (12.dp).toPx()

                // Фон дуги (300°)
                drawArc(
                    color = AppColors.ProgressBarBg,
                    startAngle = 270f,
                    sweepAngle = 300f,
                    useCenter = false,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )

                // Прогресс
                val sweep = 300f * progress.coerceIn(0f, 1f)
                drawArc(
                    color = AppColors.ProgressBarFg,
                    startAngle = 270f,
                    sweepAngle = sweep,
                    useCenter = false,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
            }

            // Медведь в центре
            Image(
                painter = painterResource(Res.drawable.bear),
                contentDescription = "Питомец",
                modifier = Modifier.size(AppDimens.PetImageSize)
            )

            // Текст "xN дней" всегда в секторе 300-360°
            Box(
                modifier = Modifier
                    .size(size)
                    .padding(horizontal = 30.dp, vertical = 10.dp), // подгон позиции
                contentAlignment = Alignment.TopStart
            ) {
                Surface(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(100)
                ) {
                    Text(
                        text = "x$streakDays дней",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

// ---------- Кнопки действий ----------
@Composable
fun ActionButtons(
    onCourseClick: () -> Unit,
    onDailyTasksClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(32.dp))

        Button(
            onClick = onCourseClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.ButtonPrimaryBg,
                contentColor = AppColors.ButtonPrimaryText
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("ИЗУЧАТЬ")
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onDailyTasksClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.ButtonSecondaryBg,
                contentColor = AppColors.ButtonSecondaryText
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("ежедневные задания")
        }
    }
}

// ---------- MainScreenContent ----------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(
    petName: String = "Имя питомца",
    status: String = "Статус",
    streakDays: Int = 5,
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
            PetInfo(petName, status, streakDays, progress)
            ActionButtons(
                onCourseClick = onCourseClick,
                onDailyTasksClick = onDailyTasksClick
            )
        }
    }
}