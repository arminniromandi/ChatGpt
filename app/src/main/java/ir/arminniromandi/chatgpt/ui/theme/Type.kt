package ir.arminniromandi.chatgpt.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R


val satoshi = FontFamily(
    Font(
        resId = R.font.satoshi_medium,
        weight = FontWeight.Medium
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
// --- تعریف کامل Typography ---
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    displayMedium = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),

    // --- Headline Styles ---
    // برای عناوین بخش‌ها یا تیترهای مهم
    headlineLarge = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle( // این استایل رو خودتون داشتید
        fontFamily = satoshi,
        fontWeight = FontWeight.Medium, // شما Bold گذاشته بودید که می‌تونه برای تیتر مناسب باشه
        fontSize = 18.sp, // از 18sp به 28sp (پیش‌فرض Material Design 3) تغییر دادم
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),

    // --- Title Styles ---
    // برای عناوین کوچکتر، زیرتیترها، یا متن‌های App Bar
    titleLarge = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Medium, // اغلب Medium یا Bold برای Title
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),

    // --- Body Styles ---
    // برای بدنه اصلی متن، پاراگراف‌ها و متن‌های خواندنی
    bodyLarge = TextStyle( // این استایل رو خودتون داشتید
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle( // این استایل رو خودتون داشتید
        fontFamily = satoshi,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle( // این استایل رو خودتون داشتید
        fontFamily = satoshi,
        fontWeight = FontWeight.Light, // شما Light گذاشته بودید که می‌تونه خوب باشه
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),

    // --- Label Styles ---
    // برای متن دکمه‌ها، لیبل‌های ورودی، و متن‌های کاربردی کوچک
    labelLarge = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Medium, // معمولاً Medium برای دکمه‌ها
        fontSize = 14.sp, // این همون 14sp پیش‌فرضه Material Design 3 هست
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    labelMedium = TextStyle( // این استایل رو خودتون داشتید
        fontFamily = satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp, // به 12sp (پیش‌فرض Material Design 3) تغییر دادم
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = satoshi,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    )
)