package br.com.fiap.chatmail.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.screens.settings.components.SettingPopup
import br.com.fiap.chatmail.ui.theme.Jaldi

@SuppressLint("UnrememberedMutableState")
@Composable
fun UserHeader(onToggleTheme: () -> Unit) {

    var isPopupExpanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .background(color = MaterialTheme.colorScheme.background),
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
        ConstraintLayout(
            modifier = Modifier.align(Alignment.CenterVertically)
        ){
            val menu = createRef()
            IconButton(
                onClick = onToggleTheme,
                modifier = Modifier
                    .constrainAs(menu){
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.config),
                    contentDescription = "Engrenagem",
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}
