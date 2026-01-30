package ir.arminniromandi.chatgpt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.composeapplication.AndroidConectivityObserver
import ir.arminniromandi.composeapplication.ConectivityObserver
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideConnectivityObserver(
        @ApplicationContext context: Context
    ): ConectivityObserver {
        return AndroidConectivityObserver(context)
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

}


