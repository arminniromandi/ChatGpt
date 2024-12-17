package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.UnFoucosedtextFieldColor
import ir.arminniromandi.chatgpt.gradient
import ir.arminniromandi.chatgpt.gray_400
import ir.arminniromandi.chatgpt.textFieldColor
import ir.arminniromandi.chatgpt.white

@Composable
 fun MTextField(modifier: Modifier ,text : MutableState<String> , icon:Int , hint:String ) {
    

        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            leadingIcon = {
                Image(
                    modifier = Modifier.width(24.dp).height(24.dp),
                    painter = painterResource(icon),
                    contentDescription = "icon"
                )
            },
            textStyle = TextStyle(
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                fontSize = 18.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = textFieldColor,
                unfocusedContainerColor = UnFoucosedtextFieldColor,
                focusedBorderColor = gray_400
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)



        )
     
     
}


