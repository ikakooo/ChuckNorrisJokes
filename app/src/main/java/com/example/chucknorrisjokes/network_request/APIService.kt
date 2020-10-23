package com.example.chucknorrisjokes.network_request


import com.example.chucknorrisjokes.models.JokesDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("random")
    fun getJokeByCategory( @Query("category") category: String?): Call<JokesDataModel>
}