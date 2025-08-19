package ir.arminniromandi.chatgpt.viewmodel

import androidx.compose.runtime.mutableStateOf
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

    var showIntro = mutableStateOf(true)

    //fixme: todo: need to change (in change)
    var showHistory = mutableStateOf(false)


    private val _navEvent = MutableStateFlow<String?>(null)
    val navEvent: StateFlow<String?> = _navEvent

    fun navigate(route: String) {
        _navEvent.value = route
    }

    fun clearNavigation() {
        _navEvent.value = null
    }








}
