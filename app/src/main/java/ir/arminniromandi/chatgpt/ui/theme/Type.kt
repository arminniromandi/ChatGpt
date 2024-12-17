package ir.arminniromandi.chatgpt

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val satoshi = FontFamily(
    Font(

        resId = R.font.satoshi_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.satoshi_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.satoshi_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.satoshi_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    )
)

// Set of Material typography styles to start with
val Typography = Typography(

    bodySmall = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
    ),
    headlineMedium = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)