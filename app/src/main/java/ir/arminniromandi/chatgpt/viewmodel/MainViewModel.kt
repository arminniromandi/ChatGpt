package ir.arminniromandi.chatgpt.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.composeapplication.ConectivityObserver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectivityObserver: ConectivityObserver,
) : ViewModel() {

    val isConnected = connectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )






    val isAnimationRun = mutableStateOf(false)


    //fixme: todo: need to change (in change)
    var showHistory = mutableStateOf(false)
    val selectedModel by mutableStateOf(0)


    private val _navEvent = MutableStateFlow<String?>(null)
    val navEvent: StateFlow<String?> = _navEvent

    fun navigate(route: String) {
        _navEvent.value = route
    }

    fun clearNavigation() {
        _navEvent.value = null
    }








}
