package ir.arminniromandi.chatgpt.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class ExploreViewModel @Inject constructor(): ViewModel() {


    private val _navEvent = MutableStateFlow<String?>(null)
    val navEvent: StateFlow<String?> = _navEvent

    fun navigate(page : String) {
        _navEvent.value = page
    }

    fun onNavDone() {
        _navEvent.value = null
    }
}