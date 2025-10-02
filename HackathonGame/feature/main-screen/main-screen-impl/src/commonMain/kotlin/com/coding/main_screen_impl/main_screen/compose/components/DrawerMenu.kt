package com.coding.main_screen_impl.main_screen.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// ---------- DrawerMenu (Row) ----------
@Composable
fun DrawerMenu(onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 4.dp), // тоньше
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf("Игры", "Награды", "Мини-игры", "Профиль").forEach { item ->
            TextButton(
                onClick = { onItemClick(item) },
                modifier = Modifier
                    .border(3.dp, Color.White, RoundedCornerShape(50))
                    .padding(horizontal = 8.dp)
            ) {
                Text(item, color = Color.White)
            }
        }
    }
}