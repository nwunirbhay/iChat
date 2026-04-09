package com.ichat.app.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.Instant

class ChatRepository {
    private val me = User(id = "u_me", displayName = "You", online = true)

    private val sampleUsers = listOf(
        me,
        User(id = "u_1", displayName = "Aarav", online = true),
        User(id = "u_2", displayName = "Mina", online = false),
        User(id = "u_3", displayName = "Design Team", online = true)
    )

    private val conversationsState = MutableStateFlow(
        listOf(
            Conversation(
                id = "c_1",
                title = "Aarav",
                participantIds = listOf(me.id, "u_1"),
                lastMessagePreview = "Let's finalize launch checklist.",
                unreadCount = 2,
                updatedAt = Instant.now(),
                isGroup = false
            ),
            Conversation(
                id = "c_2",
                title = "Mina",
                participantIds = listOf(me.id, "u_2"),
                lastMessagePreview = "Voice call later?",
                unreadCount = 0,
                updatedAt = Instant.now().minusSeconds(3600),
                isGroup = false
            ),
            Conversation(
                id = "c_3",
                title = "Design Team",
                participantIds = listOf(me.id, "u_1", "u_2", "u_3"),
                lastMessagePreview = "New icon set uploaded.",
                unreadCount = 5,
                updatedAt = Instant.now().minusSeconds(7200),
                isGroup = true
            )
        )
    )

    fun me(): User = me

    fun users(): List<User> = sampleUsers

    fun conversations(): StateFlow<List<Conversation>> = conversationsState
}
