package com.example.retrofitmvvm.api

import com.example.retrofitmvvm.model.Product
import com.example.retrofitmvvm.model.ProductData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/products")
    suspend fun getProducts():ProductData

    @GET("/products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product

    @GET("/products/search")
    suspend fun searchByName(@Query("q") name: String): ProductData
}