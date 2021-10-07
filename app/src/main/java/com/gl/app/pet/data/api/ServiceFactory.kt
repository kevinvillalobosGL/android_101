package com.gl.app.pet.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
object ServiceFactory {

    fun getPetService(): PetService {
        val retrofit = Retrofit.Builder()
            .baseUrl(" https://learning-challenge.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PetService::class.java)
    }

}