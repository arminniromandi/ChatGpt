package ir.arminniromandi.chatgpt.dataBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ir.arminniromandi.chatgpt.dataBase.AppDatabase

@Entity(
    tableName = AppDatabase.MESSAGE_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = ChatSession::class,
            parentColumns = ["session_id"],
            childColumns = ["session_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("session_id")]
)
data class ChatMessage(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "message_id")
    val messageId: Int = 0,

    @ColumnInfo(name = "session_id")
    val sessionId: Int,

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "is_user")
    val isUser: Boolean,

    @ColumnInfo(name = "timestamp")
    val timestamp: Long = System.currentTimeMillis()
)