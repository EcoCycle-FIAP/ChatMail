package br.com.fiap.chatmail.screens.expandedemail.components

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
fun ExpandedEmailFooter(navController: NavController) {
    Row(
        Modifier.padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 50.dp)
                .background(color = colorResource(id = R.color.background_color))
                .fillMaxWidth()
                .height(86.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            DefaultButton(containerColor = R.color.chatmail_lightgray_color,
                contentColor = R.color.chatmail_gray_color,
                width = 160,
                height = 50,
                onClick = { navController.navigate("tasks") },
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_format_list_bulleted_add_24),
                            contentDescription = "Ícone de lista indicando que o botão é usado para criar uma nova tarefa"
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Gerar Tarefa")
                    }
                })
            DefaultButton(width = 160,
                height = 50,
                onClick = { navController.navigate("chat") },
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_question_answer_24),
                            contentDescription = "Ícone de mensagens indicando que o botão leva à visualização por chat"
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Responder")
                    }
                })
        }
    }
}