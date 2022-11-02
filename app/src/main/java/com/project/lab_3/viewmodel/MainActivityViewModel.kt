package com.project.lab_3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.lab_3.AdapterInterface
import com.project.lab_3.model.App
import com.project.lab_3.model.Game

class MainActivityViewModel : ViewModel() {
    private val _items = MutableLiveData<ArrayList<AdapterInterface>>()
    val items: LiveData<ArrayList<AdapterInterface>> = _items

    fun loadItems() {
        val list = ArrayList<AdapterInterface>()
        list.add(Game(0, "Black and White", 140, "PW Studio", " falling block puzzle game"))
        list.add(
            Game(
                1,
                "Battlefield 1",
                600,
                "EA DICE",
                "First Person Shooter, Massively Multiplayer"
            )
        )
        list.add(App(1, "Splitwise", 0, "SPD Ukraine"))
        list.add(App(3, "Google Maps", 0, "Google"))
        _items.value = list
    }
}