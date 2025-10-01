package com.coding.main_screen_impl.main_screen.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// ---------- Кнопки действий ----------
@Composable
fun ActionButtons(
    onCourseClick: () -> Unit,
    onPrizesClick: () -> Unit
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
            onClick = onPrizesClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.ButtonSecondaryBg,
                contentColor = AppColors.ButtonSecondaryText
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("ежедневные призы")
        }
    }
}