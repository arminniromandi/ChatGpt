package ir.arminniromandi.chatgpt.ui.main.chat.component

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.ext.util.TextDirectionUtil.getTextDirection
import ir.arminniromandi.chatgpt.ui.theme.Typography
import ir.arminniromandi.chatgpt.ui.theme.gray_400
import ir.arminniromandi.chatgpt.ui.theme.gray_600
import ir.arminniromandi.chatgpt.ui.theme.textFieldColor
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.chatgpt.viewmodel.ChatViewModel
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier


@Composable
fun BottomChat(
    viewModel: ChatViewModel,
    modelSelected: String = "",
) {
    //todo : handle new Bottom Chat

    val text = remember { mutableStateOf("") }
    val textDirection by remember(text.value) {
        mutableStateOf(getTextDirection(text.value))
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        val textFieldAnimate = animateIntAsState(
            if(text.value.length > 25)25 else 100
        )


        val textAlign = if (textDirection == TextDirection.Rtl) TextAlign.End else TextAlign.Start

        BasicTextField(
            value = text.value,
            onValueChange = { text.value = it },
            modifier = Modifier
                .weight(0.85f)
                .clip(RoundedCornerShape(textFieldAnimate.value))
                .background(textFieldColor)
                .padding(12.dp),
            textStyle = TextStyle(
                color = white,
                textDirection = textDirection,
                textAlign = textAlign,
                fontSize = Typography.titleMedium.fontSize
            ),
            decorationBox = { innerTextField ->
                Box(Modifier.fillMaxWidth()) {
                    if (text.value.isEmpty()) {
                        Text(
                            "Type Your Question...",
                            color = gray_400,
                            textAlign = textAlign,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    innerTextField()
                }
            }
        )


        Spacer(Modifier.width(8.dp))


        SmallFloatingActionButton(
            modifier = Modifier,
            containerColor = white,
            onClick = {

                    viewModel.saveMessageAndSendReq(
                        text.value,
                        modelSelected,
                    )
                    text.value = ""
                    viewModel.showIntro.value = false
            }) {
            Image(
                imageVector = Icons.AutoMirrored.Outlined.Send,

                contentDescription = "send", modifier = FloatingActionButtonModifier

            )
        }


    }

}













