package com.example.retrofitmvvm.home

import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.model.ProductData

class HomeModel(private val api: ApiService) {
    suspend fun getAllProducts(): ProductData {
        return api.getProducts()
    }

    suspend fun searchProducts(productName:String): ProductData{
        return api.searchByName(productName)
    }
}