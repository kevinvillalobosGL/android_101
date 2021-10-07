package com.gl.app.pet.data.api

import com.gl.app.pet.data.io.PetResponse
import retrofit2.http.GET

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
interface PetService {

    @GET("pets")
    suspend fun getPets(): PetResponse

}