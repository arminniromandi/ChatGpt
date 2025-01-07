package ir.arminniromandi.chatgpt
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

var colors = darkColorScheme(
background = Color(0xFF282828)
)

@Composable
fun AppTheme(
    dynamicColor: Boolean = false,
    content: @Composable() () -> Unit
) {


  MaterialTheme(
    colorScheme = colors,
    typography = Typography,
    content = content
  )
}

