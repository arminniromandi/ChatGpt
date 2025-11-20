package ir.arminniromandi.chatgpt.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable

@Stable
data class BottomNavItems(
    val name : String,
    val route : String,
    @DrawableRes val icon : Int,

    )