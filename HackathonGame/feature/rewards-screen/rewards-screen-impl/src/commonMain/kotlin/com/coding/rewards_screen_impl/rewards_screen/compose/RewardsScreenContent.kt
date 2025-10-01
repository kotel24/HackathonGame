package com.coding.rewards_screen_impl.rewards_screen.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RewardsScreenContent(
    wonRewards: List<Reward>,
    availableRewards: List<Reward>,
    onRewardClick: (Reward) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Мои призы",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        RewardList(
            rewards = wonRewards,
            onRewardClick = onRewardClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Можно выиграть",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        RewardList(
            rewards = availableRewards,
            onRewardClick = onRewardClick
        )
    }
}