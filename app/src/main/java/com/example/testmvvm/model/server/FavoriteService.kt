package com.example.testmvvm.model.server


import com.example.testmvvm.model.FavoriteResponse
import retrofit2.Response
import retrofit2.http.GET

interface FavoriteService {

    @GET("categories.php")

    suspend fun getCategories(): Response<FavoriteResponse>
}