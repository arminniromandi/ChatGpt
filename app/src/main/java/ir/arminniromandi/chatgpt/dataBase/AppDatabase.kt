package ir.arminniromandi.chatgpt.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.arminniromandi.chatgpt.dataBase.dao.ChatDao
import ir.arminniromandi.chatgpt.dataBase.dao.ChatSessionDao
import ir.arminniromandi.chatgpt.dataBase.model.ChatMessage
import ir.arminniromandi.chatgpt.dataBase.model.ChatSession

@Database(entities = [ChatMessage::class , ChatSession::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
    abstract fun chatSessionDao(): ChatSessionDao

    companion object {
        const val MESSAGE_TABLE = "ChatMessage_table"
        const val SESSION_TABLE = "sessionTable"
        const val DATABASE_NAME = "chat_database"
    }

}