package com.scorpio.a_eye.alarmmanager

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat

class NotificationDismissReciver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?)
    {
        var notifyid = intent?.getStringExtra("notifyid")
        Log.i("dissmis notify id", "$notifyid")
        val notificationManager = ContextCompat.getSystemService(
            context!!,
            NotificationManager::class.java
        ) as NotificationManager
        if (notifyid != "") {
            notificationManager.cancel(notifyid.toString().toInt())
        } else
        {
            notificationManager.cancelAll()
        }
    }
}