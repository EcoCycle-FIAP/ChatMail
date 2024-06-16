package br.com.fiap.chatmail.screens.signupandsignin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.chatmail.screens.mailbox.MailBoxScreen
import br.com.fiap.chatmail.screens.signupandsignin.components.SignInScreen
import br.com.fiap.chatmail.screens.signupandsignin.components.SignUpScreen

@Composable
fun SignInAndSignUpScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "sign_in") {
        composable(route = "sign_in") {
            SignInScreen(
                navController = navController,
                signInScreenViewModel = SignInScreenViewModel()
            )
        }
        composable(route = "sign_up") {
            SignUpScreen(
                navController = navController,
                signUpScreenViewModel = SignUpScreenViewModel()
            )
        }
        composable(route = "mailbox"){
            MailBoxScreen()
        }
    }
}