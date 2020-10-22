package com.example.chucknorrisjokes.network_request


import com.example.chucknorrisjokes.models.JokesDataModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("random")
    fun getExchangeRates(): Call<JokesDataModel>

    @GET("random")
    fun getJokeByCategory(): Call<JokesDataModel>
}