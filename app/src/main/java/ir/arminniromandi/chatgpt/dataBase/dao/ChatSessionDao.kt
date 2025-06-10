package ir.arminniromandi.chatgpt.dataBase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ir.arminniromandi.chatgpt.dataBase.AppDatabase
import ir.arminniromandi.chatgpt.dataBase.model.ChatSession
import kotlinx.coroutines.flow.Flow


@Dao
interface ChatSessionDao {

    @Insert
    suspend fun insert(session: ChatSession): Long // returns row ID

    @Update
    suspend fun update(session: ChatSession)

    @Delete
    suspend fun delete(session: ChatSession)

    @Query("SELECT * FROM ${AppDatabase.SESSION_TABLE} ORDER BY timestamp DESC")
    fun getAllSessions(): Flow<List<ChatSession>>

    @Query("SELECT * FROM ${AppDatabase.SESSION_TABLE} WHERE session_id = :sessionId")
    suspend fun getSessionById(sessionId: Int): ChatSession?
}