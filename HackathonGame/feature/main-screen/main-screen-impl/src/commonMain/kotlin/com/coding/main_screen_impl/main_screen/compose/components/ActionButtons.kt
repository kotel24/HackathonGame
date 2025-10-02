package com.coding.main_screen_impl.main_screen.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// ---------- Кнопки действий ----------
@Composable
fun ActionButtons(
    onCourseClick: () -> Unit,
    onPrizesClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(32.dp))

        val primaryButtonGradient = Brush.linearGradient(
            colors = listOf(Color(0xFF58FFFF), Color(0xFF1919EF))
        )

        val secondaryButtonGradient = Brush.linearGradient(
            colors = listOf(Color(0xFF58FFFF), Color(0xFFDEE1EE))
        )

        Button(
            onClick = onCourseClick,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(0.5f),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(primaryButtonGradient)
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ИЗУЧАТЬ",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onPrizesClick,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(0.5f),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(secondaryButtonGradient)
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ЕЖЕДНЕВНЫЕ ПРИЗЫ",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1919EF)
                )
            }
        }
    }
}