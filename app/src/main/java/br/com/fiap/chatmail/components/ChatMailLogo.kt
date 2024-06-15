package br.com.fiap.chatmail.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.com.fiap.chatmail.R

@Composable
fun ChatMailLogo() {
    Image(painter = painterResource(id = R.drawable.chatmail_logo), contentDescription = "ChatMail logo image")
}