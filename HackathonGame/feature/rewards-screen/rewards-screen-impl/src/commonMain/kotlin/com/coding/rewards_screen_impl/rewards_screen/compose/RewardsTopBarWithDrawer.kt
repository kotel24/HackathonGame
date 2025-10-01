package com.coding.rewards_screen_impl.rewards_screen.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.arrow_2
import ru.braveowlet.simple_mvi_example.core.resources.logo1
import ru.braveowlet.simple_mvi_example.core.resources.menu

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RewardsTopBarWithDrawer(
    onMenuItemClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    var menuVisible by remember { mutableStateOf(false) }

    Column {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    // Стрелка назад
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(Res.drawable.arrow_2),
                            contentDescription = "Назад",
                            tint = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.width(50.dp))
                    Image(
                        painter = painterResource(Res.drawable.logo1),
                        contentDescription = "Лого",
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        "Ваш цифровой друг",
                        fontSize = 18.sp,
                        color = AppColors.TopBarContent
                    )
                }
            },
            actions = {
                IconButton(onClick = { menuVisible = !menuVisible }) {
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

        // DrawerMenu с двумя кнопками
        AnimatedVisibility(visible = menuVisible) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("Полученные", "Можно выиграть").forEach { item ->
                    TextButton(
                        onClick = {
                            onMenuItemClick(item)
                            menuVisible = false
                        },
                        modifier = Modifier
                            .border(1.dp, Color.DarkGray, RoundedCornerShape(50))
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(item, color = Color.Black)
                    }
                }
            }
        }
    }
}