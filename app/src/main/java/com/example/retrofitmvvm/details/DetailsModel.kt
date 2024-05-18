package com.example.retrofitmvvm.details

import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.model.Product

class DetailsModel(private val api: ApiService) {

    suspend fun getProduct(id: Int): Product {
        return api.getProduct(id)
    }

}