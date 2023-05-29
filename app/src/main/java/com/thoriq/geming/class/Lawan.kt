package com.thoriq.geming.`class`


class Lawan(hp: Int,minAtt:Int, maxAtt: Int):Pemain(hp, minAtt, maxAtt) {
    fun GotAttack(att:Orang){
        SetHp(this.GetHp()-att.finalAtt())
    }
}