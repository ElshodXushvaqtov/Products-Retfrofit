package com.example.retrofitmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.retrofitmvvm.api.ApiClient
import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.details.DetailsModel
import com.example.retrofitmvvm.details.DetailsView
import com.example.retrofitmvvm.details.DetailsViewModel
import com.example.retrofitmvvm.home.HomeModel
import com.example.retrofitmvvm.home.HomeView
import com.example.retrofitmvvm.home.HomeViewModel

val api: ApiService = ApiClient.getInstance().create(ApiService::class.java)
val homeModel = HomeModel(api)
val homeViewModel = HomeViewModel(homeModel)
val detailsModel = DetailsModel(api)
val detailsViewModel = DetailsViewModel(detailsModel)

@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeView(viewModel = homeViewModel, navHostController = navHostController)
        }
        composable(route = Screens.Details.route) {
            DetailsView(viewModel = detailsViewModel)
        }

    }
}