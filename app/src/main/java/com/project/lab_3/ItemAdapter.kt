package com.project.lab_3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.lab_3.databinding.ItemAppBinding
import com.project.lab_3.databinding.ItemGameBinding
import com.project.lab_3.model.App
import com.project.lab_3.model.Game

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list = ArrayList<AdapterInterface>()

    class ItemGameHolder(
        private val binding: ItemGameBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(game: AdapterInterface) = with(binding) {
            game as Game
            gameName.text = game.name
            gamePrice.text = game.price.toString()
            gameInfo.text = " Developer: " + game.developer + " Genres: " + game.genres

            onClick()
            onLongClick()
        }

        fun onClick() {
            binding.root.setOnClickListener {

            }
        }

        fun onLongClick() {
            binding.root.setOnLongClickListener {
                return@setOnLongClickListener true
            }
        }
    }

    class ItemAppHolder(
        private val binding: ItemAppBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(app: AdapterInterface) = with(binding) {
            app as App
            appName.text = app.name
            appPrice.text = app.price.toString()
            appInfo.text = " Developer: " + app.developer

            onClick()
            onLongClick()
        }

        fun onClick() {
            binding.root.setOnClickListener {

            }
        }

        fun onLongClick() {
            binding.root.setOnLongClickListener {
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            AdapterInterface.GAME_TYPE -> {
                val binding = ItemGameBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ItemGameHolder(binding)
            }
            AdapterInterface.APP_TYPE -> {
                val binding = ItemAppBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ItemAppHolder(binding)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].getType()) {
            AdapterInterface.GAME_TYPE ->
                (holder as ItemGameHolder).bind(list[position])
            AdapterInterface.APP_TYPE ->
                (holder as ItemAppHolder).bind(list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].getType()
    }

    override fun getItemCount() = list.size

    fun setList(listUser: ArrayList<AdapterInterface>) {
        list = listUser
    }
}