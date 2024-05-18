package com.example.retrofitmvvm.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val model: DetailsModel) : ViewModel() {

    private val _product: MutableStateFlow<Product?> = MutableStateFlow(null)
    val product: StateFlow<Product?> = _product

    private fun getProduct(id: Int) {
        viewModelScope.launch {
            _product.value = model.getProduct(id)
        }
    }
}