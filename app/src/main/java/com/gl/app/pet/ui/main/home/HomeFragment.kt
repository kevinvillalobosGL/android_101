package com.gl.app.pet.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gl.app.pet.R
import com.gl.app.pet.data.model.Pet
import com.gl.app.pet.databinding.FragmentHomeBinding
import com.gl.app.pet.ui.main.details.DetailsFragment


class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    private val mViewModel = HomeViewModel()
    private val mAdapter = HomeItemAdapter(::onPetClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the Binding for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Setup RecyclerView
        mBinding.rvPets.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        // Get Pets
        mAdapter.addPets(mViewModel.getPets())
    }

    private fun onPetClick(pet: Pet) {
        val bundle = bundleOf(DetailsFragment.PET_ARG to pet)
        findNavController().navigate(R.id.fragment_details, bundle)
    }
}