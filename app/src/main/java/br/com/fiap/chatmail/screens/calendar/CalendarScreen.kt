package br.com.fiap.chatmail.screens.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.TabBar
import br.com.fiap.chatmail.screens.calendar.components.CalendarHeader
import br.com.fiap.chatmail.screens.calendar.components.CalendarView
import br.com.fiap.chatmail.screens.calendar.components.TaskList


@Composable
fun CalendarScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background_color))
    ) {
        Column {
            TabBar(navController = navController)
            CalendarHeader()
            CalendarView()
            Spacer(modifier = Modifier.height(16.dp))
            TaskList(navController)
        }
    }
}