package ir.arminniromandi.chatgpt.Fragment

sealed class HomeScreens (val screenName: String){
    data object Home: HomeScreens("Home")
    data object Explore: HomeScreens("Explore")
    data object ChatPage: HomeScreens("ChatPage")
    data object SettingAndAccount: HomeScreens("SettingAndAccount")

}