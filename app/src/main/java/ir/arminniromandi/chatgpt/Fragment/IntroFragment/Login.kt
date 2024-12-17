package ir.arminniromandi.chatgpt.Fragment.IntroFragment

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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.customUi.MText
import ir.arminniromandi.chatgpt.customUi.MTextField
import ir.arminniromandi.chatgpt.gradient
import ir.arminniromandi.chatgpt.white

@Composable
fun Login(modifier: Modifier) {

    val phoneNumber = remember { mutableStateOf("") }

    Column(
        modifier
            .background(brush = Brush.verticalGradient(gradient))
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

        }
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            MTextField(modifier , phoneNumber ,R.drawable.images , "Enter Phone Number")

        }
        ElevatedButton(
            onClick = {},
            modifier = Modifier
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


    }
}

@Preview
@Composable
private fun loginPreView() {
    Login(Modifier)
}