package ir.arminniromandi.chatgpt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.chatgpt.dataBase.ChatRepository
import ir.arminniromandi.chatgpt.dataBase.dao.ChatDao
import ir.arminniromandi.chatgpt.dataBase.dao.ChatSessionDao
import ir.arminniromandi.myapplication.Api.ChatAi.ApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.ChatApiService
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideApiRepository(chatApiService: ChatApiService): ApiRepository =
        ApiRepository(chatApiService)

    @Provides
    @Singleton
    fun provideChatRepository(chatDao: ChatDao, sessionDao: ChatSessionDao): ChatRepository =
        ChatRepository(chatDao, sessionDao)
}

