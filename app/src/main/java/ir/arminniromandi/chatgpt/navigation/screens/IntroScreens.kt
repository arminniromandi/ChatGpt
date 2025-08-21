package ir.arminniromandi.chatgpt.navigation.screens

sealed class IntroScreens (val screenName : String) {
    data object Intro : IntroScreens("Intro")
    data object Login : IntroScreens("Login")
    data object SignUp : IntroScreens("SignUp")


}