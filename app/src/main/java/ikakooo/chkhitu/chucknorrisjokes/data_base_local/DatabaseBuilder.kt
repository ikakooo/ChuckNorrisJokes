package ikakooo.chkhitu.chucknorrisjokes.data_base_local

import androidx.room.Room
import ikakooo.chkhitu.chucknorrisjokes.AppRoot

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