package com.thoriq.geming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.thoriq.geming.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        binding.WalkButton.setOnClickListener {view:View->view.findNavController().navigate(R.id.action_menuFragment_to_gameplayFragment)}
        return binding.root
    }

}