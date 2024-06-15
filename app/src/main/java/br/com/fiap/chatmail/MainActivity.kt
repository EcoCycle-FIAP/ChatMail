package br.com.fiap.chatmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import br.com.fiap.chatmail.screens.signupandsignin.SignInAndSignUpScreen
import br.com.fiap.chatmail.ui.theme.ChatMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatMailTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(bottom = 75.dp),
                    color = colorResource(id = R.color.chatmail_white_color)
                ) {
                    SignInAndSignUpScreen()
                }
            }
        }
    }
}