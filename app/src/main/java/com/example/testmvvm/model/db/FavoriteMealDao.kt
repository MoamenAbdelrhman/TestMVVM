package com.example.testmvvm.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testmvvm.model.FavoriteMeal

@Dao
interface FavoriteMealDao {
    @Query("SELECT * FROM favorite_table")
    fun getAllFavorites(): LiveData<List<FavoriteMeal>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCategory(meal: FavoriteMeal): Long

    @Delete
    suspend fun removeCategory(meal: FavoriteMeal):Int
}
