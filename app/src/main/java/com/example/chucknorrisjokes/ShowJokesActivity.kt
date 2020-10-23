package com.example.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.chucknorrisjokes.Constants.categories
import com.example.chucknorrisjokes.models.JokesDataModel
import com.example.chucknorrisjokes.network_request.DataLoader
import com.example.xmlparsing.network_request.FutureCallbackRandomJokesBridge
import kotlinx.android.synthetic.main.activity_jokes_show.*

class ShowJokesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes_show)
        val myButton = findViewById<TextView>(R.id.Text_viewID)
        init()
    }
    private fun init() {
        getByCategory(categories[7])
    }
    private  fun getByCategory(categoriesString:String?){
        DataLoader.getRequestJokeByCategory(categoriesString,object :FutureCallbackRandomJokesBridge{
            override fun onResponse(response: JokesDataModel) {
                Text_viewID.text = response.value
            }
            override fun onFailure(error: String) {
                Log.d("dsfdrewfsdf", error)
            }
        })
    }
}