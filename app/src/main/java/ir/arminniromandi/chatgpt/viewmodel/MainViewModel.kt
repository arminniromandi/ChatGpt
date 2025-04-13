package ir.arminniromandi.chatgpt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.myapplication.Api.ChatAi.ApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Choice
import ir.arminniromandi.myapplication.Api.ChatAi.Model.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _chatResponse = MutableLiveData<ChatResponse>(ChatResponse(listOf(Choice(Message("user" ,"" )))))
    val chatResponse = _chatResponse

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun sendReq(chatRequest: ChatRequest) {
        viewModelScope.launch {


            try {
                _loading.postValue(true)
                val response = apiRepository.getChatResponse(chatRequest)
                if (response.isSuccessful) {
                    Log.i("test", "sendReq: sent ")
                    _chatResponse.postValue(response.body())
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


}
