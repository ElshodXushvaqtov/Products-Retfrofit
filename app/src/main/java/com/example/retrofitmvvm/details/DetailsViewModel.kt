package com.example.retrofitmvvm.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val model: DetailsModel,val id:Int) : ViewModel() {

    private val _product: MutableStateFlow<Product?> = MutableStateFlow(null)
    val product: StateFlow<Product?> = _product

    init {
        getProduct()
    }

    private fun getProduct() {
        viewModelScope.launch {
            _product.value = model.getProduct(id)
        }
    }
}