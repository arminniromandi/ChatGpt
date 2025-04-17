package ir.arminniromandi.chatgpt.Fragment.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.customUi.ChatView
import ir.arminniromandi.chatgpt.model.AiModel
import ir.arminniromandi.chatgpt.model.Role
import ir.arminniromandi.chatgpt.transparent
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlin.enums.EnumEntries

val introP = mutableStateOf(true)


// assistant


@Composable
fun ChatPage(viewModel: MainViewModel) {

    val modelIndex = remember { mutableIntStateOf(0) }
    val chatItem = AiModel.entries



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar(chatItem, modelIndex)

        if (introP.value)
            Intro(chatItem[modelIndex.intValue].value)
        else
            ChatLayout(viewModel)

        TextBoxAndSend(viewModel ,chatItem[modelIndex.intValue].value )

    }


}

@Composable
private fun TopBar(chatItem: EnumEntries<AiModel>, modelIndex: MutableIntState) {

    val expanded = remember { mutableStateOf(false) }
    val rotateAnimation = animateFloatAsState(
        targetValue = if (expanded.value) -180f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    Row(
        modifier = Modifier

            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.back),
            modifier = Modifier.size(48.dp),
            contentDescription = "Back"
        )

        Text(
            "New Chat",
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 18.sp,
            color = white
        )


        Box(
            modifier = Modifier
                .clickable { expanded.value = !expanded.value }
                .wrapContentWidth()
                .padding(4.dp)
                .clip(RoundedCornerShape(60.dp))
                .background(white)
                .padding(vertical = 10.dp, horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 8.dp)
                    .clickable { expanded.value = !expanded.value },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    chatItem[modelIndex.intValue].value,
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "chose ai model",
                    tint = black,
                    modifier = Modifier
                        .clickable { expanded.value = !expanded.value }
                        .rotate(rotateAnimation.value)

                )
            }

            DropdownMenu(
                expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {

                chatItem.forEachIndexed { index, model ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                model.value
                            )
                        },
                        onClick = {
                            expanded.value = false
                            modelIndex.intValue = index

                        }
                    )
                }
            }
        }
    }


}

@Composable
private fun Intro(modelSelected: String = "ChatGpt") {

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(R.drawable.logo),
            modifier = Modifier.size(72.dp),
            contentDescription = "logo"
        )
        Spacer(Modifier.height(12.dp))

        Column(
            Modifier

                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "hello and welcome to new Chat.",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),

                )

            Text(
                "Please chose your ai model from top.",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),

                )

            Text(
                "Current Model : $modelSelected",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),

                )
        }


    }

}


@SuppressLint("SuspiciousIndentation", "CoroutineCreationDuringComposition")
@Composable
private fun ChatLayout(viewModel: MainViewModel) {


    var content = viewModel.chatResponse.observeAsState().value?.choices?.get(0)?.message?.content

    if (!content.isNullOrEmpty())
        viewModel.allMessage.add(Message(Role.Assistant.value, content))


    val error = viewModel.error.value
    if (error != null) {
        Log.i("error", error)
    }

    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState,
        verticalArrangement = Arrangement.Top
    ) {

        itemsIndexed(viewModel.allMessage) {index , massage ->
            val isLastItem by remember{
                derivedStateOf{index == viewModel.allMessage.lastIndex}
            }
            ChatView(massage , isLastItem)


        }

    }


}

@Composable
private fun TextBoxAndSend(
    viewModel: MainViewModel,
    modelSelected: String
) {

    val text = remember { mutableStateOf("") }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {


        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },

            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(50.dp),
            label = {
                Text("Type your question ...")
            },
            maxLines = 10,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = transparent,
                unfocusedIndicatorColor = transparent,
                disabledIndicatorColor = transparent
            )
        )

        Image(
            painter = painterResource(R.drawable.send),
            contentDescription = "send",
            modifier = Modifier
                .size(58.dp)
                .clickable {

                    viewModel.saveMessageAndSendReq(text.value , modelSelected)

                    text.value = ""
                    introP.value = false
                }
        )
    }
}








