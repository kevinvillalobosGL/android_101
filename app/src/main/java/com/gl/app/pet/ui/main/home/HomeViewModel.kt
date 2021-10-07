package com.gl.app.pet.ui.main.home

import androidx.lifecycle.ViewModel
import com.gl.app.pet.data.model.Pet
import com.gl.app.pet.data.repository.PetRepository
import com.gl.app.pet.data.repository.PetRepositoryImpl

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
class HomeViewModel(private val petRepository: PetRepository = PetRepositoryImpl()) : ViewModel() {

    suspend fun getPets(): List<Pet> {
        return petRepository.getPets()
    }
}