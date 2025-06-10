package ir.arminniromandi.chatgpt.dataBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.arminniromandi.chatgpt.dataBase.AppDatabase

@Entity(tableName = AppDatabase.SESSION_TABLE)
data class ChatSession(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "session_id") val sessionId: Int,

    @ColumnInfo(name = "model_name")
    val modelName: String,

    @ColumnInfo(name = "title")
    val title: String = "New Chat",

    @ColumnInfo(name = "timestamp")
    val timestamp: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "user_id")
    val userId: String? = null
)
