package com.thoriq.geming

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.thoriq.geming.`class`.Lawan
import com.thoriq.geming.`class`.Orang
import com.thoriq.geming.`class`.Pemain
import com.thoriq.geming.`class`.simpan
import com.thoriq.geming.databinding.FragmentGameplayBinding
import kotlin.random.Random

class GameplayFragment : Fragment() {
    private val vm: simpan by activityViewModels()
    lateinit var binding:FragmentGameplayBinding
    data class dataLawan(
        val text: String,
        val answers: Lawan)

    lateinit var player:Orang
    var isAttack = true

    val lawans: MutableList<dataLawan> = mutableListOf(
        dataLawan("Goblin", Lawan(10,1,2)),
        dataLawan("Boss", Lawan(5,1,9)),
        dataLawan("Elf",Lawan(10,3,5)),
        dataLawan("Slime",Lawan(1,0,1)),
        dataLawan("Centaur",Lawan(10,2,3))
    )
    val index = lawans.random()
    val enemy = index.answers
    val enemyName = index.text

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameplayBinding.inflate(layoutInflater)
        player = vm.selected.value!!
        binding.textHpPlayer.text = player.GetHp().toString()
        binding.textHpLawan.text = enemy.GetHp().toString()
        binding.enemyTextName.text = enemyName
        binding.playerTextName.text = getString(R.string.you)
        binding.progressBar.max = player.GetHp()
        binding.progressBar.progress = player.GetHp()
        binding.progressBar2.max = enemy.GetHp()
        binding.progressBar2.progress = enemy.GetHp()
        binding.button.setOnClickListener{Serang()}
        return binding.root
    }

    fun Serang(){

        object : CountDownTimer(1000, 1000) {
            override fun onFinish() {
                enemy.GotAttack(player)
                isAttack = false
                val text: TextView = binding.textHpLawan
                Toast.makeText(context, "Kamu Menyerang", Toast.LENGTH_SHORT).show()
                text.text = enemy.GetHp().toString()
                binding.progressBar2.progress = enemy.GetHp()
                statusCheck()
                Diserang()
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
        binding.button.isEnabled = false

    }
    fun Diserang(){
        Toast.makeText(context, "Anda Diserang", Toast.LENGTH_SHORT).show()
        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                player.GotAttack(enemy)
                isAttack = true
                val text: TextView = binding.textHpPlayer
                val text2: TextView = binding.enemyTextName
                text.text = player.GetHp().toString()
                text2.text = enemyName
                binding.progressBar.progress = player.GetHp()
                binding.textHpPlayer.text = "${player.GetHp()}"
                binding.button.isEnabled = true
                statusCheck()
            }
        }.start()
    }
    fun statusCheck(){
        if (player.GetHp()<=0){
            view?.findNavController()?.navigate(R.id.action_gameplayFragment_to_loseFragment)
        }
        if(enemy.GetHp()<=0){ view?.findNavController()?.navigate(R.id.action_gameplayFragment_to_winFragment)}
    }
}


