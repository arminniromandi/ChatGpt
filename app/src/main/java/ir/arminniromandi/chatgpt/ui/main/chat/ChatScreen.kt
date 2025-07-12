package ir.arminniromandi.chatgpt.ui.main.chat

import android.util.Log
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.arminniromandi.chatgpt.model.ai.AiModel
import ir.arminniromandi.chatgpt.ui.main.chat.component.BottomChat
import ir.arminniromandi.chatgpt.ui.main.chat.component.ChatHeader
import ir.arminniromandi.chatgpt.ui.main.chat.component.IntroSection
import ir.arminniromandi.chatgpt.ui.main.chat.component.MessageSection
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun ChatScreen(viewModel: MainViewModel = viewModel()) {

    val modelIndex = rememberSaveable { mutableIntStateOf(0) }
    val chatItem = AiModel.entries

    Log.i("test", "ChatScreen: ${chatItem[modelIndex.intValue].value} ")






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

        if (viewModel.showIntro.value) IntroSection(chatItem[modelIndex.intValue].value)
        else MessageSection(viewModel)

        BottomChat(viewModel,chatItem[modelIndex.intValue].value )


    }


}

@Preview
@Composable
private fun tgrdffdgdf() {
    ChatScreen(viewModel())

}