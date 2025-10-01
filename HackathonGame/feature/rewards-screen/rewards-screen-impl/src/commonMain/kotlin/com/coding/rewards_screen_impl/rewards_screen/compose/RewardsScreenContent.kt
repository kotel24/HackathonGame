package com.coding.rewards_screen_impl.rewards_screen.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RewardsScreenContent(
    wonRewards: List<Reward>,
    availableRewards: List<Reward>,
    onRewardClick: (Reward) -> Unit,
    onBackClick: () -> Unit
) {
    var selectedList by remember { mutableStateOf("Полученные") }

    Column(modifier = Modifier.fillMaxSize()) {
        RewardsTopBarWithDrawer(
            onBackClick = onBackClick, // пробрасываем клик назад
            onMenuItemClick = { selected -> selectedList = selected }
        )

        Spacer(modifier = Modifier.height(8.dp))

        val rewardsToShow = when (selectedList) {
            "Полученные" -> wonRewards
            "Можно выиграть" -> availableRewards
            else -> wonRewards
        }

        RewardList(rewards = rewardsToShow, onRewardClick = onRewardClick)
    }
}