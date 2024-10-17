package com.example.notificationcatcher.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import androidx.core.app.NotificationCompat

/**
 * @author Shahriar
 * @since 17/10/24 10:09 PM
 */
fun triggerTestNotification(context: Context) {
    val channelId = "test_channel_id"
    val channelName = "Test Channel"
    val notificationId = 1

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Create the NotificationChannel if required (for Android O and above)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, channelName, importance)
        notificationManager.createNotificationChannel(channel)
    }

    // Build the notification
    val notification = NotificationCompat.Builder(context, channelId)
        .setContentTitle("Test Notification")
        .setContentText("This is a test notification to check the listener")
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .build()

    // Trigger the notification
    notificationManager.notify(notificationId, notification)
}

fun isNotificationListenerEnabled(context: Context): Boolean {
    val packageName = context.packageName
    val enabledListeners =
        Settings.Secure.getString(context.contentResolver, "enabled_notification_listeners")
    return !TextUtils.isEmpty(enabledListeners) && enabledListeners.contains(packageName)
}

fun requestNotificationAccessPermission(context: Context) {
    val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
    context.startActivity(intent)
}