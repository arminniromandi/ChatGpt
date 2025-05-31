package ir.arminniromandi.chatgpt.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.chatgpt.model.Role
import ir.arminniromandi.composeapplication.ConectivityObserver
import ir.arminniromandi.myapplication.Api.ChatAi.ApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Choice
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val conectivityObserver: ConectivityObserver
) : ViewModel() {

    val isConnected = conectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )


    private val _chatResponse = MutableLiveData<ChatResponse>(ChatResponse(listOf(Choice(Message("user" ,"" )))))
    val chatResponse = _chatResponse

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    val allMessage = mutableStateListOf<Message>()

    val isAnimationRun = mutableStateOf(false)

    var showIntro = allMessage.isEmpty()

    fun saveMessageAndSendReq(text :String , model : String){
        allMessage.add(Message(Role.User.value, text))
        sendReq(ChatRequest(model , allMessage))
    }







    fun sendReq(chatRequest: ChatRequest) {
        viewModelScope.launch {

            try {
                _loading.postValue(true)
                isAnimationRun.value = true
                delay(500)
                allMessage.add(Message(Role.Assistant.value , "hello user how can i assist you today"))

                 val response = apiRepository.getChatResponse(chatRequest)
                if (response.isSuccessful) {

                    allMessage.add(Message(Role.Assistant.value , response.body()!!.choices[0]
                        .message.content
                    ))
                }else {
                    _error.postValue(response.message())

                }
            }catch (e:Exception){
                _error.postValue(e.message)
            }finally {
                _loading.postValue(false)
            }

        }
    }

    fun deleteChat() {
        allMessage.clear()
    }


}
