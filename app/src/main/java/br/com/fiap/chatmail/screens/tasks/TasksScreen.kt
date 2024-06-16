package br.com.fiap.chatmail.screens.tasks

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.screens.tasks.components.Task
import br.com.fiap.chatmail.screens.tasks.components.TaskList

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
@Composable
fun TasksScreen(navController: NavController) {
    val tasks = generateTasks()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .background(colorResource(id = R.color.background_color))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TaskList(tasks, navController)
        }
    }
}

