package com.example.retrofitmvvm.api

import com.example.retrofitmvvm.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProducts():List<Product>
}