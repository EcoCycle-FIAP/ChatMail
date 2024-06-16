package br.com.fiap.chatmail.screens.chatscreenmail.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PopUpRemetente() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))
            .padding(vertical = 30.dp, horizontal = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Modificações no sistema da Empresa",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut faucibus at arcu ut luctus. In hac habitasse platea dictumst. Vestibulum interdum tortor magna, euismod interdum ex pretium vitae. Quisque scelerisque justo dui, ac bibendum nibh dictum eu. Sed non viverra est. Nullam id erat mollis, egestas eros sed, egestas mauris.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "In malesuada lectus sed odio placerat varius. Aenean efficitur iaculis metus, a consequat neque gravida at. Quisque diam enim, aliquam eu ultricies nec, porta ut ante. Cras vestibulum, magna sed venenatis consectetur, odio tortor pretium nisi, nec ornare leo odio ut augue. Praesent eget auctor urna, non dapibus massa.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Fusce tincidunt lectus eu metus eleifend fringilla. Sed consequat viverra metus iaculis facilisis. Curabitur ac aliquam tortor, sed lacinia quam. Nulla lobortis eros id consequat fringilla. Nunc bibendum ex sed pharetra pellentesque. Donec in tellus enim. Vivamus a purus a dui varius porttitor",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Att: dclemente@gmail.com",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right,
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PopUpRemetentePreview() {
    PopUpRemetente()
}
