package com.example.chucknorrisjokes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.data_base_local.DatabaseBuilder.roomDB
import com.example.chucknorrisjokes.data_base_local.RoomFavoriteJokesModel
import com.example.chucknorrisjokes.models.JokesDataModel
import com.example.chucknorrisjokes.data_base_network.DataLoader
import com.example.xmlparsing.network_request.FutureCallbackRandomJokesBridge
import kotlinx.android.synthetic.main.activity_jokes_show.*

class ShowJokesActivity : AppCompatActivity() {
    private var isFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes_show)
        init()
        choseCategory_Button_ID.setOnClickListener {
            val intent = Intent(baseContext, MarkJokeCategoryActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        favorite_ImageView_ID.setOnClickListener {
            startActivity(Intent(baseContext, FavoritesActivity::class.java))
        }
    }

    private fun init() {
        val category = if (intent.getStringExtra("categoryID") == "random") null else intent.getStringExtra("categoryID")
        getByCategory(category)
        random_Button_ID.apply {
            setOnClickListener {
                getByCategory(category)
                favorite_Button_ID.isInFavorite()
                tag = if (tag == "true") {
                    setBackgroundResource(R.mipmap.random_icon_invert)
                    "false"
                } else {
                    setBackgroundResource(R.mipmap.random_icon)
                    "true"
                }
            }
        }
        choseCategory_Button_ID.apply {

        }

    }


    private fun getByCategory(categoriesString: String?) {
        DataLoader.getRequestJokeByCategory(categoriesString,
            object : FutureCallbackRandomJokesBridge {
                override fun onResponse(response: JokesDataModel) {
                    Text_viewID.text = response.value
                    favorite_Button_ID.apply {
                        isInFavorite(response)
                        setOnClickListener {
                            favoriteOnClickChanging(response)
                        }
                    }
                }

                override fun onFailure(error: String) {
                    Log.d("dsfdrewfsdf", error)
                }
            })
    }


    fun ImageButton.favoriteOnClickChanging(response: JokesDataModel? = null) {
        isFavourite = if (isFavourite) {
            response?.let { roomDB.favoriteDaoConnection().deleteFavoriteJoke(it.id) }
            setBackgroundResource(R.drawable.ic_heart_unchecked)
            false
        } else {
            response?.let {
                roomDB.favoriteDaoConnection().insertRoomFavoriteJokesModel(
                    RoomFavoriteJokesModel(
                        JokeID = it.id,
                        JokeString = it.value
                    )
                )
            }
            setBackgroundResource(R.drawable.ic_heart_checked)
            true
        }
    }

    fun ImageButton.isInFavorite(response: JokesDataModel? = null) {
        val favorite = response?.let { roomDB.favoriteDaoConnection().isFavoriteJoke(it.id) }
        isFavourite = if (favorite == null) {
            setBackgroundResource(R.drawable.ic_heart_unchecked)
            false
        } else {
            setBackgroundResource(R.drawable.ic_heart_checked)
            true
        }
    }
}