package com.thoriq.geming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.thoriq.geming.databinding.FragmentWinBinding


class WinFragment : Fragment() {

    lateinit var binding: FragmentWinBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWinBinding.inflate(layoutInflater)
        binding.ContinueButton.setOnClickListener { view:View->view.findNavController().navigate(R.id.action_winFragment_to_menuFragment) }
        return binding.root
    }
}