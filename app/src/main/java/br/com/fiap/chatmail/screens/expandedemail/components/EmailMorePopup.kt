package br.com.fiap.chatmail.screens.expandedemail.components

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
fun EmailMorePopUp(
    expanded: MutableState<Boolean>, onReportSpam: () -> Unit, onDelete: () -> Unit
) {
    DropdownMenu(modifier = Modifier.background(color = colorResource(id = R.color.background_color)),
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }) {
        DropdownMenuItem(text = { Text("Reportar Spam") }, onClick = {
            onReportSpam()
            expanded.value = false
        }, leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_report_problem_24),
                contentDescription = "Ícone de um triângulo com um ponto de exclamação no centro",
            )
        })
        DropdownMenuItem(text = {
            Text(
                text = "Excluir", color = colorResource(id = R.color.chatmail_red_color)
            )
        }, onClick = {
            onDelete()
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
