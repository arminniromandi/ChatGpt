package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun ChatView(massage: Message) {


    val isFromUser = massage.role == "user"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(
                RoundedCornerShape(
                    topStart = if (isFromUser) 4.dp else 20.dp,
                    topEnd = if (isFromUser) 20.dp else 4.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(if (!isFromUser) Color(0xFFF4F4F5) else Color(0xFF3D3D3D))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Text(
            massage.content,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            fontSize = 18.sp,
            color = if (isFromUser) Color.White else Color.Black,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )


    }


}


