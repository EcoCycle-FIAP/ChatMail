package br.com.fiap.chatmail.screens.mailbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.TabBar
import br.com.fiap.chatmail.models.Email
import br.com.fiap.chatmail.screens.mailbox.components.EmailCard
import br.com.fiap.chatmail.screens.mailbox.components.NewEmailButton
import br.com.fiap.chatmail.services.EmailService
import br.com.fiap.consultacep.service.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun MailBoxScreen(navController: NavController, onToggleTheme: () -> Unit) {
    // Scope para gerenciar as coroutines
    val coroutineScope = rememberCoroutineScope()

    // Estado para armazenar a lista de e-mails
    var emailList by remember { mutableStateOf<List<Email>>(emptyList()) }

    // Chamada assíncrona para buscar os e-mails quando a tela é composta
    LaunchedEffect(Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            val call = RetrofitFactory().getEmailService().listEmails()
            try {
                val response = call.execute()
                if (response.isSuccessful) {
                    response.body()?.let { emails ->
                        emailList = emails // Atualiza a lista de e-mails no estado
                    }
                } else {
                    // Lidar com erro, exibir uma mensagem, etc.
                }
            } catch (e: Exception) {
                // Lidar com exceção, exibir uma mensagem de erro, etc.
            }
        }
    }

    Column {
        TabBar(navController, onToggleTheme)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            // Verifica se a lista não está vazia antes de renderizar
            if (emailList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.background(MaterialTheme.colorScheme.secondary)
                ) {
                    items(emailList) { email ->
                        EmailCard(
                            email = email,
                            navController = navController,
                            iteration = emailList.indexOf(email)
                        )
                    }
                }
            } else {
                // Exibe um texto caso a lista esteja vazia ou durante o carregamento
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Carregando emails...",
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Botão para compor novo email
            NewEmailButton(
                navController = navController,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 25.dp)
            )
        }
    }
}
