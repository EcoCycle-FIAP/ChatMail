package br.com.fiap.chatmail.screens.newemail

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

@Composable
fun NewEmailScreenRoute(navController: NavController) {
    val context = LocalContext.current
    val newEmailScreenViewModel: NewEmailScreenViewModel = viewModel(
        factory = NewEmailScreenViewModelFactory(context)
    )

    NewEmailScreen(
        navController = navController,
        newEmailScreenViewModel = newEmailScreenViewModel
    )
}

