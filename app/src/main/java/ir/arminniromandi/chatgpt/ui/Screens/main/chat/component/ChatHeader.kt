package ir.arminniromandi.chatgpt.ui.main.chat.component

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import ir.arminniromandi.chatgpt.customUi.AlertDialogYesNo
import ir.arminniromandi.chatgpt.model.ai.AiModel
import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
import ir.arminniromandi.chatgpt.ui.theme.black
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.chatgpt.viewmodel.ChatViewModel
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier
import kotlin.enums.EnumEntries

@Composable
fun ChatHeader(
    chatItem: EnumEntries<AiModel>,
    viewModel: ChatViewModel,
    onRoute: (String) -> Unit
) {



    val dialogState = remember {
        mutableStateOf(false)
    }


    if (dialogState.value) AlertDialogYesNo(dialogState) {
        viewModel.deleteChat()
    }


    Row(
        modifier = Modifier

            .fillMaxWidth()

            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


        SmallFloatingActionButton(
            { onRoute(MainScreens.Main.screenName) },
            shape = CircleShape,
            containerColor = white
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                tint = black,
                modifier = Modifier.padding(10.dp),
                contentDescription = "Back"
            )
        }



        Text(
            if (viewModel.showIntro.value) "NewChat" else "",
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 18.sp,
            color = white
        )

        if (viewModel.showIntro.value) {


            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(4.dp)
                    .clip(RoundedCornerShape(60.dp))
                    .background(white)
                    .padding(vertical = 10.dp, horizontal = 8.dp)) {
                ModelSelecrtor(chatItem, viewModel)

            }
        } else SmallFloatingActionButton(
            onClick = {
                dialogState.value = true

            },
            containerColor = white,
            shape = CircleShape,
            contentColor = white

        ) {


            Icon(
                painter = painterResource(R.drawable.trash),
                modifier = FloatingActionButtonModifier,
                tint = Color.Black,
                contentDescription = "delete Chat",
            )


        }
    }


}





@Composable
fun ModelSelecrtor(
    chatItem: EnumEntries<AiModel>,
    viewModel: ChatViewModel,
) {
    val expanded = remember { mutableStateOf(false) }

    val rotateAnimation = animateFloatAsState(
        targetValue = if (expanded.value) -180f else 0f,
        animationSpec = tween(300)
    )
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .padding(horizontal = 8.dp)
            .clickable { expanded.value = !expanded.value },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            chatItem[viewModel.selectedModel].value,
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

        DropdownMenu(
            expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.background(white),

            )
        {


            chatItem.forEachIndexed { index, model ->

                DropdownMenuItem(

                    text = {
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                model.value,
                                color = black
                            )
                            Spacer(Modifier.width(4.dp))
                            Image(
                                painter = painterResource(model.icon),
                                contentDescription = model.name,

                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }, onClick = {
                        expanded.value = false
                        viewModel.setModel(index)

                    },
                    //todo: add all colors to this section
                    colors = MenuItemColors(
                        black,
                        leadingIconColor = black,
                        trailingIconColor = black,
                        disabledLeadingIconColor = black,
                        disabledTrailingIconColor = black,
                        disabledTextColor = black
                    )
                )


            }
        }


    }
}



