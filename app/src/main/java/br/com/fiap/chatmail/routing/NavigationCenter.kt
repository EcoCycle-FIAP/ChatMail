package br.com.fiap.chatmail.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.chatmail.screens.calendar.CalendarScreen
import br.com.fiap.chatmail.screens.chat.ChatScreen
import br.com.fiap.chatmail.screens.expandedemail.ExpandedEmailScreen
import br.com.fiap.chatmail.screens.favorites.FavoritesScreen
import br.com.fiap.chatmail.screens.mailbox.MailBoxScreen
import br.com.fiap.chatmail.screens.newemail.NewEmailScreenRoute
import br.com.fiap.chatmail.screens.signin.SignInScreen
import br.com.fiap.chatmail.screens.signin.SignInScreenViewModel
import br.com.fiap.chatmail.screens.signup.SignUpScreen
import br.com.fiap.chatmail.screens.signup.SignUpScreenViewModel
import br.com.fiap.chatmail.screens.tasks.TasksScreen

enum class Screens {
    SignIn, SignUp, Calendar, MailBox, NewEmail, ExpandedEmail, Chat, Favorites, Tasks
}

@Composable
fun NavigationCenter(onToggleTheme: () -> Unit) {
    val navController = rememberNavController()
    val context = LocalContext.current


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
            CalendarScreen(navController, onToggleTheme)
        }
        composable(route = Screens.MailBox.name) {
            MailBoxScreen(navController, onToggleTheme)
        }
        composable(route = Screens.Favorites.name) {
            FavoritesScreen(navController, onToggleTheme)
        }
        composable(route = Screens.Tasks.name) {
            TasksScreen(navController)
        }
        composable(route = Screens.NewEmail.name) {
            NewEmailScreenRoute(navController)
        }
        composable(route = Screens.ExpandedEmail.name) {
            ExpandedEmailScreen(navController)
        }
        composable(route = Screens.Chat.name){
            ChatScreen()
        }
    }
}