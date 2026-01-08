package ir.arminniromandi.chatgpt.dataBase

import ir.arminniromandi.chatgpt.dataBase.dao.ChatDao
import ir.arminniromandi.chatgpt.dataBase.dao.ChatSessionDao
import ir.arminniromandi.chatgpt.dataBase.model.ChatMessage
import ir.arminniromandi.chatgpt.dataBase.model.ChatSession
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val chatDao: ChatDao,
    private val sessionDao : ChatSessionDao
) {


    fun getAllSessions(): Flow<List<ChatSession>> = sessionDao.getAllSessions()

    fun isTableEmpty(): Boolean = sessionDao.isTableEmpty()

    suspend fun createNewSession(modelName: String): Int {
        val session = ChatSession(
            sessionId = 0, // auto-generated
            modelName = modelName
        )
        return sessionDao.insert(session).toInt()
    }

    suspend fun addMessage(content: String, isUser:  Boolean, sessionId: Int) {
        val message = ChatMessage(
            messageId = 0,
            sessionId = sessionId,
            content = content,
            isUser = isUser
        )
        chatDao.insert(message)
    }

    fun getMessages(sessionId: Int): Flow<List<ChatMessage>> =
        chatDao.getMessagesBySession(sessionId)

    suspend fun deleteSession(session: ChatSession) {
        sessionDao.delete(session)
        chatDao.deleteMessagesBySession(session.sessionId)
    }
}
