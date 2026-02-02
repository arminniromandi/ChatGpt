package ir.arminniromandi.chatgpt.ui.customUi

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R



@Composable
fun MText(text: String, fontSize: Int, fontFamily: Int = R.font.satoshi_bold , color: Color) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize.sp,
            fontFamily = FontFamily(Font(fontFamily))
        )

    )
}
