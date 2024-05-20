package com.example.retrofitmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.retrofitmvvm.api.ApiClient
import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.details.DetailsModel
import com.example.retrofitmvvm.details.DetailsView
import com.example.retrofitmvvm.details.DetailsViewModel
import com.example.retrofitmvvm.home.HomeModel
import com.example.retrofitmvvm.home.HomeView
import com.example.retrofitmvvm.home.HomeViewModel
import com.example.retrofitmvvm.navigation.Screens
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
                    val api = ApiClient.getInstance().create(ApiService::class.java)
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screens.Home.route) {

                        composable(route = Screens.Home.route) {
                            val homeModel = HomeModel(api)
                            val homeViewModel = HomeViewModel(homeModel)
                            HomeView(viewModel = homeViewModel, navHostController = navController)
                        }
                        composable(
                            route = Screens.Details.route,
                            arguments = listOf(navArgument("key") {
                                type = NavType.IntType
                            })
                        ) {
                            val id = it.arguments?.getInt("key")!!
                            val detailsModel = DetailsModel(api)
                            val detailViewModel = DetailsViewModel(detailsModel, id)
                            DetailsView(viewModel = detailViewModel)
                        }

                    }
                }
            }
        }
    }
}
