package com.example.retrofitmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.retrofitmvvm.api.ApiClient
import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.home.HomeModel
import com.example.retrofitmvvm.home.HomeView
import com.example.retrofitmvvm.home.HomeViewModel
import com.example.retrofitmvvm.navigation.Navigation
import com.example.retrofitmvvm.ui.theme.RetrofitMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(navHostController = navController)
                    val api = ApiClient.getInstance().create(ApiService::class.java)
                    val homeModel = HomeModel(api)
                    val homeViewModel = HomeViewModel(homeModel)
                    HomeView(viewModel = homeViewModel, navController)
                }
            }
        }
    }
}
