package com.alcadiosystem.sellercentralecommerceproject001.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alcadiosystem.sellercentralecommerceproject001.presentation.home.HomeScreen

@Composable
fun NavigationSeller(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = NavScreen.Home.route){
        composable(NavScreen.Home.route){
            HomeScreen(navController = navController)
        }
    }

}