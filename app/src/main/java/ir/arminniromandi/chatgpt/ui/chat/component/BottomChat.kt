package ir.arminniromandi.chatgpt.ui.chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.Tool.util.TextDirectionUtil.getTextDirection
import ir.arminniromandi.chatgpt.gray_400
import ir.arminniromandi.chatgpt.gray_600
import ir.arminniromandi.chatgpt.model.AiModel
import ir.arminniromandi.chatgpt.textFieldColor
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.chatgpt.white


@Composable
fun BottomChat(
    viewModel: MainViewModel,
    modelSelected: AiModel,
) {

    val text = remember { mutableStateOf("") }
    val textDirection = remember {
        getTextDirection(text.value)
    }
    val showOverlay = remember {
        mutableStateOf(false)
    }
    val isConnect = viewModel.isConnected.collectAsState()


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        var isFocused by remember { mutableStateOf(false) }

        BasicTextField(
            value = text.value, modifier = Modifier
                .fillMaxWidth(0.8f)
                .onFocusChanged {
                    isFocused = it.isFocused

                }
                .padding(horizontal = 12.dp)
                .clip(CircleShape)
                .background(textFieldColor)
                .border(
                    1.dp, gray_600, CircleShape
                )
                .padding(2.dp), onValueChange = {
                text.value = it
            }, textStyle = TextStyle(
                color = white, textDirection = textDirection

            ), decorationBox = { innerTextField ->

                Box(modifier = Modifier.padding(16.dp)) {
                    if (text.value.isEmpty()) Text(
                        "Type Your Question...", color = gray_400
                    )

                }

                innerTextField()

            }


        )


        IconButton(
            enabled = !text.value.isEmpty(), onClick = {
                if (isConnect.value) {

                    viewModel.saveMessageAndSendReq(text.value, modelSelected.value , modelSelected.isLiara)
                    text.value = ""
                    viewModel.showIntro.value = false
                } else showOverlay.value = true
            }) {
            Image(
                painter = painterResource(R.drawable.send),

                contentDescription = "send", modifier = Modifier.size(58.dp)

            )
        }


    }
}










