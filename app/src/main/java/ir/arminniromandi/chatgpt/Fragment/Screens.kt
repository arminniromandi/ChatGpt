package ir.arminniromandi.chatgpt.Fragment

sealed class Screens (val screenName : String) {
    data object Intro : Screens("Intro")
    data object Login : Screens("Login")
    data object SignUp : Screens("SignUp")


}