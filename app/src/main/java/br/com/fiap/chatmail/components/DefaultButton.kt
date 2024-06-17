package br.com.fiap.chatmail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import br.com.fiap.chatmail.R

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    width: Int? = 300,
    height: Int? = 55,
    containerColor: Int? = R.color.primary_color,
    contentColor: Int? = R.color.chatmail_white_color,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(defaultElevation = 2.5.dp),
    contentPadding: PaddingValues? = ButtonDefaults.ContentPadding
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .width(width?.dp ?: 300.dp)
            .height(height?.dp ?: 55.dp),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = colorResource(id = containerColor!!), contentColor = colorResource(
                id = contentColor!!
            )
        ),
        elevation = elevation,
        border = BorderStroke(1.dp, colorResource(id = R.color.transparent)),
        contentPadding = contentPadding ?: ButtonDefaults.ContentPadding
    ) {
        content()
    }
}