package ir.arminniromandi.chatgpt.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.chatgpt.dataBase.ChatRepository
import ir.arminniromandi.chatgpt.model.ai.Role
import ir.arminniromandi.composeapplication.ConectivityObserver
import ir.arminniromandi.myapplication.Api.ChatAi.ChatApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Choice
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val chatApiRepository: ChatApiRepository,
    private val conectivityObserver: ConectivityObserver,
    private val chatRepository: ChatRepository
) : ViewModel() {

    val isConnected = conectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )




    //ساخت چت مادل برای جابه جایی این متغیر ها و سبک سازی todo:
    private val currentSessionId = mutableStateOf<Int>(-1)

    private val _chatResponse = MutableLiveData<ChatResponse>(ChatResponse(listOf(Choice(Message("user" ,"" )))))
    val chatResponse = _chatResponse

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    val allMessage = mutableStateListOf<Message>()

    val isAnimationRun = mutableStateOf(false)

    var showIntro = mutableStateOf(true)

    //fixme: todo: need to change (in change)
    var showHistory = mutableStateOf(true)


    private val _navEvent = MutableStateFlow<String?>(null)
    val navEvent: StateFlow<String?> = _navEvent

    fun navigate(route: String) {
        _navEvent.value = route
    }

    fun clearNavigation() {
        _navEvent.value = null
    }





    fun saveMessageAndSendReq(text :String , model : String  ){
        allMessage.add(Message(Role.User.value, text))
        sendReq(ChatRequest(model , allMessage)  )
    }




    fun sendReq(chatRequest: ChatRequest  ) {
        Log.i("testRetrofit", "sendReq: on viewModel Started ")

        viewModelScope.launch {
            try {
                _loading.postValue(true)
                isAnimationRun.value = true
                delay(500)

                 val response = chatApiRepository.getChatResponse(chatRequest)
                Log.i("testRetrofit", response.code().toString())
                Log.i("testRetrofit", response.errorBody().toString())
                Log.i("testRetrofit", response.message().toString())
                Log.i("testRetrofit", response.headers().toString())
                if (response.isSuccessful) {
                    Log.i("testRetrofit", "is Successful")

                    allMessage.add(Message(Role.Assistant.value , response.body()!!.choices[0]
                        .message.content
                    ))

                }else {
                    _error.postValue(response.message())
                    Log.i("testRetrofit", "not Successful")
                    Log.i("testRetrofit", "code = "+response.code().toString())
                    Log.i("testRetrofit", "errorBody = "+response.errorBody()?.string())
                    Log.i("testRetrofit", "message = "+response.message().toString())
                    Log.i("testRetrofit", "header ="+response.headers().toString())

                }
            }catch (e:Exception){
                _error.postValue(e.message)
                Log.i("testRetrofit", " catch :" +e.message.toString())


            }finally {
                _loading.postValue(false)
            }

        }
    }

    fun deleteChat() {
        allMessage.clear()
    }


}
