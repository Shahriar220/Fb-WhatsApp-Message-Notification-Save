package com.example.notificationcatcher.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Shahriar
 * @since 16/10/24 11:51 PM
 */
@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val sender: String,
    val message: String,
    val timestamp: Long,
    val packageName: String
)