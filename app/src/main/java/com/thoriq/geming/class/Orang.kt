package com.thoriq.geming.`class`

class Orang(hp: Int, minAtt: Int, maxAtt: Int): Pemain(hp, minAtt, maxAtt) {
    fun GotAttack(att:Lawan){
        SetHp(this.GetHp()-att.finalAtt())
    }
}