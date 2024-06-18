package br.com.fiap.chatmail.screens.newemail.components

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import br.com.fiap.chatmail.R

@Composable
fun NewEmailMorePopup(
    expanded: MutableState<Boolean>, onDiscardDraft: () -> Unit
) {
    DropdownMenu(modifier = Modifier.background(color = colorResource(id = R.color.background_color)),
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }) {
        DropdownMenuItem(text = {
            Text(
                text = "Descartar rascunho", color = colorResource(id = R.color.chatmail_red_color)
            )
        }, onClick = {
            onDiscardDraft()
            expanded.value = false
        }, leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Ícone de uma lixeira",
                tint = colorResource(id = R.color.chatmail_red_color)
            )
        })
    }
}