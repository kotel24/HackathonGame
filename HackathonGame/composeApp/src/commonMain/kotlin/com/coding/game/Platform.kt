package com.coding.game

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform