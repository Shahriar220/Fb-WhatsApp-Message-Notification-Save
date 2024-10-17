package com.example.notificationcatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.notificationcatcher.dao.MessageDao
import com.example.notificationcatcher.database.AppDatabase
import com.example.notificationcatcher.screens.MessageScreen
import com.example.notificationcatcher.utils.isNotificationListenerEnabled
import com.example.notificationcatcher.utils.requestNotificationAccessPermission
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var messageDao: MessageDao
    private lateinit var messageViewModel: MessageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = AppDatabase.getDatabase(this)
        messageDao = database.messageDao()
        messageViewModel = MessageViewModel(messageDao)
        if (!isNotificationListenerEnabled(this)) {
            requestNotificationAccessPermission(this)
        }
        setContent {
            MessageScreen(viewModel = messageViewModel)
        }
    }
}
