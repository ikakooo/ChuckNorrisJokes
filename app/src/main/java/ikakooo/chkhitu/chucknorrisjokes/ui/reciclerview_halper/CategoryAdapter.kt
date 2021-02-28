package ikakooo.chkhitu.chucknorrisjokes.ui.reciclerview_halper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ikakooo.chkhitu.chucknorrisjokes.R
import kotlinx.android.synthetic.main.category_layout.view.*


class CategoryAdapter(private val favourites: MutableList<String>, val clickingListener: ItemClickListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun getItemCount(): Int = favourites.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var model:String

        fun onBind() {
            model = favourites[adapterPosition]
            itemView.Category_TextView_ID.text = model.capitalize()
            //Glide.with(itemView.context).load(BASE_IMG_URL + model.path).into(itemView.moviesImageViewID)
            itemView.setOnClickListener {
                clickingListener.viewClicked(adapterPosition)
            }
        }
    }
}