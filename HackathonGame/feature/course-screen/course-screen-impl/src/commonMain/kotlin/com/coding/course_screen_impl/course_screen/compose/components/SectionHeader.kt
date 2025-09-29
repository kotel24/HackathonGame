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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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

@Composable
fun SectionHeader(
    title: String,
    status: SectionStatus
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(SectionHeaderColor, RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (status) {
            SectionStatus.COMPLETED -> Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Completed",
                tint = TextColor,
                modifier = Modifier.size(24.dp)
            )
            SectionStatus.IN_PROGRESS -> Checkbox(
                checked = false,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(uncheckedColor = TextColor),
                modifier = Modifier.size(24.dp)
            )
            SectionStatus.NOT_STARTED -> Checkbox(
                checked = false,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(uncheckedColor = TextColor),
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            color = TextColor,
            fontSize = 18.sp,
            fontWeight = MaterialTheme.typography.titleMedium.fontWeight
        )
    }
}
