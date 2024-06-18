package br.com.fiap.chatmail.screens.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.ChatMailLogo
import br.com.fiap.chatmail.components.DefaultButton
import br.com.fiap.chatmail.components.DefaultTextInput
import br.com.fiap.chatmail.ui.theme.Inika

@Composable
fun SignInScreen(navController: NavController, signInScreenViewModel: SignInScreenViewModel) {

    val email by signInScreenViewModel.email.observeAsState(initial = "")
    val password by signInScreenViewModel.password.observeAsState(initial = "")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background_color))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp, horizontal = 0.dp)
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    ChatMailLogo()
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "ChatMail", fontSize = 32.sp, fontFamily = Inika
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Entre na sua conta para continuar", fontSize = 16.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.chatmail_white_color))
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    DefaultTextInput(label = "Email",
                        placeholder = "Digite seu email",
                        value = email,
                        onValueChange = { signInScreenViewModel.onEmailChanged(it) },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.mail_icon),
                                contentDescription = "Ícone de email"
                            )
                        })
                    Spacer(modifier = Modifier.height(14.dp))
                    DefaultTextInput(label = "Senha",
                        placeholder = "Digite sua senha",
                        value = password,
                        onValueChange = { signInScreenViewModel.onPasswordChanged(it) },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.eye_icon),
                                contentDescription = "Ícone de olho"
                            )
                        })

                    Spacer(modifier = Modifier.height(32.dp))

                    DefaultButton(onClick = {
                        navController.navigate("mailbox")
                    }, content = {
                        Column {
                            Text(text = "Entrar", fontSize = 16.sp)
                        }
                    })
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        "Esqueceu a senha?",
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .align(Alignment.CenterHorizontally),
                        color = colorResource(
                            id = R.color.primary_color
                        ),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        //Footer
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Não tem uma conta ainda? ")
                Text("Cadastre-se",
                    color = colorResource(id = R.color.primary_color),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate("signup")
                    })
            }
        }
    }
}