package br.com.fiap.chatmail.screens.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R

data class Task(
    val date: String,
    val description: String,
    val dateToday: String
)
@Composable
fun TaskItem(task: Task) {
    Text(
        text = task.date,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 11.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = colorResource(id = R.color.primary_color))
                .padding(vertical = 20.dp, horizontal = 7.dp)
        )
        Text(
            text = task.dateToday,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0x23797474),
                modifier = Modifier.padding(1.dp)
            ) {
                Text(
                    text = task.description,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}
