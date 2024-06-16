package br.com.fiap.chatmail.screens.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R


@Composable
fun CalendarView() {
    val daysOfWeek = listOf("D", "S", "T", "Q", "Q", "S", "S")
    val daysInMonth = (1..28).toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.chatmail_lightgray_color))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            daysOfWeek.forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 23.dp, vertical = 7.dp),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.chatmail_black_color),
                    fontSize = 20.sp
                )
            }
        }

        var dayIndex = 0
        for (week in 0 until 4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (day in 0 until 7) {
                    if (dayIndex < daysInMonth.size) {
                        val isToday = daysInMonth[dayIndex] == 3
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(4.dp)
                                .background(colorResource(id = R.color.background_color)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = daysInMonth[dayIndex].toString(),
                                    color = colorResource(id = R.color.chatmail_black_color),
                                    fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal,
                                    modifier = Modifier.padding(bottom = if (isToday) 1.dp else 0.dp)
                                )
                                if (isToday) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(
                                        modifier = Modifier
                                            .height(2.dp)
                                            .width(20.dp)
                                            .background(colorResource(id = R.color.chatmail_gray_color))
                                    )
                                }
                            }
                        }
                        dayIndex++
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
