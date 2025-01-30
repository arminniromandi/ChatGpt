package ir.arminniromandi.chatgpt.Fragment.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.chatgpt.white


@Composable
fun ChatPage(viewModel: MainViewModel) {

    val modelIndex = remember { mutableIntStateOf(0) }
    val chatItem = arrayOf("chatGpt")

    val introP = remember { mutableStateOf(true) }

    val massage = remember { mutableStateOf("") }



    Column(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar(chatItem , modelIndex)

        if (introP.value)
            Intro()
        else
            ChatLayout()

        TextBoxAndSend(massage)

    }


}
@Composable
private fun TopBar(chatItem: Array<String>, modelIndex: MutableIntState) {

    val expanded = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.back),
            modifier = Modifier.size(51.dp),
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
                .padding(vertical = 10.dp , horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    chatItem[modelIndex.intValue],
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    fontSize = 18.sp
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowDown ,
                    contentDescription = "chose ai model"
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
private fun Intro(modelSelected : String = "ChatGpt") {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Icon(
            painter = painterResource(R.drawable.logo),
            modifier = Modifier.size(72.dp),
            contentDescription = "logo"
        )
        Spacer(Modifier.height(12.dp))

        Column(
            Modifier.fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "hello and welcome to new Chat."
            )

            Text(
                "Please chose your ai model from top."
            )

            Text(
                "Current Model : $modelSelected"
            )
        }


    }

}
@Composable
private fun ChatLayout() {

}

@Composable
private fun TextBoxAndSend(text :MutableState<String>) {

    Row(
        modifier = Modifier.fillMaxWidth()
    )
    {

    }

}




