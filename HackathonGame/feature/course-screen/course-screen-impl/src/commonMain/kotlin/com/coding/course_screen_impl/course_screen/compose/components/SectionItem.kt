package com.coding.course_screen_impl.course_screen.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coding.course_screen_impl.course_screen.model.Item

@Composable
fun SectionItem(
    item: Item
) {
    val backgroundColor = if (item.isCompleted) SectionItemCompletedColor else SectionItemNotCompletedColor
    Text(
        text = item.title,
        color = TextColor,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = HeaderStartInset, end = ScreenHorizontalPadding, top = 4.dp, bottom = 4.dp)
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(10.dp)
    )
}