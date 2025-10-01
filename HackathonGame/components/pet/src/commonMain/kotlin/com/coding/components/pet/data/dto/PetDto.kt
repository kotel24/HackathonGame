package com.coding.components.pet.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PetDto(
    val id: Int,
    val name: String,
    val age: Int,
    val exp: Int,
)