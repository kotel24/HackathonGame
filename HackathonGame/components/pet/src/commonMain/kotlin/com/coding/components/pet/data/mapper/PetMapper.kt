package com.coding.components.pet.data.mapper

import com.coding.components.pet.data.dto.PetDto
import com.coding.components.pet.domain.model.Pet

internal fun PetDto.toDomain(): Pet = Pet(
    id = this.id,
    name = this.name,
    age = this.age,
    exp = this.exp
)