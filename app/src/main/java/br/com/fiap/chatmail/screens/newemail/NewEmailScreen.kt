package br.com.fiap.chatmail.screens.newemail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.backend.database.RetrofitClient
import br.com.fiap.chatmail.backend.model.Email
import br.com.fiap.chatmail.components.DefaultButton
import br.com.fiap.chatmail.components.DefaultTextInput
import br.com.fiap.chatmail.screens.newemail.components.NewEmailHeader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
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
        bottomBar = {
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
                    DefaultButton(onClick = {
                        val email = Email(
                            senderEmailAddress = "mock@mail.com",
                            recipientEmailAddress = to,
                            subject = subject,
                            message = message
                        )
                        sendEmail(email)
                        navController.navigate("chat")
                    }, content = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.send),
                                contentDescription = "Ícone de seta indicando envio de email"
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Enviar")
                        }
                    }, width = 230, height = 50
                    )
                }
            }
        },
    )
}

fun sendEmail(email: Email) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitClient.instance.sendEmail(email)
            if (response.isSuccessful) {
                println("Email enviado com sucesso")
            } else {
                println("Falha ao enviar o email: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            println("Erro inesperado: ${e.message}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyComposable() {

    val navController = TestNavHostController(LocalContext.current)

    val fakeViewModel = NewEmailScreenViewModel()

    NewEmailScreen(navController = navController, newEmailScreenViewModel = fakeViewModel)
}