package com.example.chucknorrisjokes.data_base_local

import androidx.room.Room
import com.example.chucknorrisjokes.AppRoot

object DatabaseBuilder {
    val roomDB by lazy {
        Room.databaseBuilder(
            AppRoot.instance.getContext(),
            FavoriteJokesDB::class.java,
            "TopJokes.roomDB"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

}