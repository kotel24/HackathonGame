package com.coding.course_screen_impl.course_screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coding.course_screen_impl.course_screen.compose.components.BackgroundColor
import com.coding.course_screen_impl.course_screen.compose.components.SectionGroup
import com.coding.course_screen_impl.course_screen.model.Section

@Composable
fun CourseScreenContent(
    sections: List<Section>
) {
    MaterialTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .background(BackgroundColor)
                    .verticalScroll(rememberScrollState())
            ) {
                sections.forEach { section ->
                    SectionGroup(section = section)
                    Spacer(modifier = Modifier
                        .height(16.dp)
                    )
                }
            }
        }
    }
}