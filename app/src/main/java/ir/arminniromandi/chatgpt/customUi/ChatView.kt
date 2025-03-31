package ir.arminniromandi.chatgpt.customUi

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import kotlinx.coroutines.flow.flow

@Composable
fun ChatView(fromUser: Boolean ,
             text : MutableState<String>
             ) {


    val fromUserOrNot = if (fromUser) "from User" else "from chat ai"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(
                topStart = if (fromUser) 4.dp else 20.dp,
                topEnd = if (fromUser) 20.dp else 4.dp,
                bottomStart = 20.dp,
                bottomEnd = 20.dp
            ))
            .background(if (!fromUser) Color(0xFFF4F4F5) else Color(0xFF3D3D3D))
            .padding(horizontal = 8.dp , vertical = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Text(
            text.value,
            modifier = Modifier.padding(horizontal = 12.dp , vertical = 8.dp),
            fontSize = 18.sp,
            color = if(fromUser) Color.White else Color.Black,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
            )


    }


}


@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun ChatPreview() {
    ChatView(false , mutableStateOf("hello gpt and i have Q can you answer?"))
}
@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun chatPreviewfromUser() {
    ChatView(true , mutableStateOf("hi this is gemeni and i am here to answer your Q " +
            "and you can answer"))
}