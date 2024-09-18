package br.com.fiap.chatmail.screens.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R

@Composable
fun SettingPopup(
    expanded: MutableState<Boolean>,
    onDarkModeSelected: () -> Unit,
    onLightModeSelected: () -> Unit
) {
    DropdownMenu(
        modifier = Modifier.background(color = colorResource(id = R.color.background_color)),
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }
    ) {
        DropdownMenuItem(
            text = {
                Text(
                    text = "Modo Escuro",
                    color = colorResource(id = R.color.chatmail_black_color),
                    fontSize = 16.sp
                )
            },
            onClick = {
                onDarkModeSelected()
                expanded.value = false
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.modoescuro),
                    contentDescription = "Ícone do Modo Escuro",
                    tint = colorResource(id = R.color.chatmail_black_color),
                    modifier = Modifier.size(20.dp)
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Modo Claro",
                    color = colorResource(id = R.color.chatmail_black_color),
                    fontSize = 16.sp

                )
            },
            onClick = {
                onLightModeSelected()
                expanded.value = false
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.modoclaro),
                    contentDescription = "Ícone do Modo Claro",
                    tint = colorResource(id = R.color.chatmail_black_color),
                    modifier = Modifier.size(20.dp)

                )
            }
        )
    }
}
