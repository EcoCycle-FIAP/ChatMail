package br.com.fiap.chatmail.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.TabBar
import br.com.fiap.chatmail.screens.favorites.components.EmailCard
import br.com.fiap.chatmail.screens.favorites.components.NewEmailButton

@Composable
fun FavoritesScreen(navController: NavController) {
    Column(
    ) {
        TabBar(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.chatmail_lightgray_color))
        ) {
            LazyColumn(
                modifier = Modifier.background(color = colorResource(id = R.color.chatmail_lightgray_color))
            ) {
                items(4) {
                    EmailCard(iteration = it, navController = navController)
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