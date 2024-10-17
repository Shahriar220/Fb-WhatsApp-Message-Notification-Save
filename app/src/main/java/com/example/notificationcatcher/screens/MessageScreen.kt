package com.example.notificationcatcher.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.notificationcatcher.MessageViewModel

/**
 * @author Shahriar
 * @since 17/10/24 10:13 PM
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MessageScreen(viewModel: MessageViewModel) {
    val messageList by viewModel.messages.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Messages") },
                actions = {
                    IconButton(onClick = { viewModel.deleteAllMessages() }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete All Messages")
                    }
                }
            )
        }
    ) {
        Messages(messages = messageList)
    }
}