package com.example.notificationcatcher

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.example.notificationcatcher.dao.MessageDao
import com.example.notificationcatcher.data.Message
import com.example.notificationcatcher.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Shahriar
 * @since 17/10/24 12:12 AM
 */
class NotificationListener : NotificationListenerService() {

    // Declare messageDao as a class-level variable
    private lateinit var messageDao: MessageDao

    override fun onCreate() {
        super.onCreate()
        // Initialize the messageDao here using Room database
        val db = AppDatabase.getDatabase(applicationContext)
        messageDao = db.messageDao()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        val packageName = sbn?.packageName
        val senderName = sbn?.notification?.extras?.getString(Notification.EXTRA_TITLE)
        val notificationText = sbn?.notification?.extras?.getString(Notification.EXTRA_TEXT)

        if (senderName != "Chat heads active"
            && (packageName == "com.facebook.katana" ||
                    packageName == "com.facebook.orca" || packageName == "com.whatsapp")
        ) {
            val message = Message(
                sender = senderName ?: "",
                message = notificationText ?: "",
                packageName = packageName ?: "",
                timestamp = System.currentTimeMillis()
            )

            // Use a coroutine to insert the message into the database asynchronously
            CoroutineScope(Dispatchers.IO).launch {
                messageDao.insertMessage(message)
            }
        }
    }
}
