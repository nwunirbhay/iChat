package com.ichat.app.data

import java.time.Instant

data class User(
    val id: String,
    val displayName: String,
    val avatarUrl: String? = null,
    val online: Boolean = false
)

data class Message(
    val id: String,
    val senderId: String,
    val conversationId: String,
    val body: String,
    val sentAt: Instant,
    val delivered: Boolean,
    val seen: Boolean
)

data class Conversation(
    val id: String,
    val title: String,
    val participantIds: List<String>,
    val lastMessagePreview: String,
    val unreadCount: Int,
    val updatedAt: Instant,
    val isGroup: Boolean
)
