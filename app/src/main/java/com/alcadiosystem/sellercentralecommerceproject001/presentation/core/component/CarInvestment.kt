package com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcadiosystem.sellercentralecommerceproject001.R
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textSubtitle
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.whiteColor

@Composable
fun CardInvestment(name: String) {

    Card(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = whiteColor
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
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
                    text = name,
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