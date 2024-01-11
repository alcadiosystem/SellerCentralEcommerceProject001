package com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.iconColorUnselected
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textSubtitle
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.whiteColor

@Composable
fun CardElementInfo(text: String, icon: ImageVector) {
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

