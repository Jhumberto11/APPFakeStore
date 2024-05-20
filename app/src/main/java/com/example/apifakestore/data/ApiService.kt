package com.example.apifakestore.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getProductsByCategories(@Url url:String):Response<List<ProductResponse>>

}