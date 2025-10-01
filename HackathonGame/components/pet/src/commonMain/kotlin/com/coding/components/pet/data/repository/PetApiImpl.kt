package com.coding.components.pet.data.repository

import com.coding.components.pet.data.api.PetApi
import com.coding.components.pet.data.dto.PetDto
import com.coding.components.pet.data.mapper.toDomain
import com.coding.components.pet.domain.model.Pet
import com.coding.components.pet.domain.repository.PetRepository

internal class PetRepositoryImpl(
    private val petApi: PetApi,
) : PetRepository {

    override suspend fun getPet(): Result<Pet> = petApi
        .getPet()
        .map ( PetDto::toDomain )
}