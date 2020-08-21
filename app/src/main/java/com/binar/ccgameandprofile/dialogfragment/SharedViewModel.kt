package com.binar.ccgameandprofile.dialogfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel(): ViewModel() {
    val id = MutableLiveData<Int>()
    val tanggal = MutableLiveData<String>()
    val isiMemo = MutableLiveData<String>()

    fun setId(input: Int) {
        id.value = input
    }
    fun getId(): Int? {
        return id.value?.toInt()
    }

    fun setTanggal(input: String) {
        tanggal.value = input
    }
    fun getTanggal(): String {
        return tanggal.value.toString()
    }

    fun setIsi(input: String) {
        isiMemo.value = input
    }
    fun getIsi(): String {
        return isiMemo.value.toString()
    }
}