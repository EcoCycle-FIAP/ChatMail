package br.com.fiap.chatmail.screens.calendarandtasks

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TasksScreen(navController: NavController) {
    val tasks = generateTasks()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TaskLists(tasks, navController)
        }
    }
}

@Composable
fun TaskLists(tasks: List<Task>, navController: NavController) {
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
                text = "Voltar ao calendário <",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("all_tasks")
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        tasks.forEach { task ->
            TaskItems(task)
        }
    }
}

@Composable
fun TaskItems(task: Task) {
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
                .background(Color.Blue)
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


@SuppressLint("DefaultLocale")
@Composable
private fun generateTasks(): List<Task> {
    val month = "fevereiro de 2024"
    val daysInMonth = 28
    val tasks = mutableListOf<Task>()

    for (day in 1..daysInMonth) {
        val taskDate = "$day de $month"
        val taskDescription = when (day) {
            1 -> "blablablablablablablablabla"
            2 -> "blablablablablablablabla"
            3 -> "Modificações no sistema da empresa"
            else -> "Tarefa do dia $day"
        }
        val taskDateToday = if (day == 3) "HOJE" else String.format("%02d/%02d", day, 2)

        tasks.add(Task(taskDate, taskDescription, taskDateToday))
    }

    return tasks
}

@Preview
@Composable
private fun TasksPreview() {
    TasksScreen(navController = rememberNavController())
}
