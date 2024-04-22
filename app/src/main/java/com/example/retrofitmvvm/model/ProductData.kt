package com.example.retrofitmvvm.model

data class ProductData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)