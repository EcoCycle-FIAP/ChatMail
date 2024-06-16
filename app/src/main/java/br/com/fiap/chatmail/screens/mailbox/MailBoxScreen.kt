package br.com.fiap.chatmail.screens.mailbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.TabBar
import br.com.fiap.chatmail.screens.mailbox.components.EmailCard

@Composable
fun MailBoxScreen(navController: NavController) {
    Column {
        TabBar(navController)
        LazyColumn(
            modifier = Modifier
                .background(color = colorResource(id = R.color.chatmail_lightgray_color))
        ) {
            items(10) {
                EmailCard(iteration = it)
            }
        }
    }

}