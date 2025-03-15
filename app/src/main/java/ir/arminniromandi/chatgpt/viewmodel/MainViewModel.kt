package ir.arminniromandi.chatgpt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.arminniromandi.myapplication.Api.ChatAi.ApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {



    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun sendReq(chatRequest: ChatRequest) {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val response = apiRepository.getChatResponse(chatRequest)


            }catch (e:Exception){
                _error.postValue(e.message)
            }finally {
                _loading.postValue(false)
            }

        }
    }


}
