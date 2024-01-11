package com.alcadiosystem.sellercentralecommerceproject001.presentation.sale

import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alcadiosystem.sellercentralecommerceproject001.R
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.BottomBarNav
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.CardInvestment
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.Legend
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.PieChart
import com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component.PieSlice
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.background
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.colorAccent
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.greenData
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconColorUnselected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.redColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textSubtitle
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.titleColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.whiteColor
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaleScreen(
    navController: NavHostController
) {

    val companyNames = listOf(
        "Tu estafita S.A",
        "SCS S.Coop",
        "Robandito S.C",
        "La mentirita E.U"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Return")
                    }
                },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.man1),
                        contentDescription = "profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = background
                )
            )
        },
        bottomBar = {
            BottomBarNav(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sales Record",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            CardData()

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Sales Revenue",
                fontSize = 30.sp,
                color = titleColor,
                fontWeight = FontWeight.Bold
            )

            LazyColumn{
                items(companyNames){
                    CardInvestment(it)
                }
            }

        }
    }

}


@Composable
fun CardData() {
    var data = listOf(
        PieSlice(value = 40f, color = greenData, data = "Tu estafita S.A"),
        PieSlice(value = 30f, color = colorAccent, data = "SCS S.Coop"),
        PieSlice(value = 10f, color = iconColorUnselected, data = "Robandito S.C"),
        PieSlice(value = 20f, color = textColor, data = "La mentirita E.U")
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = whiteColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PieChart(modifier = Modifier.size(150.dp, 150.dp), data)
                Legend(data)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(1.dp)),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorAccent
                )
            ) {
                Text(text = "Create Invoice", fontSize = 15.sp, color = titleColor)
            }
        }
    }
}