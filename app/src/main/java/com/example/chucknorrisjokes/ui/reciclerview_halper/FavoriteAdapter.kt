package com.example.chucknorrisjokes.ui.reciclerview_halper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.data_base_local.RoomFavoriteJokesModel
import kotlinx.android.synthetic.main.joke_layout.view.*


class FavoriteAdapter(private val favourites: MutableList<RoomFavoriteJokesModel>, val clickingListener: ItemClickListener) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    override fun getItemCount(): Int = favourites.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.joke_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var model:RoomFavoriteJokesModel

        fun onBind() {
            model = favourites[adapterPosition]
            itemView.JokeTextView_ID.text = model.JokeString
            itemView.setOnClickListener {
                clickingListener.viewClicked(adapterPosition)
            }
        }
    }
}