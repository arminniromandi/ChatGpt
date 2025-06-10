package ir.arminniromandi.chatgpt.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.arminniromandi.chatgpt.dataBase.AppDatabase
import ir.arminniromandi.chatgpt.dataBase.model.ChatMessage
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Insert()
    suspend fun insert(message: ChatMessage)

    @Query("SELECT * FROM ${AppDatabase.MESSAGE_TABLE} WHERE session_id = :sessionId ORDER BY timestamp ASC")
    fun getMessagesBySession(sessionId: Int): Flow<List<ChatMessage>>

    @Query("DELETE FROM ${AppDatabase.MESSAGE_TABLE} WHERE session_id = :sessionId")
    suspend fun deleteMessagesBySession(sessionId: Int)
}