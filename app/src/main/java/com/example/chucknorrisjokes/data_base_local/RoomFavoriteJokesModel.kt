package com.example.chucknorrisjokes.data_base_local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite_Jokes")
data class RoomFavoriteJokesModel (
    @PrimaryKey(autoGenerate = true) val id : Long?=null,
    @ColumnInfo(name = "JokeID") val JokeID:String,
    @ColumnInfo(name = "JokeString") val JokeString:String
)