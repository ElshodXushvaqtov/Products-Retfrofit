package com.example.retrofitmvvm.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val model:HomeModel) : ViewModel() {
    private val _products: MutableStateFlow<List<Product>?> = MutableStateFlow(null)
    val products:StateFlow<List<Product>?> = _products

   private fun getProducts() {
        viewModelScope.launch {
           _products.value = model.getAllProducts()
        }
    }

    init {
        getProducts()
    }
}