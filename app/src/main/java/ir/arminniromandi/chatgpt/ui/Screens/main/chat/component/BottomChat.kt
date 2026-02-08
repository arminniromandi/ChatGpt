package ir.arminniromandi.chatgpt.ui.main.chat.component

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.ui.Screens.main.chat.component.BoxChatInput
import ir.arminniromandi.chatgpt.viewmodel.ChatViewModel


@Composable
fun BottomChat(
    viewModel: ChatViewModel,
    modelSelected: String = "",
) {

    var text by remember { mutableStateOf("") }

    var isSmartModeEnable by remember {
        mutableStateOf(false)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        //data is here
        Log.i("file" , "file name is : $it")


    }


    BoxChatInput(
        modifier = Modifier,
        text = text,
        onTextChange = { text = it },
        isSmartModeEnable = isSmartModeEnable,
        smartModeChange = { isSmartModeEnable = it },
        sendButtonAction = {
            viewModel.saveMessageAndSendReq(text, modelSelected)
        },
        onClickFile = {
            launcher.launch("image/*")
            text = ""
            viewModel.showIntro.value = false

        }

    )


}












