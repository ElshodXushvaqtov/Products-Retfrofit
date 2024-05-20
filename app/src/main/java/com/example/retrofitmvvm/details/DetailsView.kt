package com.example.retrofitmvvm.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsView(viewModel: DetailsViewModel) {

    val item by viewModel.product.collectAsState()


    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        if (item != null) {
            Text(
                text = item!!.title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = item!!.description, fontSize = 15.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = item!!.price.toString()+" $",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = Bold
            )
        }
    }

}