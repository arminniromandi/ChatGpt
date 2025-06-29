package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.ui.theme.white

@Composable
fun OtpView(otpValue: MutableState<String>) {


    BasicTextField(
        value = otpValue.value,
        onValueChange = {
            if (it.length <= 4)
                otpValue.value = it
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(4) {
                    val char = when {
                        //it is -> number of textField
                        //otpValue.value.length is -> current length of text
                        it >= otpValue.value.length -> "-"

                        else -> otpValue.value[it].toString()
                    }

                    //isFocused -> if textField is focused .
                    // the otpValue is ==it
                    val isFocused = otpValue.value.length == it
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.Gray)
                            .width(40.dp)
                            .border(
                                if (isFocused) 2.dp else 1.dp,
                                if (isFocused) Color.Blue else Color.LightGray,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 18.dp , vertical = 14.dp),
                        text = char,
                        fontSize = 28.sp,
                        color = white,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.width(8.dp))

                }
            }

        },
        singleLine = true,

    )


}