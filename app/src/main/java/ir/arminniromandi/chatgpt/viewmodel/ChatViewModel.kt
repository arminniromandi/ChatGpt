package ir.arminniromandi.chatgpt.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.chatgpt.dataBase.ChatRepository
import ir.arminniromandi.chatgpt.ext.util.isUserRole
import ir.arminniromandi.chatgpt.ext.util.setRole
import ir.arminniromandi.chatgpt.model.ai.Role
import ir.arminniromandi.myapplication.Api.ChatAi.ChatApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Choice
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor(
    private val dbRepository: ChatRepository,
    private val chatApiRepository: ChatApiRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val chatId: String = savedStateHandle["chatId"] ?: "-1"

    var selectedModel by mutableIntStateOf(0)
        private set


    private val currentSessionId = mutableIntStateOf(-1)

    private val _chatResponse =
        MutableLiveData<ChatResponse>(ChatResponse(listOf(Choice(Message("user", "")))))
    val chatResponse = _chatResponse

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    var showIntro = mutableStateOf(true)
    val currentAllMessage = mutableStateListOf<Message>()

    val isAnimationRun = mutableStateOf(false)

    init {
        if (chatId == "-1") {
            showIntro.value = true
        } else {
            currentSessionId.intValue = chatId.toInt()
            getMessages(chatId.toInt())
        }
    }

    fun setModel(index: Int) {
        selectedModel = index
    }

    private fun getMessages(sessionId: Int) {
        viewModelScope.launch {
            dbRepository.getMessages(sessionId).collect { messages ->
                currentAllMessage.clear()
                messages.forEach { it ->
                    currentAllMessage.add(Message(it.isUser.setRole(), it.content))
                }

            }
        }
    }

    fun saveMessageAndSendReq(text: String, model: String) {
        viewModelScope.launch(Dispatchers.Main) {
            currentAllMessage.add(Message(Role.User.value, text))
            isAnimationRun.value = true
            saveMassage(text, Role.User)
        }
        sendReq(ChatRequest(model, currentAllMessage))


    }


    fun deleteChat() {
        currentAllMessage.clear()
    }


    private fun saveMassage(text: String, role: Role) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.addMessage(text, role.isUserRole(), currentSessionId.intValue)
        }
    }



    private fun sendReq(chatRequest: ChatRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loading.postValue(true)
                isAnimationRun.value = true
                delay(500)

                val response = chatApiRepository.getChatResponse(chatRequest)

                if (response.isSuccessful) {
                    val data = Message(
                        Role.Assistant.value, response.body()!!.choices[0]
                            .message.content
                    )
                    currentAllMessage.add(data)
                    saveMassage(data.content, Role.Assistant)
                } else {
                    _error.postValue(response.message())
                }
            } catch (e: Exception) {
                _error.postValue(e.message)
            } finally {
                _loading.postValue(false)
            }

        }
    }


}