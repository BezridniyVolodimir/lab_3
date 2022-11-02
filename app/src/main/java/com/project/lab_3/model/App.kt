package com.project.lab_3.model

import com.project.lab_3.AdapterInterface

data class App(
    val id: Int = 0,
    val name: String? = null,
    val price: Int = 0,
    val developer: String? = null
) : AdapterInterface {

    override fun getType(): Int {
        return AdapterInterface.APP_TYPE
    }
}