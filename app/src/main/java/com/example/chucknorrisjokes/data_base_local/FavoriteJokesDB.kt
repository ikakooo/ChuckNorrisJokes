package com.example.chucknorrisjokes.data_base_local

import androidx.room.*

@Database(entities = [RoomFavoriteJokesModel::class], version = 1)
abstract class FavoriteJokesDB: RoomDatabase(){
    abstract fun favoriteDaoConnection() : FavoriteJokesDao
}