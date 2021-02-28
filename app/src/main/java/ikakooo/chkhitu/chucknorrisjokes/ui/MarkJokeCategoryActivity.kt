package ikakooo.chkhitu.chucknorrisjokes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ikakooo.chkhitu.chucknorrisjokes.Constants
import ikakooo.chkhitu.chucknorrisjokes.R
import ikakooo.chkhitu.chucknorrisjokes.ui.reciclerview_halper.CategoryAdapter
import ikakooo.chkhitu.chucknorrisjokes.ui.reciclerview_halper.ItemClickListener
import kotlinx.android.synthetic.main.activity_mark_joke_category.*

class MarkJokeCategoryActivity : AppCompatActivity() {
    private var categoryJokesList = mutableListOf<String>()
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_joke_category)
        init()
    }



    private fun init(){
        //////////რესაიქლერვიუზე აითემ კლიკ ადაპტერის მიბმა ///////////////////////////////////////
        category_RecyclerView_ID.apply {
            categoryAdapter= CategoryAdapter(categoryJokesList,object : ItemClickListener {
                override fun viewClicked(position: Int) {
                    val favouritesCategory = categoryJokesList[position]
                    val intent = Intent(context, ShowJokesActivity::class.java)
                    intent.putExtra("categoryID", favouritesCategory)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                }
            })
            layoutManager= LinearLayoutManager(context)
            adapter = categoryAdapter
        }
        Constants.categories.indices.forEach {
            categoryJokesList.addAll(listOf(Constants.categories[it].toString()))
        }
        categoryAdapter.notifyDataSetChanged()
    }
}