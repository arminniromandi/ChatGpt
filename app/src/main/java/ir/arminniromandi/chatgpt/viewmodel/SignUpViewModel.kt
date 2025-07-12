package ir.arminniromandi.chatgpt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.chatgpt.Api.sms.SmsApiRepository
import ir.arminniromandi.chatgpt.Api.sms.model.Parameter
import ir.arminniromandi.chatgpt.Api.sms.model.RequestSmsBody
import ir.arminniromandi.composeapplication.ConectivityObserver
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SignUpViewModel @Inject constructor(
    connectivityObserver: ConectivityObserver,
    val smsApiRepository: SmsApiRepository
) : ViewModel() {

    val isConnected = connectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )

    private var _smsReqState = MutableLiveData<String>("")
    val smsReqState: LiveData<String> = _smsReqState

    val random = Random.nextInt(1000, 9999).toString()

    fun isOtpValid(entered: String): Boolean = entered == random

    fun sendReqForAuth(phoneNumber: String, code: String) {
        val parameter = listOf(Parameter("code", code))
        _smsReqState.value ="sdsd"

        if (isConnected.value){
            viewModelScope.launch {

                smsApiRepository.sendOtpReq(
                    RequestSmsBody(
                        mobile = phoneNumber,
                        parameters = parameter
                    )
                )
            }
        }else
            _smsReqState.postValue("No Internet Connection!")



    }
}

