package com.coding.onboarding.onboarding_impl.onboarding.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastPage(
    pagerState: PagerState,
    onNameSubmitted: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Введите имя питомца",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,

        )

        Spacer(modifier = Modifier.height(70.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(
                    "Введите имя",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                errorContainerColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Black,
                errorTextColor = Color.Black,
                cursorColor = Color.Black,
                focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f)
            ),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(70.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(12.dp),
                    ambientColor = Color.Black.copy(alpha = 0.2f),
                    spotColor = Color.Black.copy(alpha = 0.2f)
                )
        )

        Spacer(modifier = Modifier.height(70.dp))

        Button(
            onClick = {
                if (name.isNotBlank()) {
                    onNameSubmitted(name.trim())
                } else {
                    isError = true
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1919EF)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 0.dp),
            enabled = name.isNotBlank() && name.length >= 3
        ) {
            Text(
                text = "Завершить",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        // Индикатор страниц прямо над кнопкой
        PageIndicator(pagerState = pagerState)

        // Небольшой отступ между индикатором и кнопкой
        Spacer(modifier = Modifier.height(48.dp))
    }
}