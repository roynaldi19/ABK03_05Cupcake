package com.roynaldi19.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.roynaldi19.cupcake.databinding.FragmentFlavorBinding
import com.roynaldi19.cupcake.model.OrderViewModel

class FlavorFragment : Fragment() {
    private var binding: FragmentFlavorBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            flavorFragment = this@FlavorFragment
        }
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}