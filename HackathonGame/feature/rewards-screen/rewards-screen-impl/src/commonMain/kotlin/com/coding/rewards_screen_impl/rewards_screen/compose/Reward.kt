package com.coding.rewards_screen_impl.rewards_screen.compose

data class Reward(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,   // пока можно картинку из drawable
    val isWon: Boolean
)
