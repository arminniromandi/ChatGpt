package ir.arminniromandi.chatgpt.ui.main.chat.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.ui.customUi.ChatView
import ir.arminniromandi.chatgpt.viewmodel.ChatViewModel
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.launch

@Composable
fun MessageSection(viewModel: ChatViewModel, modifier: Modifier) {

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
    val items = viewModel.currentAllMessage



    Box(
        modifier = modifier

    ) {


        LazyColumn(
            modifier = modifier,
            state = listState,
            verticalArrangement = Arrangement.Top
        ) {

            itemsIndexed(items ) { index, massage ->
                val isLastItem by remember {
                    derivedStateOf { index == viewModel.currentAllMessage.lastIndex }
                }


                ChatView(massage, isLastItem, isAnimationRuned)


            }

        }

        val showScrollToBottom by remember {
            derivedStateOf {
                val lastVisible = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
                val lastIndex = listState.layoutInfo.totalItemsCount - 1
                lastVisible < lastIndex
            }
        }


        val scope = rememberCoroutineScope()
        AnimatedVisibility(
            visible = showScrollToBottom,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut(),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 50.dp)
        ) {
            SmallFloatingActionButton(
                onClick = {
                     scope.launch{
                        listState.animateScrollToItem(items.lastIndex)
                    }
                },
                containerColor = Color(0xFFFFFFFF)
            ) {
                androidx.compose.material3.Icon(
                    Icons.Default.ArrowDownward,
                    contentDescription = "Scroll to bottom",
                    tint = Color.Black
                )
            }
        }
    }


}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun MessageSectionTest() {
    val listState = rememberLazyListState()


    /*val showScrollButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex < viewModel.allMessage.lastIndex - 5
        }
    }
*/
    val isAnimationRuned = mutableStateOf(true)


    Box(
        modifier = Modifier.fillMaxSize()

    ) {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState,
            verticalArrangement = Arrangement.Top
        ) {

            items(33){
                ChatView(Message("user", "hi"), it ==33, isAnimationRuned)
            }

        }

        val showButton by remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 1
            }
        }

        val scope = rememberCoroutineScope()
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut(),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        ) {
            SmallFloatingActionButton(
                onClick = {
                    scope.launch{
                        listState.animateScrollToItem(32)
                    }

                },
                containerColor = Color(0xFF00897B)
            ) {
                androidx.compose.material3.Icon(
                    Icons.Default.ArrowDownward,
                    contentDescription = "Scroll to bottom",
                    tint = Color.White
                )
            }
        }
    }



}



