package com.example.testmvvm.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmvvm.model.FavoriteMeal
import com.example.testmvvm.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealRepository) : ViewModel() {

    // LiveData for categories fetched from API
    private val _categories = MutableLiveData<List<FavoriteMeal>>()
    val categories: LiveData<List<FavoriteMeal>> get() = _categories

    // LiveData for favorite meals (from Room Database)
    val favoriteMeals: LiveData<List<FavoriteMeal>> = repository.getFavoriteMeals()

    // LiveData for loading state
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    // LiveData for messages (to show Toasts, etc.)
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    // Fetch categories from API
    fun fetchMeals() {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.fetchMeals()
                _categories.postValue(result ?: emptyList())
            } catch (e: Exception) {
                _message.postValue("Error fetching categories")
            } finally {
                _loading.postValue(false)
            }
        }
    }

    // Add meal to favorites
    fun addMealToFavorites(meal: FavoriteMeal) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.addMealToFavorites(meal)
            if (result > 0) {
                _message.postValue("Added to Favorites: ${meal.strCategory}")
            } else {
                _message.postValue("${meal.strCategory} is already in Favorites")
            }
        }
    }

    // Remove meal from favorites
    fun removeMealFromFavorites(meal: FavoriteMeal) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeMealFromFavorites(meal)
            _message.postValue("Removed from Favorites: ${meal.strCategory}")
        }
    }
}