package ir.arminniromandi.chatgpt.ui.chat.component

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.customUi.ChatView
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun MessageSection(viewModel: MainViewModel) {

    val error = viewModel.error.observeAsState().value
    if (error != null) {
        Log.i("error", error)
    }


    val listState = rememberLazyListState()


    val showScrollButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex < viewModel.allMessage.lastIndex - 5
        }
    }

    val isAnimationRuned = viewModel.isAnimationRun



    Box(modifier = Modifier.fillMaxHeight(0.80f)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            state = listState,
            verticalArrangement = Arrangement.Top
        ) {

            itemsIndexed(viewModel.allMessage) { index, massage ->
                val isLastItem by remember {
                    derivedStateOf { index == viewModel.allMessage.lastIndex }
                }


                ChatView(massage, isLastItem, isAnimationRuned)


            }

        }

        AnimatedVisibility(
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

        }
    }

}