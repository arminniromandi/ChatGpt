package ir.arminniromandi.chatgpt.ui.main.chat

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.model.ai.AiModel
import ir.arminniromandi.chatgpt.ui.main.chat.component.BottomChat
import ir.arminniromandi.chatgpt.ui.main.chat.component.ChatHeader
import ir.arminniromandi.chatgpt.ui.main.chat.component.IntroSection
import ir.arminniromandi.chatgpt.ui.main.chat.component.MessageSection
import ir.arminniromandi.chatgpt.viewmodel.ChatViewModel
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun ChatScreen(
    viewModel: ChatViewModel,
    mainViewModel: MainViewModel,
    id: String
) {

    val chatItem = AiModel.entries

    SideEffect {
        Log.e("ChatScreen", "ChatScreen")
    }


    if (viewModel.currentAllMessage.isEmpty()) viewModel.showIntro.value = true


    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        ChatHeader(chatItem, viewModel) {
            mainViewModel.navigate(it)
        }


        if (viewModel.showIntro.value) IntroSection(chatItem[viewModel.selectedModel].value)
        else MessageSection(viewModel , Modifier
            .weight(1f)
            .fillMaxWidth())

        BottomChat(viewModel, chatItem[viewModel.selectedModel].value)


    }


}
