package com.gl.app.pet.data.repository

import com.gl.app.pet.data.api.LocalJsonHelper
import com.gl.app.pet.data.io.PetResponse

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
class PetRepositoryImpl : PetRepository{

    override fun getPets(): PetResponse {
        return LocalJsonHelper.getFromFile("pets.json")
    }
}