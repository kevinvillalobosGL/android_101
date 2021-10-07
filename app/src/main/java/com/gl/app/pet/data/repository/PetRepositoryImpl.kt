package com.gl.app.pet.data.repository

import com.gl.app.pet.data.api.PetService
import com.gl.app.pet.data.api.ServiceFactory
import com.gl.app.pet.data.io.PetResponse

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
class PetRepositoryImpl(
    private val petService: PetService = ServiceFactory.getPetService()
) : PetRepository {

    override suspend fun getPets(): PetResponse {
        return petService.getPets()
    }
}