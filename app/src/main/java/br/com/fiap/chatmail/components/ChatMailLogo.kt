package br.com.fiap.chatmail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.chatmail.R

@Composable
fun ChatMailLogo() {
    Image(
        painter = painterResource(id = R.drawable.chatmail_logo),
        contentDescription = "ChatMail logo image",
        Modifier.size(70.dp)
    )
}