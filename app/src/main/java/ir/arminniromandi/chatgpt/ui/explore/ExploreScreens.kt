package ir.arminniromandi.chatgpt.ui.explore

sealed class ExploreScreens(val screenName: String) {
    data object Writing : ExploreScreens("Writing")
    data object Code : ExploreScreens("Code")
    data object Home : ExploreScreens("Home")
}