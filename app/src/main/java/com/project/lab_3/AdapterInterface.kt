package com.project.lab_3

interface AdapterInterface {
    fun getType(): Int

    companion object{
        const val GAME_TYPE: Int = 1
        const val APP_TYPE: Int = 2
    }
}