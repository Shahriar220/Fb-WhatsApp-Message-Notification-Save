package com.example.notificationcatcher.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notificationcatcher.data.Message
import kotlinx.coroutines.flow.Flow

/**
 * @author Shahriar
 * @since 17/10/24 12:07 AM
 */

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: Message)

    @Query("SELECT * FROM messages ORDER BY timestamp DESC")
    fun getAllMessages(): Flow<List<Message>>

    @Query("DELETE FROM messages")
    suspend fun deleteAllMessages()
}