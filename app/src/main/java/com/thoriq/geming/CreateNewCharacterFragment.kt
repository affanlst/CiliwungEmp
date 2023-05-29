package com.thoriq.geming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.thoriq.geming.`class`.Orang
import com.thoriq.geming.`class`.Pemain
import com.thoriq.geming.`class`.simpan
import com.thoriq.geming.databinding.FragmentCreateNewCharacterBinding

class CreateNewCharacterFragment : Fragment() {
    private val vm: simpan by activityViewModels()
    lateinit var binding:FragmentCreateNewCharacterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateNewCharacterBinding.inflate(layoutInflater)
        binding.CreateButton.setOnClickListener{chooseCharacter()}
        return binding.root
    }
    fun chooseCharacter():Unit? {
        val tipePemain = when (binding.CharOption.checkedRadioButtonId) {
            R.id.Fighter -> Orang(10,1,3)
            R.id.Mage -> Orang(5,3,7)
            R.id.Swordsman -> Orang(7,3,5)
            R.id.Marksman -> Orang(5,3,6)
            else ->
                Orang(10,1,2)
        }
        vm.selected.value=tipePemain
        return view?.findNavController()?.navigate(R.id.action_createNewCharacterFragment_to_menuFragment)
    }
}
