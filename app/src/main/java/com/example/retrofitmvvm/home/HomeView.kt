package com.example.retrofitmvvm.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitmvvm.model.Product
import com.example.retrofitmvvm.model.ProductData

@Composable
fun HomeView(viewModel: MainViewModel) {

    val productsData = viewModel.products.collectAsState().value
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    LazyColumn {
        if (productsData != null) {
            items(productsData.products.size) {
                ProductItem(product = productsData.products[it])
            }
        }
    }

    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
            viewModel.searchProduct(searchText.text)
        },
        placeholder = { Text("Search") },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {


            Text(text = product.title, fontSize = 20.sp)

            Text(text = product.price.toString(), fontSize = 16.sp)
        }

    }
}