package br.com.fiap.chatmail.screens.calendarandtasks

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.chatmail.R


@Composable
fun Tasks(navController: NavController) {
    val tasks by remember { mutableStateOf(listOf(
        Task("1 de fevereiro de 2024",
            "blablablablablablablablabla",
            "01/02"),

        Task("2 de fevereiro de 2024",
            "blablablablablablablabla",
            "02/02"),

        Task("3 de fevereiro de 2024",
            "Modificações no sistema da empresa",
            "HOJE"),
    )) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState())
        ) {
            CalendarHeader()
            Spacer(modifier = Modifier.height(16.dp))
            TaskList(tasks, navController)
        }
    }
}

@Composable
fun CalendarHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_previous),
                contentDescription = "Previous Month",
                modifier = Modifier.clickable { }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "FEVEREIRO 2024",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_next),
                contentDescription = "Next Month",
                modifier = Modifier.clickable {  }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        CalendarView()
    }
}

@Composable
fun CalendarView() {
    val daysOfWeek = listOf("D", "S", "T", "Q", "Q", "S", "S")
    val daysInMonth = (1..28).toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
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
                    color = Color.Black,
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
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = daysInMonth[dayIndex].toString(),
                                    color = Color.Black,
                                    fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal,
                                    modifier = Modifier.padding(bottom = if (isToday) 1.dp else 0.dp)
                                )
                                if (isToday) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(
                                        modifier = Modifier
                                            .height(2.dp)
                                            .width(20.dp)
                                            .background(Color.Gray)
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


@Composable
fun TaskList(tasks: List<Task>, navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Tarefas",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ver tudo >",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("all_tasks")
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        tasks.forEach { task ->
            TaskItem(task)
        }
    }
}

data class Task(val date: String,
                val description: String,
                val dateToday: String)

@Composable
fun TaskItem(task: Task) {
    Text(text = task.date,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 11.dp)
    ) {
        Box(
            modifier = Modifier
                .width(15.dp)
                .height(40.dp)
                .background(Color.Blue)
        )
        Text(text = task.dateToday,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            modifier = Modifier.padding(horizontal = 10.dp))
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    Tasks(navController = rememberNavController())
}
