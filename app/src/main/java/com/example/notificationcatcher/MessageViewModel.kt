package com.example.notificationcatcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notificationcatcher.dao.MessageDao
import com.example.notificationcatcher.data.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Shahriar
 * @since 17/10/24 12:33 AM
 */
class MessageViewModel (
    private val messageDao: MessageDao
) : ViewModel() {
    val messages: Flow<List<Message>> = messageDao.getAllMessages()

    fun insertMessage(message: Message) {
        viewModelScope.launch {
            messageDao.insertMessage(message)
        }
    }

    fun deleteAllMessages() {
        viewModelScope.launch {
            messageDao.deleteAllMessages()
        }
    }
}