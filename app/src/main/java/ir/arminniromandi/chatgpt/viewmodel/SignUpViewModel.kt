package ir.arminniromandi.chatgpt.viewmodel

import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import ir.arminniromandi.composeapplication.ConectivityObserver
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class SignUpViewModel(
    conectivityObserver: ConectivityObserver
): ViewModel() {
    val isConnected = conectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )


    fun sendReq(){



    }
    }

