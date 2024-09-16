package br.com.fiap.chatmail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import br.com.fiap.chatmail.R

@Composable
fun LocaWebLogo() {
    Image(
        painter = painterResource(id = R.drawable.locaweb_logo),
        contentDescription = "LocaWeb logo image",
        modifier = Modifier.fillMaxSize()
    )
}