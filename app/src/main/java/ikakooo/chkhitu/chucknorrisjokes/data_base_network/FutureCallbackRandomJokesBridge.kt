package com.example.xmlparsing.network_request

import ikakooo.chkhitu.chucknorrisjokes.models.JokesDataModel


interface FutureCallbackRandomJokesBridge {
    fun onResponse(response: JokesDataModel)
    fun onFailure(error: String)
}