package com.thoriq.geming.`class`

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class simpan:ViewModel() {
    val selected = MutableLiveData<Orang>()

    fun select(item: Orang) {
        selected.value = item
    }

}