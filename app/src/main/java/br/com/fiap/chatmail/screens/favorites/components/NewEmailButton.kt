package br.com.fiap.chatmail.screens.favorites.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R

@Composable
fun NewEmailButton(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = {
            navController.navigate("newemail")
        },
        modifier = modifier
            .size(75.dp),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = colorResource(id = R.color.primary_color),
            contentColor = colorResource(id = R.color.chatmail_white_color)
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.5.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.transparent)),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_edit_square_24),
            contentDescription = "Ícone de lápis sobre um quadrado representando 'novo email'",
            Modifier.size(35.dp)
        )
    }
}