package ir.arminniromandi.chatgpt.Fragment.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.customUi.ChatView
import ir.arminniromandi.chatgpt.transparent
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val introP = mutableStateOf(true)

@Composable
fun ChatPage(viewModel: MainViewModel) {

    val modelIndex = remember { mutableIntStateOf(0) }
    val chatItem = arrayOf("chatGpt" , "Gemeni")


    val massage = remember { mutableStateOf("") }



    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween


    ) {
        TopBar(chatItem, modelIndex)

        if (introP.value)
            Intro(chatItem[modelIndex.intValue])
        else
            ChatLayout(viewModel)

        TextBoxAndSend(massage ,viewModel )

    }


}

@Composable
private fun TopBar(chatItem: Array<String>, modelIndex: MutableIntState) {

    val expanded = remember { mutableStateOf(false) }
    val rotateAnimation = animateFloatAsState(
        targetValue = if (expanded.value) -180f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    Row(
        modifier = Modifier
            .clickable { expanded.value = !expanded.value }
            .fillMaxWidth()
            .padding(horizontal = 8.dp , vertical = 4.dp ),
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
                .wrapContentWidth()
                .padding(4.dp)
                .clip(RoundedCornerShape(60.dp))
                .background(white)
                .padding(vertical = 10.dp, horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier.wrapContentWidth()
                    .padding(horizontal = 8.dp)
                    .clickable { expanded.value = !expanded.value },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    chatItem[modelIndex.intValue],
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
                                    model
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
                text  ="hello and welcome to new Chat.",
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

@Composable
private fun ChatLayout(viewModel: MainViewModel) {
//    var text = remember { mutableStateOf("") }
//    text.value = viewModel.r.observeAsState().value.toString()

    ChatView(false , "")
}

@Composable
private fun TextBoxAndSend(text: MutableState<String> , viewModel: MainViewModel ) {

    Row(
        modifier = Modifier.fillMaxWidth()
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
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = transparent,
                unfocusedIndicatorColor = transparent,
                disabledIndicatorColor = transparent
            )
        )

        Image(
            painter = painterResource(R.drawable.send),
            contentDescription = "send",
            modifier = Modifier.size(58.dp)
                .clickable {
                    var req = ChatRequest( model = "gpt-3.5-turbo" , messages = listOf(Message("user" , text.value)))
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.sendReq(req)
                    }

                    text.value = ""
                    introP.value = false
                }
        )


    }

}






