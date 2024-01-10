package com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alcadiosystem.sellercentralecommerceproject001.navigation.CurrentRoute
import com.alcadiosystem.sellercentralecommerceproject001.navigation.itemnavigation.ItemBottomNav.*
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.colorAccent
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconColorUnselected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconSelected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.whiteColor

@Composable
fun BottomBarNav(navController: NavHostController) {

    val listItemNav = listOf(
        ItemBottomNavHome,
        ItemBottomNavCredit,
        ItemBottomNavSearch,
        ItemBottomNavProfile,
    )



    NavigationBar(
        containerColor = whiteColor
    ) {

        listItemNav.forEach { item ->

            val isSelected = CurrentRoute(navController = navController) == item.route

            NavigationBarItem(
                modifier = Modifier.size(450.dp),
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = colorAccent,
                    selectedIconColor = iconSelected,
                    unselectedIconColor = iconColorUnselected
                )
            )
        }
    }

}