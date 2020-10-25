package com.example.chucknorrisjokes.data_base_network

import android.util.Log
import com.example.chucknorrisjokes.Constants.BASE_URL_JOKES
import com.example.chucknorrisjokes.models.JokesDataModel
import com.example.xmlparsing.network_request.FutureCallbackRandomJokesBridge
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DataLoader {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_JOKES)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(APIService::class.java)


    fun getRequestJokeByCategory(
        category: String?,
        callback: FutureCallbackRandomJokesBridge

    ) {
        val call = service.getJokeByCategory(category)
        call.enqueue(object : Callback<JokesDataModel> {
            override fun onFailure(call: Call<JokesDataModel>, t: Throwable) {
                callback.onFailure(t.message.toString())
                Log.d("topTodayonFailure", t.message.toString())
            }

            override fun onResponse(
                call: Call<JokesDataModel>,
                response: Response<JokesDataModel>
            ) {
                response.body()?.let { callback.onResponse(it) }
                Log.d("topTodayonResponse", response.body().toString())
            }

        })
    }


}