package ir.arminniromandi.chatgpt.ext.util

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.makeShadow() : Modifier =
    this.shadow(
        elevation = 15.dp,
        shape = ButtonDefaults.elevatedShape,
        ambientColor = Color.White,
        spotColor = Color.White,
        clip = true
    )
