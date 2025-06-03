package ir.arminniromandi.chatgpt.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.arminniromandi.chatgpt.dataBase.model.ChatMessage

@Database(entities = [ChatMessage::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun chatDao(): ChatDao

    companion object {
        const val MESSAGE_TABLE = "ChatMessage_table"
        const val SESSION_TABLE = "session_Table"
        const val DATABASE_NAME = "chat_database"
    }

}