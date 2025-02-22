package com.example.testmvvm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testmvvm.view.Categories.CategoriesActivity
import com.example.testmvvm.view.Favorite.FavoriteActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.button_all).setOnClickListener {
            startActivity(Intent(this, CategoriesActivity::class.java))
        }
        findViewById<Button>(R.id.button_fav).setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }
        findViewById<Button>(R.id.button_exit).setOnClickListener {
            finish()
        }
    }
}