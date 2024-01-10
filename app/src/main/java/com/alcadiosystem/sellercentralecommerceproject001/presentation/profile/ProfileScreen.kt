package com.alcadiosystem.sellercentralecommerceproject001.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alcadiosystem.sellercentralecommerceproject001.R
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.BottomBarNav
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.background
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.blueHighlight
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconColorUnselected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textSubtitle
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.whiteColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Profile")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Return")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "More")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = background
                )
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(180.dp),
                    painter = painterResource(id = R.drawable.man1),
                    contentDescription = "profile",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Alex Sparring",
                    fontSize = 40.sp,
                    modifier = Modifier.padding(top = 10.dp),
                    color = textColor
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "Beginning date:",
                        color = blueHighlight,
                        fontSize = 12.sp
                    )
                    Text(text = "5 June 2023", color = textSubtitle, fontSize = 12.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            CardElementProfile("Notificiation", Icons.Outlined.Notifications)

            CardElementProfile("umbox@um.com", Icons.Outlined.Email)

            CardElementProfile("Contact Us", Icons.Outlined.Phone)

            for (i in 0..3) {
                CardInvestment(i)
            }

        }
    }

}

@Composable
fun CardInvestment(i: Int) {

    val companyNames = listOf(
        "Tu estafita S.A",
        "SCS S.Coop",
        "Robandito S.C",
        "La mentirita E.U"
    )

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = whiteColor
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.buildings),
                contentDescription = "Empresita",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = companyNames[i],
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                Text(text = "Since lasat week", fontSize = 13.sp, color = textSubtitle)
            }

            Text(
                modifier = Modifier.weight(0.5f),
                text = "$55.12",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
    }
}

@Composable
fun CardElementProfile(text: String, icon: ImageVector) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 5.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = whiteColor
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Notificiations",
                tint = iconColorUnselected,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = text, color = textSubtitle, fontSize = 16.sp)
        }
    }
}

