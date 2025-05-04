package ir.arminniromandi.chatgpt.Fragment

sealed class ExploreScreens(val screenName: String) {
    data object Writing : ExploreScreens("Writing")

}