package br.com.fiap.chatmail.screens.mailbox

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.screens.mailbox.components.EmailCard

@Composable
fun MailBoxScreen() {
    LazyColumn(modifier = Modifier
        .background(color = colorResource(id = R.color.email_card_backgrond))) {
        items(10) {
            EmailCard(iteration = it)
        }
    }
}