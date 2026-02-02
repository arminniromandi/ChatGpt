package ir.arminniromandi.chatgpt.ui.Screens.SignUp

import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.activity.MainActivity
import ir.arminniromandi.chatgpt.ui.customUi.MText
import ir.arminniromandi.chatgpt.ui.customUi.OtpView
import ir.arminniromandi.chatgpt.ui.theme.black
import ir.arminniromandi.chatgpt.ui.theme.gradient
import ir.arminniromandi.chatgpt.ui.theme.textFieldColor
import ir.arminniromandi.chatgpt.ui.theme.transparent
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.chatgpt.viewmodel.SignUpViewModel

@Composable
fun LoginScreen(modifier: Modifier, viewModel: SignUpViewModel) {

    val context = LocalContext.current
    val phoneNumber = remember { mutableStateOf("") }
    val otp = remember { mutableStateOf("") }

    val onVerify = remember { mutableStateOf(false) }







    Column(
        modifier
            .background(brush = Brush.verticalGradient(colorStops = gradient))
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        modifier = Modifier.size(48.dp),
                        contentDescription = "logo"
                    )

                    Spacer(modifier.width(8.dp))
                    Text(
                        "Chat Gpt",
                        fontSize = 18.sp,
                        color = white,
                        fontFamily = FontFamily(Font(R.font.satoshi_bold))
                    )
                }
                Text(
                    "skip",
                    color = white,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.satoshi_regular))
                )
            }

            HorizontalDivider(modifier.height(1.dp))
            MText("Welcome", 64, R.font.satoshi_regular, Color(0xFFA7BA88))
            MText("Aboard.", 64, R.font.satoshi_regular, white)

            Spacer(modifier.height(18.dp))
            Text(
                "Enter Phone Number for Verify",
                modifier = modifier.padding(bottom = 10.dp, start = 14.dp),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 18.sp,
                color = white
            )


            TextField(
                value = phoneNumber.value,
                onValueChange = {
                    if (11 >= it.length)
                        phoneNumber.value = it
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                leadingIcon = {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.images),
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
                    cursorColor = Color.White,
                    unfocusedTextColor = Color.White,
                    unfocusedContainerColor = textFieldColor,
                    focusedContainerColor = textFieldColor,
                    disabledContainerColor = textFieldColor,
                    focusedIndicatorColor = transparent,
                    unfocusedIndicatorColor = transparent,
                    disabledIndicatorColor = transparent
                ),
                shape = RoundedCornerShape(50),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )





            Spacer(modifier.height(10.dp))

            ElevatedButton(
                onClick = {
                    onVerify.value = true

                    if (phoneNumber.value.startsWith("09"))
                        viewModel.sendReqForAuth(phoneNumber.value , viewModel.random)
                    else
                        Toast.makeText(context , "invalid phone Number" , Toast.LENGTH_LONG).show()

                    Toast.makeText(context , viewModel.smsReqState.value , Toast.LENGTH_LONG).show()

                },
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    "Login With Phone Number",
                    color = black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.satoshi_medium))
                )
            }
            Spacer(modifier.height(12.dp))

            AnimatedVisibility(
                onVerify.value,
                modifier = modifier.align(Alignment.CenterHorizontally),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                OtpView(otp)
            }
            Spacer(modifier.height(10.dp))
            if (onVerify.value) {
                ElevatedButton(
                    onClick = {
                        if (viewModel.isOtpValid(otp.value))
                            context.startActivity(Intent(context , MainActivity::class.java))
                        else
                            Toast.makeText(context , "Code is incorrect" , Toast.LENGTH_LONG).show()

                    },
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        "Verify",
                        color = black,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.satoshi_medium))
                    )
                }


            }

        }


    }


}