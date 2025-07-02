package ir.arminniromandi.chatgpt.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.chatgpt.Tool.util.PreferencesManager
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    val preferencesManager: PreferencesManager
) : ViewModel() {


    val userName:MutableState<String?> = mutableStateOf("")
    val userPhone:MutableState<String?> = mutableStateOf("")

    init {
        loadSettings()
    }

    private fun loadSettings() {

        userName.value = preferencesManager.getUserName()
        userPhone.value = preferencesManager.getUserPhone()

    }

}