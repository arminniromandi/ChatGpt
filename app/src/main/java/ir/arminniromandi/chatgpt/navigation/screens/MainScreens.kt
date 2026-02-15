package ir.arminniromandi.chatgpt.navigation.screens

sealed class MainScreens(val screenName: String) {
    data object Main : MainScreens("Home")
    object ChatPage : MainScreens("chat/{chatId}") {
        fun createRouteForLoadChat(chatId: String) = "chat/$chatId"
        fun newChat() = "chat/-1"
    }

    data object Setting : MainScreens("Setting")
    data object History : MainScreens("History")
    data object Explore : MainScreens("Explore")
    data object ExploreWriting : MainScreens("ExploreWriting")
    data object GymPlaner : MainScreens("GymPlaner")
}