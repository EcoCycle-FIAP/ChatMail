package br.com.fiap.chatmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.chatmail.routing.NavigationCenter
import br.com.fiap.chatmail.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    lateinit var application: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        application = this.applicationContext as BaseApplication

        enableEdgeToEdge()

        setContent {
            AppTheme (darkTheme = application.isDark.value) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 75.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    NavigationCenter(onToggleTheme = {
                        application.toggleLightTheme()
                    })
                }
            }
        }
    }
}