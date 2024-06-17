package br.com.fiap.chatmail.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.chatmail.screens.calendar.CalendarScreen
import br.com.fiap.chatmail.screens.chat.ChatScreen
import br.com.fiap.chatmail.screens.expandedemail.ExpandedEmailScreen
import br.com.fiap.chatmail.screens.favorites.FavoritesScreen
import br.com.fiap.chatmail.screens.mailbox.MailBoxScreen
import br.com.fiap.chatmail.screens.newemail.NewEmailScreen
import br.com.fiap.chatmail.screens.signin.SignInScreen
import br.com.fiap.chatmail.screens.signin.SignInScreenViewModel
import br.com.fiap.chatmail.screens.signup.SignUpScreen
import br.com.fiap.chatmail.screens.signup.SignUpScreenViewModel
import br.com.fiap.chatmail.screens.tasks.TasksScreen

enum class Screens {
    SignIn, SignUp, Calendar, MailBox, NewEmail, ExpandedEmail, Chat, Favorites, Tasks
}

@Composable
fun NavigationCenter() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screens.SignIn.name) {
        composable(route = Screens.SignIn.name) {
            SignInScreen(
                navController = navController, signInScreenViewModel = SignInScreenViewModel()
            )
        }
        composable(route = Screens.SignUp.name) {
            SignUpScreen(
                navController = navController, signUpScreenViewModel = SignUpScreenViewModel()
            )
        }
        composable(route = Screens.Calendar.name) {
            CalendarScreen(navController)
        }
        composable(route = Screens.MailBox.name) {
            MailBoxScreen(navController)
        }
        composable(route = Screens.Favorites.name) {
            FavoritesScreen(navController)
        }
        composable(route = Screens.Tasks.name) {
            TasksScreen(navController)
        }
        composable(route = Screens.NewEmail.name) {
            NewEmailScreen()
        }
        composable(route = Screens.ExpandedEmail.name) {
            ExpandedEmailScreen()
        }
        composable(route = Screens.Chat.name){
            ChatScreen()
        }
    }
}