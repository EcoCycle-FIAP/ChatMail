package br.com.fiap.chatmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.chatmail.ui.theme.ChatMailTheme
import br.com.fiap.chatmail.ui.theme.Inika
import br.com.fiap.chatmail.ui.theme.Jaldi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatMailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontFamily = Jaldi
    )


    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontFamily = Inika
    )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatMailTheme {
        Greeting("Android")
    }
}