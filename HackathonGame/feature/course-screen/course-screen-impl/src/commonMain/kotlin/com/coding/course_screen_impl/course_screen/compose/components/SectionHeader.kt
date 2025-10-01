package com.coding.course_screen_impl.course_screen.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coding.course_screen_impl.course_screen.model.SectionStatus

val SectionHeaderColor = Color(0xFF42A5F5)
val SectionItemCompletedColor = Color(0xFF64B5F6)
val SectionItemNotCompletedColor = Color(0xFF9E9E9E)
val BackgroundColor = Color(0xFF424242)
val TextColor = Color.White

val ScreenHorizontalPadding = 16.dp
val HeaderIconSize = 24.dp
val HeaderIconSpacing = 12.dp
val HeaderStartInset = ScreenHorizontalPadding + HeaderIconSize + HeaderIconSpacing

@Composable
fun SectionHeader(
    title: String,
    status: SectionStatus
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = ScreenHorizontalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val icon = when (status) {
            SectionStatus.COMPLETED -> Icons.Filled.CheckCircle
            SectionStatus.IN_PROGRESS -> Icons.Filled.Circle
            SectionStatus.NOT_STARTED -> Icons.Filled.Circle
        }

        Icon(
            imageVector = icon,
            contentDescription = when (status) {
                SectionStatus.COMPLETED -> "Completed"
                SectionStatus.IN_PROGRESS -> "In progress"
                SectionStatus.NOT_STARTED -> "Not started"
            },
            tint = TextColor,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(HeaderIconSpacing))

        val textColor = if (status == SectionStatus.COMPLETED || status == SectionStatus.IN_PROGRESS) Color.White else Color(0xFF1919EF)
        val containerColor = if (status == SectionStatus.COMPLETED || status == SectionStatus.IN_PROGRESS) Color(0xFF6088E4) else Color.White

        Row(
            modifier = Modifier
                .background(containerColor, RoundedCornerShape(12.dp))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = textColor,
                fontSize = 18.sp,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight
            )
        }
    }
}
