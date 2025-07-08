package ir.arminniromandi.chatgpt.ui.main.chat

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.arminniromandi.chatgpt.model.AiModel
import ir.arminniromandi.chatgpt.ui.main.chat.component.BottomChat
import ir.arminniromandi.chatgpt.ui.main.chat.component.ChatHeader
import ir.arminniromandi.chatgpt.ui.main.chat.component.IntroSection
import ir.arminniromandi.chatgpt.ui.main.chat.component.MessageSection
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun ChatScreen(viewModel: MainViewModel = viewModel()) {

    val modelIndex = remember { mutableIntStateOf(0) }
    val chatItem = AiModel.entries
    val model by remember {
        mutableStateOf(chatItem[modelIndex.intValue])
    }






    if (viewModel.allMessage.isEmpty()) viewModel.showIntro.value = true


    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize()
            .scrollable(rememberScrollState(), Orientation.Vertical),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        ChatHeader(chatItem, modelIndex, viewModel) {
            viewModel.navigate(it)
        }

        if (viewModel.showIntro.value) IntroSection(model.value)
        else MessageSection(viewModel)

        BottomChat(viewModel, model)


    }


}

@Preview
@Composable
private fun tgrdffdgdf() {
    ChatScreen(viewModel())

}