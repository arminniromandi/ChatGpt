package ir.arminniromandi.chatgpt.ext.util

import androidx.compose.ui.text.style.TextDirection

object TextDirectionUtil {

    fun getTextDirection(text: String): TextDirection {
        val firstChar = text.firstOrNull { !it.isWhitespace() }
        return when {
            firstChar == null -> TextDirection.Content
            firstChar.isPersianChar() -> TextDirection.Rtl
            else -> TextDirection.Ltr
        }
    }


    private fun Char.isPersianChar(): Boolean {
        val unicode = this.code
        return unicode in 0x0600..0x06FF || // Arabic
                unicode in 0x0750..0x077F || // Arabic Supplement
                unicode in 0xFB50..0xFDFF || // Arabic Presentation Forms-A
                unicode in 0xFE70..0xFEFF    // Arabic Presentation Forms-B
    }

}