package br.com.fiap.chatmail.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.backend.database.RetrofitClient
import br.com.fiap.chatmail.backend.model.Email
import br.com.fiap.chatmail.components.TabBar
import br.com.fiap.chatmail.screens.favorites.components.EmailCard
import br.com.fiap.chatmail.screens.favorites.components.NewEmailButton

@Composable
fun FavoritesScreen(navController: NavController, onToggleTheme: () -> Unit) {

    Column {
        TabBar(navController, onToggleTheme)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            var emailList by remember { mutableStateOf<List<Email>>(emptyList()) }

            LaunchedEffect(Unit) {
                try {
                    val emails = RetrofitClient.getEmails()
                    emails?.let {
                        emailList = it
                    } ?: run {
                        println("Nenhum email encontrado.")
                    }
                } catch (e: Exception) {
                    println("Erro inesperado: ${e.message}")
                }
            }
            // Exibe os emails em uma lista
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
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