package ir.arminniromandi.chatgpt.customUi

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.textFieldColor
import ir.arminniromandi.chatgpt.transparent


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStyledTextField(modifier: Modifier, text: MutableState<String>, icon: Int, hint: String) {






}


