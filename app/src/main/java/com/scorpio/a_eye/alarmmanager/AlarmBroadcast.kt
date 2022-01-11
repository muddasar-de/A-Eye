package com.scorpio.a_eye.alarmmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.scorpio.a_eye.database.Alarm
import com.scorpio.a_eye.database.AlarmDatebase
import com.scorpio.a_eye.R
import com.scorpio.a_eye.ui.NotifierActivity
import com.scorpio.a_eye.voiceutils.VoiceAssistant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class AlarmBroadcast : BroadcastReceiver() {
    lateinit var alaram: Alarm

    override fun onReceive(context: Context?, intent: Intent?) {
        val id = intent?.getStringExtra("alarmid")
        Log.d("MyAlarmBelal", "Alarm just fired $id")
        val database = AlarmDatebase.getDatabase(context!!)
        Log.d("MyAlarmBelal", "database : $database")

        CoroutineScope(Dispatchers.IO).launch {
            val ob = database?.alarmDao()?.getalarm(id.toString())
            Log.d("MyAlarmBelal", "ob : $ob")
            withContext(Dispatchers.Main) {
                if (ob != null) {
                    Log.d("MyAlarmBelal", "object not null")
                    alaram = ob
                    generatenotification(context)
                } else{
                    generatenotification(context)
                }
                Log.d("MyAlarmBelal", "object null")
            }
            withContext(Dispatchers.Main) {
                if (ob != null) {
                    alaram = ob
                    if (alaram.mon.equals("false", true) && alaram.tues.equals(
                            "false",
                            true
                        ) && alaram.wed.equals("false", true) && alaram.thurs.equals(
                            "false",
                            true
                        ) && alaram.fri.equals("false", true) && alaram.sat.equals(
                            "false",
                            true
                        ) && alaram.sun.equals("false", true)
                    ) {
                        withContext(Dispatchers.IO)
                        {
                            database?.alarmDao()?.updatealaramstatus(id!!.toInt(), "false")
                        }
                    }
                }

            }
        }

    }

    private fun generatenotification(context: Context?) {
        val notificationid = (1..2234475).random()
        Log.d("MyAlarmBelal", "Alarm just fired")
//        context?.let { speakNotification(it, "Alarm triggered") }
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "alaram "
            val descriptionText = "hi"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(notificationid.toString(), name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system

            val manager =
                context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            assert(manager != null)
            manager.createNotificationChannel(channel)
        }

        var builder = context?.let {
            NotificationCompat.Builder(it, notificationid.toString())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("notification")
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("notification ==> Alarm time:${Calendar.getInstance().time}")
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setOngoing(true)
                .setSilent(false)

        }


        with(context?.let { NotificationManagerCompat.from(it) }) {
            // notificationId is a unique int for each notification that you must define
            this?.notify(notificationid, builder?.build()!!)
        }
        Log.d("MyAlarmBelal", "this.notify")
    }

    private fun speakNotification(context: Context, message: String) {
        val speechIntent = Intent(context, NotifierActivity::class.java)
        speechIntent.putExtra("message", message)
        speechIntent.action = Intent.ACTION_VIEW
        speechIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
//        context.startActivity(speechIntent)
    }
}