package com.gl.app.pet.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gl.app.pet.data.model.Pet
import com.gl.app.pet.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {

    private var pet: Pet? = null
    private lateinit var mBinding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pet = arguments?.getParcelable(PET_ARG)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /// Inflate the Binding for this fragment
        mBinding = FragmentDetailsBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Bind the Pet
        pet?.let {
            mBinding.mPet = it
            mBinding.executePendingBindings()

            // Load the Image
            Picasso.get().load(it.petImage).into(mBinding.imvPet)
        }
    }

    companion object {
        const val PET_ARG = "pet"
    }
}