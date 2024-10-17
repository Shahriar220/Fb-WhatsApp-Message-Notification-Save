package com.example.notificationcatcher.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notificationcatcher.dao.MessageDao
import com.example.notificationcatcher.data.Message

/**
 * @author Shahriar
 * @since 17/10/24 12:09 AM
 */
@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "message_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}