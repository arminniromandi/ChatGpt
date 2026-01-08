package ir.arminniromandi.chatgpt.ui.main.chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.ai.AiModel
import ir.arminniromandi.chatgpt.ui.theme.gray_400
import ir.arminniromandi.chatgpt.ui.theme.white

@Composable
fun IntroSection(modelSelected: String) {

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                modifier = Modifier.size(72.dp),
                contentDescription = "logo"
            )
            Spacer(Modifier.height(12.dp))

            Text(
                stringResource(R.string.app_name),
                fontFamily = FontFamily(Font(R.font.satoshi_black)),
                color = white,
                fontSize = 28.sp
            )
        }
        Spacer(Modifier.height(18.dp))

        Column(
            Modifier

                .padding(horizontal = 2.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "hello and welcome to new Chat.",
                fontSize = 18.sp,
                color = gray_400,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            )
            Spacer(Modifier.height(4.dp))


            Text(
                "Please chose your ai model from top.",
                fontSize = 18.sp,
                color = gray_400,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),

                )
            Spacer(Modifier.height(4.dp))


            Text(
                "Current Model : $modelSelected",
                fontSize = 18.sp,
                color = gray_400,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),

                )
        }


    }

}