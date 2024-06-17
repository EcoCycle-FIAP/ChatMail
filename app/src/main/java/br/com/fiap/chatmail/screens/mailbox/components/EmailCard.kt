package br.com.fiap.chatmail.screens.mailbox.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import br.com.fiap.chatmail.ui.theme.Jaldi

@Composable
fun EmailCard(iteration: Int, navController: NavController) {

    //Lógica para simular diferentes cores de avatares
    var avatarColor = R.color.primary_color

    when (iteration) {
        0, 5 -> {
            avatarColor = R.color.chatmail_red_color
        }
        1, 6 -> {
            avatarColor = R.color.chatmail_green_color
        }
        2, 7 -> {
            avatarColor = R.color.chatmail_yellow_color
        }
        3, 8 -> {
            avatarColor = R.color.chatmail_cyan_color
        }
        4, 9 -> {
            avatarColor = R.color.chatmail_gray_color
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
                    text = "Nome do Usuário",
                    fontSize = 18.sp,
                    fontFamily = Jaldi,
                    lineHeight = 10.sp
                )
                Text(
                    text = "Assunto do Email",
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
                    text = "XXt atrás",
                    fontSize = 16.sp,
                    fontFamily = Jaldi,
                    color = colorResource(id = R.color.chatmail_gray_color),
                    textAlign = TextAlign.End
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                    contentDescription = "Ícone de coração para favoritar o email.",
                    tint = colorResource(id = R.color.chatmail_gray_color)
                )
            }
        }
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed iaculis semper nibh, eget tincidunt nunc convallis vel. Cras feugiat erat vitae efficitur hendrerit. Aenean tristique ex posuere ligula accumsan ultrices. Ut suscipit justo orci, sit amet pulvinar ipsum pharetra quis.",
            fontFamily = Jaldi,
            color = colorResource(
                id = R.color.chatmail_gray_color
            )
        )
    }
    HorizontalDivider(color = colorResource(id = R.color.chatmail_gray_color), modifier = Modifier.padding(horizontal = 25.dp))
}