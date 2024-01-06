package com.alcadiosystem.sellercentralecommerceproject001.navigation.itemnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.alcadiosystem.sellercentralecommerceproject001.navigation.NavScreen

sealed class ItemBottomNav(
    val icon: ImageVector,
    val title:String,
    val route:String
) {

    data object ItemBottomNavHome:ItemBottomNav(
        icon = Icons.Outlined.Home,
        title = "",
        route = NavScreen.Home.route
    )
    data object ItemBottomNavCredit:ItemBottomNav(
        icon = Icons.Outlined.CreditCard,
        title = "",
        route = NavScreen.Expense.route
    )
    data object ItemBottomNavSearch:ItemBottomNav(
        icon = Icons.Outlined.Search,
        title = "",
        route = NavScreen.Sales.route
    )
    data object ItemBottomNavProfile:ItemBottomNav(
        icon = Icons.Outlined.PersonOutline,
        title = "",
        route = NavScreen.Profile.route
    )

}