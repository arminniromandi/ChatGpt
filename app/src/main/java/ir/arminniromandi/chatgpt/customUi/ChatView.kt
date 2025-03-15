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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import kotlinx.coroutines.flow.flow

@Composable
fun ChatView(fromUser: Boolean ,
             text : String,

             ) {


    val fromUserOrNot = if (fromUser) "from User" else "from chat ai"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(if (!fromUser) Color(0xFFF4F4F5) else Color(0xFF161616))
            .padding(horizontal = 10.dp , vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            "this is a text from $fromUserOrNot and this is a text",
            modifier = Modifier.padding(horizontal = 12.dp , vertical = 8.dp),
            fontSize = 18.sp,
            color = if(fromUser) Color.White else Color.Black,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
            )


    }


}

fun showText(){

}

@Preview
@Composable
private fun ChatPreview() {
    ChatView(false ,"")
}
@Preview
@Composable
private fun chatPreviewfromUser() {
    ChatView(true ,"")
}