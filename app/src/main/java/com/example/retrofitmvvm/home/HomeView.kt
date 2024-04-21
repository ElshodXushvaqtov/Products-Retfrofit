package com.example.retrofitmvvm.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitmvvm.model.Product

@Composable
fun HomeView(viewModel: MainViewModel) {
    val products = viewModel.products.collectAsState().value

    LazyColumn {
        if (products != null) {
            items(products.size) {
                ProductItem(product = products[it])
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(modifier = Modifier.fillMaxWidth()) {

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