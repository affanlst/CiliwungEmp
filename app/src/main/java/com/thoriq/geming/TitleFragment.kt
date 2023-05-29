package com.thoriq.geming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.thoriq.geming.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    lateinit var binding: FragmentTitleBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTitleBinding.inflate(layoutInflater)

        binding.playButton.setOnClickListener  { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_createNewCharacterFragment)
        }
        return binding.root
    }
}



