package com.example.testmvvm.view.Categories

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.testmvvm.MealRepository
import com.example.testmvvm.viewModel.MyFactory
import com.example.testmvvm.model.MealListener
import com.example.testmvvm.model.db.FavoriteDatabase
import com.example.testmvvm.model.FavoriteMeal
import com.example.testmvvm.model.db.FavoriteMealDao
import com.example.testmvvm.R
import com.example.testmvvm.viewModel.MealViewModel


class CategoriesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter
    lateinit var progressBar : ProgressBar
    lateinit var dao : FavoriteMealDao
    private lateinit var viewModel: MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_all_categories)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.rv_meals)
        progressBar = findViewById(R.id.progress_bar_loading)
        adapter = CategoryAdapter(listOf(), object : MealListener {
            override fun onMealClick(meal: FavoriteMeal) {
                viewModel.addMealToFavorites(meal)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)

        dao = FavoriteDatabase.getDatabase(this).favoriteMealDao()
        val repository = MealRepository(dao)
        val factory = MyFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MealViewModel::class.java]
          
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.categories.observe(this, Observer {
            progressBar.visibility = View.GONE
            adapter.mealList = it
            adapter.notifyDataSetChanged()
        })

        viewModel.loading.observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.message.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}