package com.example.chucknorrisjokes.data_base_network


import com.example.chucknorrisjokes.models.JokesDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("random")
    fun getJokeByCategory( @Query("category") category: String?): Call<JokesDataModel>
}