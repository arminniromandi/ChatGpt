package ir.arminniromandi.chatgpt.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.chatgpt.dataBase.AppDatabase
import ir.arminniromandi.chatgpt.dataBase.dao.ChatDao
import ir.arminniromandi.chatgpt.dataBase.dao.ChatSessionDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

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


}