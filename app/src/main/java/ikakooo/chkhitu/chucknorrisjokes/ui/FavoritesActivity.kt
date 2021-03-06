package ikakooo.chkhitu.chucknorrisjokes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ikakooo.chkhitu.chucknorrisjokes.R

import ikakooo.chkhitu.chucknorrisjokes.data_base_local.DatabaseBuilder.roomDB
import ikakooo.chkhitu.chucknorrisjokes.data_base_local.RoomFavoriteJokesModel
import ikakooo.chkhitu.chucknorrisjokes.ui.reciclerview_halper.FavoriteAdapter
import ikakooo.chkhitu.chucknorrisjokes.ui.reciclerview_halper.ItemClickListener
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

        favorites_RecyclerView_ID.apply {
            favouritesAdapter = FavoriteAdapter(favouritesJokesList,
                object : ItemClickListener {
                    override fun viewClicked(position: Int) {
                        val favouritesJoke = favouritesJokesList[position]
                        //აქ იშლება აითემ კლიკზე აითემის წაშლა
                        roomDB.favoriteDaoConnection().deleteFavoriteJoke(favouritesJoke.JokeID)
                        favouritesJokesList.removeAt(position)
                        favouritesAdapter.notifyItemRemoved(position)
                    }

                })
            layoutManager = LinearLayoutManager(context)
            adapter = favouritesAdapter
        }

        itemChange()
    }
    fun itemChange(){
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
    }
}