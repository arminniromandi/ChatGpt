package ir.arminniromandi.chatgpt.model

data class ExploreCardItem (
    val title: String,
    val icon: Int,
    val des: String,
    val screenName : String = title
)