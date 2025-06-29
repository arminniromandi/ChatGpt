package ir.arminniromandi.chatgpt.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


var colorScheme = darkColorScheme(
    background = Color.Transparent,

    surface = Color(0xFF1E1E1E),
    onSurface = Color.White
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}



