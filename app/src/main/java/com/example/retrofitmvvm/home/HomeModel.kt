package com.example.retrofitmvvm.home

import com.example.retrofitmvvm.api.ApiClient
import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.model.Product
import retrofit2.Retrofit

class HomeModel(private val api : ApiService){
    suspend fun getAllProducts():List<Product>{
    return api. getProducts()
    }
}