package ir.arminniromandi.myapplication.Tool

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.model.BottomNavItems
import ir.arminniromandi.chatgpt.R

object Constance{
     const val SMS_URL = "https://api.sms.ir/v1/"
     const val CHAT_URL = "https://api.avalai.ir/"

      val FloatingActionButtonModifier = Modifier.size(32.dp)

    val BottomNavHomeItems = arrayOf(
        BottomNavItems("Home", R.drawable.home),
        BottomNavItems("ChatPage", R.drawable.edit_icon),
        BottomNavItems("History", R.drawable.clock)
    )

}