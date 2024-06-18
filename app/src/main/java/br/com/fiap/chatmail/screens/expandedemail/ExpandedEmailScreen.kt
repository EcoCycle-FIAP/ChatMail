package br.com.fiap.chatmail.screens.expandedemail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chatmail.R
import br.com.fiap.chatmail.screens.expandedemail.components.ExpandedEmailFooter
import br.com.fiap.chatmail.screens.expandedemail.components.ExpanedEmailHeader

@Composable
fun ExpandedEmailScreen(navController: NavController) {
    Scaffold(
        topBar = { ExpanedEmailHeader(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(color = colorResource(id = R.color.chatmail_lightgray_color))
                    .fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                        contentDescription = "Avatar do usuário",
                        modifier = Modifier.size(65.dp),
                        tint = colorResource(id = R.color.chatmail_green_color)
                    )
                    Column {
                        Text(
                            text = "Nome Do Usuário", fontSize = 18.sp, fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "XXt atrás",
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.chatmail_gray_color)
                        )
                    }
                    Text(
                        text = "emaildousuario@email.com", fontSize = 12.sp, color = colorResource(
                            id = R.color.chatmail_gray_color
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    Text(
                        text = "Assunto do Email",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 25.dp)
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vitae porttitor turpis. Quisque convallis urna id turpis interdum feugiat. Fusce commodo vehicula nisi, euismod volutpat eros laoreet nec. Aenean pellentesque et nunc vel cursus. Cras ex magna, ultrices a nunc quis, vestibulum maximus felis. In ac dolor molestie risus viverra posuere a sit amet metus. Donec porta dictum leo, in scelerisque leo pharetra quis. In convallis nulla auctor lectus posuere, in auctor eros rutrum. Proin in commodo turpis. Ut et finibus velit. Fusce tristique mi sed nunc maximus sollicitudin at vitae diam. Cras at justo sagittis, auctor diam id, eleifend tortor. Proin volutpat velit nec pretium efficitur. Nullam id mattis arcu. Aenean ornare est eget ornare ultricies. Aenean lacus erat, malesuada et magna quis, posuere auctor lacus.\n" + "\n" + "Nullam quis ante in libero iaculis luctus. Curabitur ut nisl non lacus tempor suscipit sed nec sem. Proin vitae molestie mauris. Aliquam semper, felis sed faucibus pulvinar, erat massa ultricies mi, vel convallis ligula libero at leo. Nam augue nisl, consequat eget auctor sed, porttitor id urna. In dolor lacus, fermentum ac turpis sed, gravida molestie magna. Aliquam dictum dui ante, sed euismod erat feugiat vitae. Donec elementum in enim vel finibus. Phasellus quis scelerisque sapien. Maecenas vitae sodales magna. Maecenas tempus ante id consectetur egestas. Aliquam sagittis vehicula enim vel finibus. Suspendisse ornare urna quam. Praesent venenatis, mauris ut bibendum lobortis, tortor velit scelerisque erat, non feugiat eros orci nec diam. Curabitur in dapibus nibh, quis vestibulum lectus. Nam venenatis justo nec luctus dapibus.\n" + "\n" + "Etiam euismod urna in hendrerit pretium. In ut leo vel erat facilisis gravida. Integer quis mattis nisl, non pharetra sem. Nullam eget ante accumsan, commodo enim id, dignissim nunc. Proin id ligula blandit, lacinia nunc nec, tristique ex. Etiam ullamcorper cursus neque sit amet tempus. Suspendisse commodo fermentum lorem et facilisis. Integer ut arcu sapien. Etiam et enim odio. Maecenas interdum nisi id vehicula volutpat.\n" + "\n" + "Aliquam malesuada et turpis a tempus. Curabitur at metus in libero hendrerit pellentesque. Suspendisse finibus tellus sit amet orci mattis, vitae mollis justo mattis. Quisque et nulla massa. Integer ullamcorper, tortor ut efficitur varius, urna massa tempus leo, at molestie ante mauris vel est. Sed scelerisque in libero et condimentum. Integer nec urna id ipsum tincidunt imperdiet vitae non dui. Nulla porta neque id turpis posuere venenatis. Nunc aliquam arcu ut turpis fermentum, in rhoncus turpis lobortis. Pellentesque eget dui auctor, aliquet ligula non, semper enim. Mauris sit amet dignissim ex. Maecenas consequat ornare turpis et auctor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam pellentesque auctor lorem eget pharetra.",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.chatmail_gray_color)
                    )
                }
            }
        },
        bottomBar = { ExpandedEmailFooter(navController) },
    )
}