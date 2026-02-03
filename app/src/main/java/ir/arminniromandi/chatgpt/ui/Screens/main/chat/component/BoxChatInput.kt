package ir.arminniromandi.chatgpt.ui.Screens.main.chat.component

import android.R.attr.textDirection
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.ext.util.TextDirectionUtil.getTextDirection
import ir.arminniromandi.chatgpt.ui.theme.gray_400

@Composable
fun BoxChatInput(
    modifier: Modifier,
    text: String,
    onTextChange: (String) -> Unit = {},
    isSmartModeEnable: Boolean = false,
    smartModeChange: (Boolean) -> Unit = {},
    sendButtonAction: () -> Unit={},
    onClickFile: ()->Unit = {}
) {


    val isSendButtonEnable by remember(text) {
        derivedStateOf { text.isNotBlank() }
    }

    val textDirection = remember(text) {
        getTextDirection(text)
    }
    val textAlign = if (textDirection == TextDirection.Rtl) TextAlign.End else TextAlign.Start


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .background(Color(0xFF28324B))
            .padding(6.dp)

    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            textStyle = TextStyle.Default.copy(
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp
            ),
            decorationBox = { innerTextField ->
                Box(Modifier.fillMaxWidth()) {
                    if (text.isEmpty()) {
                        Text(
                            "Type Your Question...",
                            color = gray_400,
                            textAlign = textAlign,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    innerTextField()
                }
            }
        )

        ExtItem(
            isSmartModeEnable,
            smartModeChange,
            sendButtonAction,
            isSendButtonEnable,
            onClickFile
        )


    }


}

@Composable
private fun ExtItem(
    isSmartModeEnable: Boolean,
    change: (Boolean) -> Unit,
    onClick: () -> Unit,
    isSendButtonEnable: Boolean,
    onClickFile : ()->Unit
) {


    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(
                imageVector = Icons.Outlined.AttachFile,
                contentDescription = "Attach File",
                modifier = Modifier
                    .rotate(40f)
                    .clickable { onClickFile() },
                tint = Color.White.copy(alpha = 0.8f)
                )


            BoxChip("smart", Icons.Default.Api, isSmartModeEnable) {
                change(!isSmartModeEnable)
            }

        }

        IconButton(
            onClick = { onClick() },
            enabled = isSendButtonEnable,
            
            colors = IconButtonColors(
                containerColor = Color.Gray,
                contentColor = Color.White,
                disabledContentColor = Color.White.copy(0.7f),
                disabledContainerColor = Color.DarkGray
            )
        ) {

            Icon(
                imageVector = Icons.Default.ArrowUpward,
                contentDescription = "",
            )
        }


    }

}


@Composable
private fun BoxChip(text: String, icon: ImageVector, enable: Boolean, onClick: () -> Unit) {

    val color = if (enable) Color.Blue else Color.White.copy(alpha = 0.8f)
    Box(
        modifier = Modifier.padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .clickable { onClick() }
                .clip(RoundedCornerShape(8.dp))
                .background(Color.DarkGray)
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = color
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                icon,
                tint = color,
                modifier = Modifier.size(18.dp),
                contentDescription = icon.name
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun BoxChatPreview() {


    BoxChatInput(
        Modifier,
        "",

    ) { }


}
