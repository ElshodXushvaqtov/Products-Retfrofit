package com.example.retrofitmvvm.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.model.ProductData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val model:HomeModel) : ViewModel() {
    private val _products: MutableStateFlow<ProductData?> = MutableStateFlow(null)
    val products:StateFlow<ProductData?> = _products



   private fun getProducts() {
        viewModelScope.launch {
           _products.value = model.getAllProducts()
        }
    }

   fun searchProduct(name:String){
       viewModelScope.launch {
           _products.value = model.searchProducts(name)
       }
   }

    init {
        getProducts()
    }
}