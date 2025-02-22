package com.example.testmvvm.view.Categories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmvvm.R
import com.example.testmvvm.model.MealListener
import com.example.testmvvm.model.FavoriteMeal

class CategoryAdapter (var mealList: List<FavoriteMeal>, var movieListener: MealListener,)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private lateinit var context: Context

    class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val mealName: TextView = item.findViewById(R.id.tv_CategoryName)
        val mealImage: ImageView = item.findViewById(R.id.iv_category)
        val addToFavBtn: Button = item.findViewById(R.id.btn_add_fav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentMeal = mealList[position]
        holder.mealName.text = currentMeal.strCategory

        Glide.with(holder.itemView.context)
            .load(currentMeal.strCategoryThumb)
            .into(holder.mealImage)

        holder.addToFavBtn.setOnClickListener {
            movieListener.onMealClick(currentMeal)
        }
    }

    override fun getItemCount(): Int = mealList.size
}