package com.coding.main_screen_impl.main_screen.compose.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.braveowlet.simple_mvi_example.core.resources.Res
import ru.braveowlet.simple_mvi_example.core.resources.bear

// ---------- PetInfo с прогрессом ----------
@Composable
fun PetInfo(
    petName: String,
    status: String,
    progress: Float // от 0f до 1f, из БД
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
            val targetSweep = remember(progress) { 300f * progress.coerceIn(0f, 1f) }
            val animatedSweep = remember { Animatable(0f) }

            LaunchedEffect(targetSweep) {
                animatedSweep.animateTo(
                    targetValue = targetSweep,
                    animationSpec = tween(durationMillis = 800)
                )
            }

            Canvas(modifier = Modifier.size(size)) {
                val strokeWidth = (12.dp).toPx()

                // Единственная дуга прогресса с анимацией
                drawArc(
                    color = AppColors.ProgressBarFg,
                    startAngle = 270f,
                    sweepAngle = animatedSweep.value,
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
        }
    }
}
