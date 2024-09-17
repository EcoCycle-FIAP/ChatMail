package br.com.fiap.chatmail.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.screens.settings.components.SettingPopup
import br.com.fiap.chatmail.ui.theme.Jaldi

@SuppressLint("UnrememberedMutableState")
@Composable
fun UserHeader() {
    var isPopupExpanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .background(color = colorResource(id = R.color.background_color)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "Avatar do usuário",
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Nome do Usuário", fontSize = 22.sp, fontFamily = Jaldi)
        }

        // Ícone da engrenagem clicável
        Icon(
            painter = painterResource(id = R.drawable.config), // Usando a imagem config.png
            contentDescription = "Configurações",
            modifier = Modifier
                .size(24.dp)
                .clickable { isPopupExpanded = true } // Abre o popup de configurações
        )

        // Exibe o popup
        SettingPopup(
            expanded = mutableStateOf(isPopupExpanded),
            onDarkModeSelected = { /* Handle dark mode selection */ },
            onLightModeSelected = { /* Handle light mode selection */ }
        )
    }
}
