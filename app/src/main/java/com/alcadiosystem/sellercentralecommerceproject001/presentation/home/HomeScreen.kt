package com.alcadiosystem.sellercentralecommerceproject001.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.DataExploration
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alcadiosystem.sellercentralecommerceproject001.R
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.BottomBarNav
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.colorAccent
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconColorUnselected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconSelected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textSubtitle
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.titleColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.whiteColor


@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomBarNav(navController = navController)

        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }

                    Image(
                        painter = painterResource(id = R.drawable.man1),
                        contentDescription = "profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(
                        text = "Dashboard",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = titleColor
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                    ) {
                        CardItemDashboard(0, Modifier.weight(1f))
                        CardItemDashboard(1, Modifier.weight(1f))
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CardItemDashboard(2, Modifier.weight(1f))
                        CardItemDashboard(3, Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Transactions",
                            fontSize = 20.sp,
                            color = titleColor,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = "more"
                            )
                        }
                    }

                    for (i in 0..4) {
                        TransactionElement()
                    }

                }

            }
        }
    )

}

@Composable
fun TransactionElement() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.man1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Robert Black", fontWeight = FontWeight.Bold, color = titleColor)
                Text(text = "$56.99", fontWeight = FontWeight.Bold, color = titleColor)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Transfer to bank", color = textSubtitle, fontSize = 12.sp)
                Text(text = "Jun 223", color = textSubtitle, fontSize = 12.sp)
            }
        }
    }
}


@Composable
fun CardItemDashboard(position: Int, modifier: Modifier = Modifier) {

    val iconList = listOf(
        Icons.Outlined.Analytics,
        Icons.Outlined.DataExploration,
        Icons.Outlined.Outbox,
        Icons.Outlined.People
    )
    val titleList = listOf(
        "170K",
        "9.56K",
        "158",
        "5.674K"
    )
    val listSubtitle = listOf(
        "Sales",
        "Revenue",
        "Products",
        "Customers"
    )

    Card(
        modifier
            .height(180.dp)
            .padding(vertical = 10.dp, horizontal = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = if(position==1) colorAccent else whiteColor
        ),
        shape = RoundedCornerShape(corner = CornerSize(46.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = iconList[position], contentDescription = null)
            Text(
                text = titleList[position],
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = titleColor
            )
            Text(text = listSubtitle[position], color = if(position==1) textColor else textSubtitle, fontSize = 12.sp)
        }
    }
}
