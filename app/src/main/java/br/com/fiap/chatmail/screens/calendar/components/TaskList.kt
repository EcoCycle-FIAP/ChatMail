package br.com.fiap.chatmail.screens.calendar.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R

@Composable
fun TaskList(navController: NavController) {
    val tasks by remember {
        mutableStateOf(
            listOf(
                Task(
                    "1 de fevereiro de 2024", "Reunião com a equipe de desenvolvimento", "01/02"
                ),
                Task(
                    "2 de fevereiro de 2024", "Revisão de código para o novo módulo", "02/02"
                ),
                Task(
                    "3 de fevereiro de 2024", "Implementar modificações no sistema legado da empresa - modernização", "HOJE"
                )
            )
        )
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Tarefas", fontSize = 25.sp, fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ver tudo >",
                color = colorResource(id = R.color.chatmail_gray_color),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("tasks")
                },
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        tasks.forEach { task ->
            TaskItem(task)
        }
    }
}
