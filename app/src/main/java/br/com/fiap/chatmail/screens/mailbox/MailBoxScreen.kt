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
import br.com.fiap.chatmail.screens.mailbox.components.EmailCard
import br.com.fiap.chatmail.screens.mailbox.components.NewEmailButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Data model for email
data class Email(
    val id: String,
    val sender: String,
    val subject: String,
    val body: String,
    val timestamp: String
)

// API service definition
interface EmailApiService {
    @GET("emails/list")
    fun listEmails(): retrofit2.Call<List<Email>>
}

@Composable
fun MailBoxScreen(navController: NavController) {
    var emailList by remember { mutableStateOf(listOf<Email>()) }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    // Function to fetch emails from API
    fun fetchEmails() {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.exemplo.com/") // Replace with your API URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val emailApiService = retrofit.create(EmailApiService::class.java)
                val response = emailApiService.listEmails().execute()

                if (response.isSuccessful) {
                    response.body()?.let {
                        emailList = it
                    }
                } else {
                    // Handle error (optional Toast or Log)
                }
            } catch (e: Exception) {
                // Handle exception (optional Toast or Log)
            }
        }
    }

    // Call fetchEmails when the screen is initialized
    LaunchedEffect(Unit) {
        fetchEmails()
    }

    Column {
        TabBar(navController)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.chatmail_lightgray_color))
        ) {
            LazyColumn(
                modifier = Modifier.background(color = colorResource(id = R.color.chatmail_lightgray_color))
            ) {
                // Display email items from API
                items(emailList) { email ->
                    EmailCard(
                        email = email,
                        navController = navController
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

// Updated EmailCard to take Email object
@Composable
fun EmailCard(email: Email, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.chatmail_lightgray_color))
            .padding(16.dp)
    ) {
        Column {
            Text(text = "De: ${email.sender}", fontWeight = FontWeight.Bold)
            Text(text = "Assunto: ${email.subject}")
            Text(text = "Corpo: ${email.body}", maxLines = 2)
            Text(text = "Recebido: ${email.timestamp}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyComposable() {
    val navController = TestNavHostController(LocalContext.current)
    MailBoxScreen(navController = navController)
}
