package com.coding.course_screen_impl.course_screen.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.arrow_2
import ru.braveowlet.simple_mvi_example.core.resources.g1
import ru.braveowlet.simple_mvi_example.core.resources.menu
import ru.braveowlet.simple_mvi_example.core.resources.your_digital_friend
import ru.braveowlet.simple_mvi_example.core.resources.your_friend

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onClickBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(Res.drawable.g1),
                    contentDescription = "Лого",

                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(Res.drawable.your_friend),
                    contentDescription = "Лого",
                    modifier = Modifier
                        .size(200.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onClickBack) {
                Icon(
                    painter = painterResource(Res.drawable.arrow_2),
                    contentDescription = "Назад",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black
        ),
        windowInsets = TopAppBarDefaults.windowInsets
    )
}