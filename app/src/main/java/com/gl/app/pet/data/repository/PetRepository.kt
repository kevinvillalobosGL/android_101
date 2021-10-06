package com.gl.app.pet.data.repository

import com.gl.app.pet.data.io.PetResponse

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
interface PetRepository {

    fun getPets() : PetResponse

}