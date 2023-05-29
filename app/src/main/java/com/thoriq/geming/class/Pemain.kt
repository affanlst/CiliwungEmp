package com.thoriq.geming.`class`

import kotlin.random.Random

open class Pemain(private var hp:Int,private var minAtt:Int,private var maxAtt: Int) {
    fun GetHp():Int{
        return hp
    }
    fun SetHp(hp:Int){
        this.hp = hp
    }
    fun finalAtt():Int{
        return Random.nextInt(minAtt,maxAtt)
    }
}