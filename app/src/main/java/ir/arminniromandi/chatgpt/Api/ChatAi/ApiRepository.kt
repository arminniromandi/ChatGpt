package ir.arminniromandi.myapplication.Api.ChatAi

import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ApiRepository(
    private val apiService: ApiService
) {

    fun getChatResponse(request: ChatRequest): Flow<Result<ChatResponse>> = flow {
        val response = apiService.getChatResponse(request)
        emit(Result.success(response))
    }.catch {
        emit(Result.failure(it))
    }

}