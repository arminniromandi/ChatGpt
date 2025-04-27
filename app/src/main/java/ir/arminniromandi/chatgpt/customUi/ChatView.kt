package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.delay


@Composable
fun ChatView(message: Message, isLastItem: Boolean) {
    val isFromUser = message.role == "user"
    var text by remember { mutableStateOf("") }

    if (!isFromUser && isLastItem) {
        LaunchedEffect(message.content) {
            text = ""
            message.content.forEach { char ->
                text += char
                delay(50) // سرعت تایپ
            }
        }
    } else {
        text = message.content
    }


    // TODO: animate bubble chat item


    Box(
        modifier = Modifier
            .wrapContentWidth(
                align = if (isFromUser) Alignment.End else Alignment.Start
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(
                RoundedCornerShape(
                    topStart = if (isFromUser) 20.dp else 4.dp,
                    topEnd = if (isFromUser) 4.dp else 20.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(if (!isFromUser) Color(0xFFF4F4F5) else Color(0xFF3D3D3D))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            color = if (isFromUser) Color.White else Color.Black,
        )
    }
}


