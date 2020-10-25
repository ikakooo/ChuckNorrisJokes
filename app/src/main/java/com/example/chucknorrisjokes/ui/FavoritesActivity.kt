package com.example.chucknorrisjokes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.data_base_local.DatabaseBuilder.roomDB
import com.example.chucknorrisjokes.data_base_local.RoomFavoriteJokesModel
import com.example.chucknorrisjokes.ui.reciclerview_halper.FavoriteAdapter
import com.example.chucknorrisjokes.ui.reciclerview_halper.ItemClickListener
import kotlinx.android.synthetic.main.activity_favorites.*

class FavoritesActivity : AppCompatActivity() {
    private var favouritesJokesList = mutableListOf<RoomFavoriteJokesModel>()
    private lateinit var favouritesAdapter: FavoriteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        init()
    }

    private fun init() {


        favouritesJokesList.clear()
        val dB = roomDB.favoriteDaoConnection().getFavoriteJokes().toMutableList()
        dB.forEach {
            favouritesJokesList.add(
                RoomFavoriteJokesModel(
                    JokeID = it.JokeID,
                    JokeString = it.JokeString
                )
            )
        }
        favouritesAdapter.notifyDataSetChanged()


        favorites_RecyclerView_ID.apply {
            favouritesAdapter = FavoriteAdapter(favouritesJokesList,
                object : ItemClickListener {
                    override fun viewClicked(position: Int) {
                        val favouritesMovie = favouritesJokesList[position]
                        //aq und moxdes waShla
                    }

                })
            layoutManager = LinearLayoutManager(context)
            adapter = favouritesAdapter
        }
    }
}