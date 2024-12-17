package ir.arminniromandi.chatgpt
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

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

