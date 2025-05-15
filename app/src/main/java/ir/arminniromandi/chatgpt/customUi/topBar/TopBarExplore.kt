package ir.arminniromandi.chatgpt.customUi.topBar

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.Activity.MainActivity
import ir.arminniromandi.chatgpt.R

@Composable
fun TopBarExplore() {

    val context = LocalContext.current

    Box(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .padding(horizontal = 14.dp),
    ) {

        FloatingActionButton(
            modifier = Modifier
                .size(56.dp)
                .padding(4.dp),

            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            }, shape = CircleShape, containerColor = Color.White
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.Black,
                contentDescription = "back"
            )

        }


        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Explore",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 24.sp
        )


    }

}
