package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
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
import ir.arminniromandi.chatgpt.textFieldColor
import ir.arminniromandi.chatgpt.transparent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStyledTextField(modifier: Modifier, text: MutableState<String>, icon: Int, hint: String) {


    val textFieldColorStyle = TextFieldDefaults.textFieldColors(
        focusedTextColor = Color.White,
        cursorColor = Color.White,
        unfocusedTextColor = Color.White,
        containerColor = textFieldColor,
        focusedIndicatorColor = transparent,
        unfocusedIndicatorColor = transparent,
        disabledIndicatorColor = transparent
    )
    val textFieldTextStyle = TextStyle(
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        fontSize = 18.sp
    )


    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 12.dp),
        leadingIcon = {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(icon),
                contentDescription = "icon"
            )
        },
        textStyle = textFieldTextStyle,
        colors = textFieldColorStyle,
        shape = RoundedCornerShape(50),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )


}


