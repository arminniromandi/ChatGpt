package ir.arminniromandi.myapplication.Api.ChatAi

import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatApiRepository @Inject constructor(
    private val apiService: ChatApiService
) {
    suspend fun getChatResponse(request: ChatRequest ): Response<ChatResponse> {

        return try {
                apiService.getChatResponse(request)
        } catch (e: Exception) {
            throw e
        }
    }


}