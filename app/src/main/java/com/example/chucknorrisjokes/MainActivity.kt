package com.example.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.chucknorrisjokes.models.JokesDataModel
import com.example.chucknorrisjokes.network_request.DataLoader
import com.example.xmlparsing.network_request.FutureCallbackRandomJokesBridge
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init() {
        getRandomJoke()
    }


    private fun getRandomJoke() {
        DataLoader.getRequestRandomJokes(object : FutureCallbackRandomJokesBridge{
            override fun onResponse(response: JokesDataModel) {
                Text_viewID.text = response.value
            }

            override fun onFailure(error: String) {
                Log.d("dsfdfsdf", error)
            }

        })
    }
}