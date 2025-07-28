package ir.arminniromandi.myapplication.Tool

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.BottomNavItems

object Constance {
    const val SMS_URL = "https://api.sms.ir/v1/"
    const val CHAT_URL = "https://api.avalai.ir/"
    val TAG = "test"


    val FloatingActionButtonModifier = Modifier.size(24.dp) // Placeholder
    val SettingIconSize = 28.dp // Placeholder

    val BottomNavHomeItems = arrayOf(
        BottomNavItems("Home", R.drawable.home),
        BottomNavItems("ChatPage", R.drawable.edit_icon),
        BottomNavItems("History", R.drawable.home)
    )

}