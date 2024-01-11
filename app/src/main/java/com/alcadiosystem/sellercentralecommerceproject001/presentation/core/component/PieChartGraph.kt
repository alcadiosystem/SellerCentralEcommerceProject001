package com.alcadiosystem.sellercentralecommerceproject001.presentation.core.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textColor
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.textSubtitle
import kotlin.random.Random

data class PieSlice(val value: Float, val data: String = "", val color: Color = Color.random())
private fun Color.Companion.random() = Color(Random.nextLong(0xFFFFFF) + 0xFF00000)

/**
 * Funcion que permite pintar una lista con los datos de la grafica
 * @param List<PieSlice>: listado con ls datos de la grafica
 */
@Composable
fun Legend(data: List<PieSlice>) {
    Column {
        data.forEach { slice ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(slice.color)
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    text = "${slice.value.toInt()}%",
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
                Text(text = slice.data, color = textSubtitle, fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

/**
 * Pinta una grafica piechart
 * @param List<PieSlice>: listado con ls datos de la grafica
 */
@Composable
fun PieChart(modifier: Modifier, slices: List<PieSlice>) {

    val sum = slices.map { it.value }.sum()

    Canvas(modifier = modifier) {
        slices.forEachIndexed { index, pieSlice ->

            val sliceStart = 360f * slices.take(index).map { it.value }.sum() / sum
            val sliceSweep = 360f * pieSlice.value / sum

            drawArc(pieSlice.color, sliceStart - 90f, sliceSweep, true)
        }
    }
}