package br.com.fiap.chatmail.screens.newemail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.DefaultButton

@Composable
fun NewEmailFooter(navController: NavController) {
    Row(
        Modifier.padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 50.dp)
                .background(color = colorResource(id = R.color.background_color))
                .fillMaxWidth()
                .height(86.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultButton(width = 230,
                height = 50,
                onClick = { navController.navigate("chat") },
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "Ícone de seta indicando envio de email"
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Enviar")
                    }
                })
        }
    }
}