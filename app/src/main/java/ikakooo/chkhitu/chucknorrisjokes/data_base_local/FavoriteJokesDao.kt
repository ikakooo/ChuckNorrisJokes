package ikakooo.chkhitu.chucknorrisjokes.data_base_local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteJokesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoomFavoriteJokesModel(favorite_Jokes: RoomFavoriteJokesModel)

    @Query("select * from Favorite_Jokes")
    fun getFavoriteJokes(): List<RoomFavoriteJokesModel>

    @Query("delete from Favorite_Jokes where JokeID = :id")
    fun deleteFavoriteJoke(id: String)

    @Query("Select * from Favorite_Jokes where JokeID =  :id")
    fun isFavoriteJoke(id: String): RoomFavoriteJokesModel
}


