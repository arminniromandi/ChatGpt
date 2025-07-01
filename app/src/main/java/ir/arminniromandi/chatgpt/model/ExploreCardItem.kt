package ir.arminniromandi.chatgpt.model

import androidx.compose.runtime.Immutable

@Immutable
data class ExploreCardItem (
    val title: String,
    val icon: Int,
    val des: String,
    val screenName : String = title
)