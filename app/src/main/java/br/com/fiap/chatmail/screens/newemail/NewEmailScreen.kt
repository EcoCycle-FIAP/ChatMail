package br.com.fiap.chatmail.screens.newemail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.DefaultTextInput
import br.com.fiap.chatmail.screens.newemail.components.NewEmailFooter
import br.com.fiap.chatmail.screens.newemail.components.NewEmailHeader

@Composable
fun NewEmailScreen(navController: NavController, newEmailScreenViewModel: NewEmailScreenViewModel) {
    val to by newEmailScreenViewModel.to.observeAsState(initial = "")
    val subject by newEmailScreenViewModel.subject.observeAsState(initial = "")
    val message by newEmailScreenViewModel.message.observeAsState(initial = "")

    Scaffold(
        topBar = { NewEmailHeader(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(color = colorResource(id = R.color.chatmail_lightgray_color))
                    .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultTextInput(
                    value = to,
                    onValueChange = { newEmailScreenViewModel.onToChanged(it) },
                    label = "Para:",
                    placeholder = "Digite o(s) destinatário(s)",
                    width = 400.dp
                )
                DefaultTextInput(
                    value = subject,
                    onValueChange = { newEmailScreenViewModel.onSubjectChanged(it) },
                    label = "Assunto:",
                    placeholder = "Digite o assunto",
                    width = 400.dp
                )
                DefaultTextInput(
                    value = message,
                    onValueChange = { newEmailScreenViewModel.onMessageChanged(it) },
                    label = "Mensagem:",
                    placeholder = "Digite a mensagem",
                    width = 400.dp,
                    singleLine = false,
                )
            }
        },
        bottomBar = { NewEmailFooter(navController) },
    )
}