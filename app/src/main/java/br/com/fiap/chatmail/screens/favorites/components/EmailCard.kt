package br.com.fiap.chatmail.screens.favorites.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.backend.model.Email
import br.com.fiap.chatmail.ui.theme.Jaldi

@Composable
fun EmailCard(iteration: Int, navController: NavController, email: Email) {

    //Lógica para simular diferentes cores de avatares
    var avatarColor = R.color.primary_color

    when (iteration) {
        0, 2 -> {
            avatarColor = R.color.chatmail_red_color
        }

        1, 3 -> {
            avatarColor = R.color.chatmail_green_color
        }
    }

    Column(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 25.dp)
            .fillMaxWidth()
            .height(180.dp)
            .clickable { navController.navigate("expandedemail") },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            Box(Modifier.weight(0.2f), contentAlignment = Alignment.CenterStart) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "Avatar do usuário",
                    modifier = Modifier.size(55.dp),
                    tint = colorResource(id = avatarColor)
                )
            }
            Column(Modifier.weight(0.55f)) {
                Text(
                    text = email.senderEmailAddress,
                    fontSize = 18.sp,
                    fontFamily = Jaldi,
                    lineHeight = 10.sp
                )
                Text(
                    text = email.subject,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Jaldi
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(0.25f)
            ) {
                Text(
                    text = "",
                    fontSize = 16.sp,
                    fontFamily = Jaldi,
                    color = colorResource(id = R.color.chatmail_gray_color),
                    textAlign = TextAlign.End
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_24),
                    contentDescription = "Ícone de coração para favoritar o email.",
                    tint = colorResource(id = R.color.chatmail_yellow_color)
                )
            }
        }
        Text(
            text = email.message, fontFamily = Jaldi, color = colorResource(
                id = R.color.chatmail_gray_color
            )
        )
        DeleteButton(onClick = { /*TODO*/ })
    }
    HorizontalDivider(
        color = colorResource(id = R.color.chatmail_gray_color),
        modifier = Modifier.padding(horizontal = 25.dp)
    )
}

@Composable
fun DeleteButton(
    onClick: () -> Unit,
    iconSize: Int = 24,
    width: Int? = 40,
    height: Int? = 40,
    borderColor: Int = R.color.chatmail_red_color, // Usar a cor para a borda
    iconColor: Int = R.color.chatmail_red_color // Cor do ícone
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .width(width?.dp ?: 40.dp)
            .height(height?.dp ?: 40.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent, // Fundo transparente
            contentColor = colorResource(id = iconColor) // Cor do ícone
        ),
        border = BorderStroke(1.dp, colorResource(id = borderColor)) // Define a cor da borda
    ) {
        Icon(
            painter = painterResource(id = R.drawable.trash_24),
            contentDescription = "Deletar",
            modifier = Modifier.size(iconSize.dp),
            tint = colorResource(id = iconColor) // Define a cor do ícone
        )
    }
}