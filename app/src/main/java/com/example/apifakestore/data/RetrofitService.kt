package com.example.apifakestore.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/products/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    suspend fun getProductsJewelery(): List<ProductResponse> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(ApiService::class.java).getProductsByCategories("category/jewelery")
            response.body() ?: emptyList()
        }

    }
}