package ir.arminniromandi.chatgpt.ui.main

sealed class MainScreens (val screenName: String){
    data object Main: MainScreens("Home")
    data object ChatPage: MainScreens("ChatPage")
    data object Setting: MainScreens("Setting")
    data object History: MainScreens("History")

}