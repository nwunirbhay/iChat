package com.ichat.app.viewmodel

import androidx.lifecycle.ViewModel
import com.ichat.app.data.ChatRepository
import com.ichat.app.data.Conversation
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val repository: ChatRepository = ChatRepository()
) : ViewModel() {
    val conversations: StateFlow<List<Conversation>> = repository.conversations()
}
