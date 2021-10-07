package com.gl.app.pet.ui.main.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gl.app.pet.data.model.Pet
import com.gl.app.pet.databinding.ItemPetCardBinding
import com.squareup.picasso.Picasso

/**
 * @author Kevin Villalobos
 * @since 10/6/21
 */
class HomeItemAdapter(private val callback: (Pet) -> Unit) :
    RecyclerView.Adapter<HomeItemAdapter.HomeItemViewHolder>() {

    private var petList: List<Pet> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addPets(newPets: List<Pet>) {
        petList = newPets
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        // Layout Inflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // Create ViewHolder
        val binding = ItemPetCardBinding.inflate(layoutInflater, parent, false)
        return HomeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        val pet = petList[position]
        holder.bind(pet, callback)
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    class HomeItemViewHolder(
        private val mBinding: ItemPetCardBinding
    ) : RecyclerView.ViewHolder(mBinding.root) {

        fun bind(pet: Pet, callback: (Pet) -> Unit) {
            mBinding.mPet = pet
            mBinding.executePendingBindings()
            // Load the Image
            Picasso.get().load(pet.petImage).into(mBinding.imvPet)

            // Set Click Listener
            mBinding.itemContainer.setOnClickListener {
                callback(pet)
            }
        }

    }

}