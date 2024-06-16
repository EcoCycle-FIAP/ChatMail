package br.com.fiap.chatmail.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R

@Composable
fun ChatScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .background(colorResource(id = R.color.background_color))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(color = colorResource(id = R.color.background_color)),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            UserInfoHeader()
            Column(modifier = Modifier.weight(1f)) {
                MessageCard(
                    message = "Modificações no sistema da empresa\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Ut faucibus at arcu ut luctus. In hac habitasse platea dictumst.",
                    isSentByUser = false,
                    timestamp = "Hoje: 15:20",
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(colorResource(id = R.color.chatmail_lightgray_color), RoundedCornerShape(28.dp))
                        .padding(16.dp)
                ) {
                    // Send button placeholder
                    // You can replace it with an actual icon if needed
                    Image(
                        painter = painterResource(id = R.drawable.paper_clip),
                        contentDescription = "Anexar arquivos",
                        modifier = Modifier
                            .clickable { }
                            .size(50.dp),
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.chatmail_gray_color))
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .height(56.dp)
                        .background(colorResource(id = R.color.chatmail_lightgray_color), RoundedCornerShape(8.dp))
                ) {
                    // Input area placeholder
                    Text(
                        text = "Digite aqui...",
                        color = colorResource(id = R.color.chatmail_gray_color),
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(color = colorResource(id = R.color.primary_color), RoundedCornerShape(28.dp))
                        .padding(16.dp)
                ) {
                    // Send button placeholder
                    // You can replace it with an actual icon if needed
                    Image(
                        painter = painterResource(id = R.drawable.sending),
                        contentDescription = "Enviar mensagem",
                        modifier = Modifier
                            .clickable { }
                            .size(50.dp),
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.chatmail_white_color))
                    )
                }
            }
        }

    }
}

@Composable
fun UserInfoHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Voltar",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.account),
            contentDescription = "Foto de Daniel Clemente",
            modifier = Modifier
                .size(40.dp)
                .background(colorResource(id = R.color.chatmail_white_color), CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Daniel Clemente",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f),
            color = colorResource(id = R.color.chatmail_black_color)
        )
    }
}

@Composable
fun MessageCard(message: String, isSentByUser: Boolean, timestamp: String) {
    val backgroundColor = if (isSentByUser) colorResource(id = R.color.primary_color) else colorResource(id = R.color.chatmail_lightgray_color)
    val alignment = if (isSentByUser) Alignment.End else Alignment.Start
    val textColor = if (isSentByUser) colorResource(id = R.color.chatmail_white_color) else colorResource(id = R.color.chatmail_black_color)

    Column(
        horizontalAlignment = alignment,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (!isSentByUser) {
            if (timestamp.isNotEmpty()) {
                Text(
                    text = timestamp,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.chatmail_gray_color),
                    modifier = Modifier.padding(start = 140.dp, top = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Box(
            modifier = Modifier
                .background(backgroundColor, RoundedCornerShape(8.dp))
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .widthIn(max = 200.dp)
                .align(if (isSentByUser) Alignment.End else Alignment.Start)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = message,
                    color = textColor,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "Veja mais",
                    modifier = Modifier.size(24.dp),
                    colorFilter = if (isSentByUser) ColorFilter.tint(colorResource(id = R.color.chatmail_white_color)) else null
                )
            }
        }
    }
}
