package com.scorpio.a_eye.alarmmanager

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.scorpio.a_eye.R
import com.scorpio.a_eye.database.Alarm
import com.scorpio.a_eye.database.AlarmDatebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class SnoozeBroadcast : BroadcastReceiver() {
    lateinit var alaram: Alarm
    var notifyid: String? = ""
    lateinit var context: Context
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("snooze", "Snoozing..............................")
        this.context = context!!
        var id = intent?.getStringExtra("alarmid")
        notifyid = intent?.getStringExtra("notifyid")
        CoroutineScope(Dispatchers.IO).launch {
            var database = AlarmDatebase.getDatabase(context!!)
            var ob = database?.alarmDao()?.getalarm(id.toString())
            withContext(Dispatchers.Main)
            {
                if (ob != null) {
                    alaram = ob
                    if (alaram.mon.equals("false", true) || alaram.tues.equals(
                            "false",
                            true
                        ) || alaram.wed.equals("false", true) || alaram.thurs.equals(
                            "false",
                            true
                        ) || alaram.fri.equals("false", true) || alaram.sat.equals(
                            "false",
                            true
                        ) || alaram.sun.equals("false", true)
                    ) {
                        withContext(Dispatchers.IO)
                        {
                            database?.alarmDao()?.updatealaramstatus(id!!.toInt(), "true")
                        }
                    }
                    setalaram(context)
                    cancelnotification(context)
                    createSnozeNotification()
                } else {
                    cancelnotification(context)
                }

                Log.i("ala", "${alaram.toString()}")
            }
        }
    }

    private fun setalaram(context: Context?) {

        var calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, 5)

        //getting the alarm manager
        val am =
            context?.applicationContext?.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        //creating a new intent specifying the broadcast receiver
        val i = Intent(context, AlarmBroadcast::class.java)
        i.putExtra("alarmid", alaram.alarmid);
        //creating a pending intent using the intent
        val pi = PendingIntent.getBroadcast(
            context,
            alaram.alarmid.toString().toInt(),
            i,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        //  , AlarmManager.INTERVAL_DAY
        //setting the repeating alarm that will be fired every day

        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pi)
    }

    fun cancelnotification(context: Context?) {
        val notificationManager = ContextCompat.getSystemService(
            context!!,
            NotificationManager::class.java
        ) as NotificationManager
        if (notifyid != "") {
            notificationManager.cancel(notifyid.toString().toInt())
        } else {
            notificationManager.cancelAll()
        }
    }

    fun createSnozeNotification() {
        var calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, 5)

        val notificationid = (1..2234475).random()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Alarm Snooze "
            val descriptionText = "hi"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(notificationid.toString(), name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            assert(manager != null)
            manager.createNotificationChannel(channel)
        }

        var builder = context.let {
            NotificationCompat.Builder(it, notificationid.toString())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm will sound at ${Dateconverter(calendar.timeInMillis)}")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setNotificationSilent()
                .setAutoCancel(false)


        }
        with(context.let { NotificationManagerCompat.from(it) }) {
            // notificationId is a unique int for each notification that you must define
            this.notify(notificationid, builder.build())
        }
    }

    fun Dateconverter(date: Long): String {
        val sdf = SimpleDateFormat("hh:mm aa")
        return sdf.format(date)
    }

}