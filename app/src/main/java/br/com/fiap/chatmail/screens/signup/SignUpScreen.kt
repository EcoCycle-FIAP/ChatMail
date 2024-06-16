package br.com.fiap.chatmail.screens.signup

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.components.ChatMailLogo
import br.com.fiap.chatmail.components.DefaultButton
import br.com.fiap.chatmail.components.DefaultTextInput
import br.com.fiap.chatmail.ui.theme.Inika

@Composable
fun SignUpScreen(navController: NavController, signUpScreenViewModel: SignUpScreenViewModel) {

    val name by signUpScreenViewModel.name.observeAsState("")
    val email by signUpScreenViewModel.email.observeAsState("")
    val password by signUpScreenViewModel.password.observeAsState("")
    val passwordConfirmation by signUpScreenViewModel.passwordConfirmation.observeAsState("")

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
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    ChatMailLogo()
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "ChatMail",
                        fontSize = 32.sp,
                        fontFamily = Inika
                    )
                }
                Box(modifier = Modifier.width(300.dp)) {
                    Text(
                        text = "Crie sua conta e mande emails como manda mensagens",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
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
                    DefaultTextInput(
                        label = "Nome Completo",
                        placeholder = "Digite seu nome completo",
                        value = name,
                        onValueChange = {
                            signUpScreenViewModel.onNameChanged(it)
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.account_box_24),
                                contentDescription = "Ícone de perfil"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    DefaultTextInput(
                        label = "Email",
                        placeholder = "Digite seu email",
                        value = email,
                        onValueChange = {
                            signUpScreenViewModel.onEmailChanged(it)
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.mail_icon),
                                contentDescription = "Ícone de email"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    DefaultTextInput(
                        label = "Senha",
                        placeholder = "Digite sua senha",
                        value = password,
                        onValueChange = {
                            signUpScreenViewModel.onPasswordChanged(it)
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.eye_icon),
                                contentDescription = "Ícone de olho"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    DefaultTextInput(
                        label = "Confirmar senha",
                        placeholder = "Digite novamente sua senha",
                        value = passwordConfirmation,
                        onValueChange = {
                            signUpScreenViewModel.onPasswordConfirmationChanged(it)
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.eye_icon),
                                contentDescription = "Ícone de olho"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    DefaultButton(
                        onClick = {
                            navController.navigate("login")
                        },
                        text = "Cadastrar",
                        contentFontSize = 16
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Já possui uma conta? ")
                Text(
                    "Entrar",
                    color = colorResource(id = R.color.primary_color),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate("signin")
                    }
                )
            }
        }
    }

}