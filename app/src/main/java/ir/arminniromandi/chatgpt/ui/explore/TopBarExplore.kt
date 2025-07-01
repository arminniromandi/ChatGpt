package ir.arminniromandi.chatgpt.ui.explore

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.Activity.MainActivity
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier


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
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            }, shape = CircleShape, containerColor = white
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.Black,
                modifier = FloatingActionButtonModifier,
                contentDescription = "back"
            )

        }



        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Explore",
            color = Color.White,
            style = Typography().headlineSmall
        )


    }


}