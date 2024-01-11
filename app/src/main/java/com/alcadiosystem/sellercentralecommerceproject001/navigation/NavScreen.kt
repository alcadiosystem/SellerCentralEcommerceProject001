package com.alcadiosystem.sellercentralecommerceproject001.navigation

sealed class NavScreen(val route:String) {

    data object Home:NavScreen("home")
    data object Expense:NavScreen("expense")
    data object Sales:NavScreen("sales")
    data object Profile:NavScreen("profile")
    data object Search:NavScreen("search")

}