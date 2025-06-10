package ir.arminniromandi.chatgpt.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.chatgpt.dataBase.AppDatabase
import ir.arminniromandi.chatgpt.dataBase.ChatRepository
import ir.arminniromandi.chatgpt.dataBase.dao.ChatDao
import ir.arminniromandi.chatgpt.dataBase.dao.ChatSessionDao
import ir.arminniromandi.composeapplication.AndroidConectivityObserver
import ir.arminniromandi.composeapplication.ConectivityObserver
import ir.arminniromandi.myapplication.Api.ChatAi.ApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.ChatApiService
import ir.arminniromandi.myapplication.SmsApiService
import ir.arminniromandi.myapplication.Tool.Constance.SMS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ProvideSmsApi
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ProvideChatApi


    @Singleton
    @Provides
    @ProvideSmsApi
    fun provideRetrofitSms(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SMS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @ProvideChatApi
    fun provideRetrofitChat(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://ai.liara.ir/api/v1/6846c3d3761c7d3b5f4badaf/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideSmsService(@ProvideSmsApi retrofit: Retrofit): SmsApiService =
        retrofit.create(SmsApiService::class.java)

    @Singleton
    @Provides
    fun provideChatService(@ProvideChatApi retrofit: Retrofit): ChatApiService =
        retrofit.create(ChatApiService::class.java)

    @Provides
    @Singleton
    fun provideApiRepository(apiService: ChatApiService): ApiRepository {
        return ApiRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMessageDao(database: AppDatabase): ChatDao {
        return database.chatDao()
    }

    @Provides
    @Singleton
    fun provideSessionDao(database: AppDatabase): ChatSessionDao {
        return database.chatSessionDao()
    }

    @Provides
    @Singleton
    fun provideChatRepository(chatDao: ChatDao , sessionDao: ChatSessionDao): ChatRepository {
        return ChatRepository(chatDao, sessionDao)
    }

    @Provides
    fun provideConnectivityObserver(
        @ApplicationContext context: Context
    ): ConectivityObserver {
        return AndroidConectivityObserver(context)
    }


}


