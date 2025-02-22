package com.example.testmvvm

import androidx.lifecycle.LiveData
import com.example.testmvvm.model.FavoriteMeal
import com.example.testmvvm.model.db.FavoriteMealDao
import com.example.testmvvm.model.server.RetrofitClient

class MealRepository(private val dao: FavoriteMealDao) {

    suspend fun fetchMeals(): List<FavoriteMeal>? {
        val response = RetrofitClient.favServiceObj.getCategories()
        return response.body()?.categories
    }

    fun getFavoriteMeals(): LiveData<List<FavoriteMeal>> = dao.getAllFavorites()

    suspend fun addMealToFavorites(meal: FavoriteMeal): Long {
        return dao.addCategory(meal)
    }

    suspend fun removeMealFromFavorites(meal: FavoriteMeal): Int {
        return dao.removeCategory(meal)
    }
}