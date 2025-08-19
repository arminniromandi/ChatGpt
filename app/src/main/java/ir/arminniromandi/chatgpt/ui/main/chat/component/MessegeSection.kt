package ir.arminniromandi.chatgpt.ui.main.chat.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.customUi.ChatView
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun MessageSection(viewModel: MainViewModel) {

    val error = viewModel.error.observeAsState().value
    if (error != null) {
        Log.i("error", error)
    }


    val listState = rememberLazyListState()


    /*val showScrollButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex < viewModel.allMessage.lastIndex - 5
        }
    }
*/
    val isAnimationRuned = viewModel.isAnimationRun



    Box(modifier = Modifier.fillMaxHeight(0.80f)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            state = listState,
            verticalArrangement = Arrangement.Top
        ) {

            itemsIndexed(viewModel.currentAllMessage) { index, massage ->
                val isLastItem by remember {
                    derivedStateOf { index == viewModel.currentAllMessage.lastIndex }
                }


                ChatView(massage, isLastItem, isAnimationRuned)


            }

        }

        /*AnimatedVisibility(
            showScrollButton,


            ) {

            FloatingActionButton(
                onClick = { listState.requestScrollToItem(viewModel.allMessage.lastIndex) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "Scroll to bottom")
            }

        }*/
    }

}