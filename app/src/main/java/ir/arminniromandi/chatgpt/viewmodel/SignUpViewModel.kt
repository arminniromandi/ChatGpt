package ir.arminniromandi.chatgpt.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.composeapplication.ConectivityObserver
import ir.arminniromandi.myapplication.Parameter
import ir.arminniromandi.myapplication.RequestSmsBody
import ir.arminniromandi.myapplication.SmsApiService
import ir.arminniromandi.myapplication.response.response
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SignUpViewModel @Inject constructor(
    connectivityObserver: ConectivityObserver,
    private val smsApiService: SmsApiService
) : ViewModel() {

    val smsReqState = mutableStateOf("")

    val random = Random.nextInt(1000, 9999).toString()


    val isConnected = connectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )

    fun isOtpValid(entered: String): Boolean = entered == random

    fun sendReqForAuth(phoneNumber: String, code: String) {
        val parametr = listOf(Parameter("code", code))


        viewModelScope.launch {

            if (isConnected.value) {
                smsApiService.sendRequest(
                    RequestSmsBody(
                        phoneNumber,
                        "687263",
                        parametr
                    )
                ).enqueue(
                    object : Callback<response> {
                        override fun onResponse(
                            call: Call<response>,
                            response: Response<response>
                        ) {
                            smsReqState.value = "Code Sent Successfully"
                        }

                        override fun onFailure(call: Call<response>, t: Throwable) {
                            smsReqState.value = "Code Not Sent Error is = ${t.message}"
                        }

                    }
                )


            } else {
                smsReqState.value = "No Internet Connection"
            }


        }


    }
}

