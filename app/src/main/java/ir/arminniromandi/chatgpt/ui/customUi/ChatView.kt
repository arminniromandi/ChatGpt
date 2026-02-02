package ir.arminniromandi.chatgpt.ui.customUi

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jeziellago.compose.markdowntext.MarkdownText
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.delay

@Composable
fun ChatView(
    message: Message,
    isLastItem: Boolean,
    isAnimationRunned: MutableState<Boolean>
) {



    val isFromUser = message.role == "user"
    var text by remember { mutableStateOf("") }
    var isTyping by remember { mutableStateOf(false) }



    if (!isFromUser && isLastItem && isAnimationRunned.value) {

        LaunchedEffect(message.content) {
            text = ""
            isTyping = true
            message.content.forEach { char ->
                text += char
                delay(30)
            }
            isTyping = false
            isAnimationRunned.value = false

        }
    } else {
        text = message.content
    }




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
        Column {
            if (isFromUser) {
                Text(
                    text = text,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    fontSize = 18.sp,
                    color = if (isFromUser) Color.White else Color.Black,
                )
            } else{




                MarkdownText(text ,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),

                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                        color = Color.Black,
                        fontSize = 18.sp
                    )

                )

            }

        }
    }
    if (isAnimationRunned.value and isFromUser and isLastItem) {
        TypingDots()
    }
}

@Composable
fun TypingDots() {
    val dotCount = rememberInfiniteTransition(label = "dots").animateValue(
        initialValue = 1,
        targetValue = 4,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "dotAnimation"
    )

    Text(
        text = "⬤".repeat(dotCount.value),
        fontSize = 10.sp,
        color = Color.Gray,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
    )
}
