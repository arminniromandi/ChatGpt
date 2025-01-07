package ir.arminniromandi.chatgpt.Fragment.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.gradient
import ir.arminniromandi.chatgpt.white

@Composable
fun Home(){
    val context = LocalContext.current

    Column(
        Modifier.fillMaxSize()
            .background(brush = Brush.verticalGradient(gradient))
    ) {

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = context.getString(R.string.app_name),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                color = white,
                fontSize = 18.sp
            )

//            Icon(
//                imageVector =
//            )
        }
        ElevatedButton(
            onClick = {}
        ) {
            Text(
                text = context.getString(R.string.new_chat),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                color = black,
                fontSize = 18.sp
            )
        }




    }



}