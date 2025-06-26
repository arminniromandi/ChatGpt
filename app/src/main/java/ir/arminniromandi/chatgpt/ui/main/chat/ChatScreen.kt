package ir.arminniromandi.chatgpt.ui.main.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.model.AiModel
import ir.arminniromandi.chatgpt.ui.chat.component.BottomChat
import ir.arminniromandi.chatgpt.ui.chat.component.ChatHeader
import ir.arminniromandi.chatgpt.ui.chat.component.IntroSection
import ir.arminniromandi.chatgpt.ui.chat.component.MessageSection
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun ChatScreen(viewModel: MainViewModel) {

    val modelIndex = remember { mutableIntStateOf(0) }
    val chatItem = AiModel.entries
    val model by remember {
        mutableStateOf(chatItem[modelIndex.intValue])
    }






    if (viewModel.allMessage.isEmpty()) viewModel.showIntro.value = true

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        ChatHeader(chatItem, modelIndex, viewModel){
            viewModel.navigate(it)
        }

        if (viewModel.showIntro.value) IntroSection(model.value)
        else MessageSection(viewModel)

        BottomChat(viewModel, model)


    }

}