package com.example.chucknorrisjokes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.chucknorrisjokes.Constants.categories
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.addFragment
import com.example.chucknorrisjokes.models.JokesDataModel
import com.example.chucknorrisjokes.network_request.DataLoader
import com.example.xmlparsing.network_request.FutureCallbackRandomJokesBridge
import kotlinx.android.synthetic.main.activity_jokes_show.*

class ShowJokesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes_show)
        init()
        choseCategory_Button_ID.setOnClickListener {
            val intent = Intent(baseContext, MarkJokeCategoryActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }
    private fun init() {
        val category = if (intent.getStringExtra("categoryID")=="random") null else intent.getStringExtra("categoryID")
        getByCategory(category)
        random_Button_ID.apply {
            setOnClickListener {
            getByCategory(category)
                tag = if (tag=="true") {
                    setBackgroundResource(R.mipmap.random_icon_invert)
                    "false"
                }else{
                    setBackgroundResource(R.mipmap.random_icon)
                    "true"
                }
            }
        }

        favorite_Button_ID.apply {
            setOnClickListener {
                tag = if (tag=="true") {
                    setBackgroundResource(R.drawable.ic_heart_unchecked)
                    "false"
                }else{
                    setBackgroundResource(R.drawable.ic_heart_checked)
                    "true"
                }
            }
        }
        choseCategory_Button_ID.apply {


        }

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