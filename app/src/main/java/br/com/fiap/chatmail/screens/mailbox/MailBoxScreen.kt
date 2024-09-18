package br.com.fiap.chatmail.screens.mailbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun MailBoxScreen(navController: NavController, onToggleTheme: () -> Unit) {
    var emailList by remember { mutableStateOf(listOf<Email>()) }
    val coroutineScope = rememberCoroutineScope()

    fun fetchEmails() {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.exemplo.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val emailApiService = retrofit.create(EmailService::class.java)
                val response = emailApiService.listEmails().execute()

                if (response.isSuccessful) {
                    response.body()?.let {
                        emailList = it
                    }
                }
            } catch (e: Exception) {
                // Handle exception (optional Toast or Log)
            }
        }
    }

    LaunchedEffect(Unit) {
        fetchEmails()
    }

    Column {
        TabBar(navController, onToggleTheme)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
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
            NewEmailButton(
                navController = navController,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 25.dp)
            )
        }
    }
}
