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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
fun ChatScreenSending() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            UserInfo()
            Column(modifier = Modifier.weight(1f)) {
                MessageCards(
                    message = "Modificações no sistema da empresa\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Ut faucibus at arcu ut luctus. In hac habitasse platea dictumst.",
                    isSentByUser = false,
                    timestamp = "Hoje: 15:20",
                )
                Spacer(modifier = Modifier.height(8.dp))
                MessageCards(
                    message = "Modificação concluída com sucesso\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Ut faucibus at arcu ut luctus. In hac habitasse platea dictumst.",
                    isSentByUser = true,
                    timestamp = ""
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            MaterialTheme.colorScheme.secondary,
                            RoundedCornerShape(28.dp)
                        )
                        .padding(16.dp)
                ) {
                    // Send button placeholder
                    // You can replace it with an actual icon if needed
                    Image(
                        painter = painterResource(id = R.drawable.paper_clip),
                        contentDescription = "Paper Clip",
                        modifier = Modifier
                            .clickable { }
                            .size(50.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary)
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .height(56.dp)
                        .background(
                            MaterialTheme.colorScheme.secondary,
                            RoundedCornerShape(8.dp)
                        )
                ) {
                    // Input area placeholder
                    Text(
                        text = "Digite aqui...",
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            RoundedCornerShape(28.dp)
                        )
                        .padding(16.dp)
                ) {
                    // Send button placeholder
                    // You can replace it with an actual icon if needed
                    Image(
                        painter = painterResource(id = R.drawable.sending),
                        contentDescription = "Sending",
                        modifier = Modifier
                            .clickable { }
                            .size(50.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
                    )
                }
            }
        }

    }
}

@Composable
fun UserInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Voltar",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.account),
            contentDescription = "Foto de Daniel Clemente",
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.background, CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Daniel Clemente",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
fun MessageCards(message: String, isSentByUser: Boolean, timestamp: String) {
    val backgroundColor =
        if (isSentByUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
    val alignment = if (isSentByUser) Alignment.End else Alignment.Start
    val textColor =
        if (isSentByUser) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSecondary

    Column(
        horizontalAlignment = alignment, modifier = Modifier.fillMaxWidth()
    ) {
        if (!isSentByUser) {
            if (timestamp.isNotEmpty()) {
                Text(
                    text = timestamp,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSecondary,
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
                    text = message, color = textColor, modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "Veja mais",
                    modifier = Modifier.size(24.dp),
                    colorFilter = if (isSentByUser) ColorFilter.tint(MaterialTheme.colorScheme.background) else null
                )
            }
        }
    }
}

@Preview
@Composable
private fun ChatScreenSendingPreview() {
    ChatScreenSending()
}