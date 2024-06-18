package br.com.fiap.chatmail.screens.newemail.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun NewEmailHeader(navController: NavController) {
    var isPopupExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(top = 50.dp)
            .background(color = colorResource(id = R.color.background_color))
            .fillMaxWidth()
            .height(70.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Seta para esquerda, indicando ação de 'voltar'",
                tint = colorResource(id = R.color.chatmail_gray_color),
                modifier = Modifier
                    .size(30.dp)
                    .clickable { navController.popBackStack() })
            Icon(painter = painterResource(id = R.drawable.baseline_more_horiz_24),
                contentDescription = "Três pontos horizontais, indicando ação de 'mais'",
                tint = colorResource(id = R.color.chatmail_gray_color),
                modifier = Modifier
                    .size(35.dp)
                    .clickable { isPopupExpanded = true })
            NewEmailMorePopup(expanded = mutableStateOf(isPopupExpanded),
                onDiscardDraft = { /*TODO*/ })
        }
    }
}
