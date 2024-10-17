package com.example.notificationcatcher.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Date

/**
 * @author Shahriar
 * @since 17/10/24 10:12 PM
 */
@Composable
fun Messages(messages: List<com.example.notificationcatcher.data.Message>) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messages) { message ->
            MessageItem(message)
        }
    }
}

@Composable
fun MessageItem(message: com.example.notificationcatcher.data.Message) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            color = Color.Black,
            text = "From: ${message.sender}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            color = Color.Black,
            text = "Message: ${message.message}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            color = Color.Black,
            text = "Time: ${Date(message.timestamp).toString()}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}