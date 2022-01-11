package com.scorpio.a_eye.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.scorpio.a_eye.database.AlarmDatebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            CoroutineScope(Dispatchers.IO).launch {
                var database = AlarmDatebase.getDatabase(context!!)
                var list = database?.alarmDao()?.getAllWithoutLive()
                if (list != null) {
                    for (alaram in list) {
                        if (alaram.is_enabled.equals("true", true)) {
                            if (alaram.mon.equals("true", true) || alaram.tues.equals(
                                    "true",
                                    true
                                ) || alaram.wed.equals("true", true) || alaram.thurs.equals(
                                    "true",
                                    true
                                ) || alaram.fri.equals("true", true) || alaram.sat.equals(
                                    "true",
                                    true
                                ) || alaram.sun.equals("true", true)
                            ) {

                                if (alaram.mon.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.MONDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                                if (alaram.tues.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.TUESDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                                if (alaram.wed.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.WEDNESDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                                if (alaram.thurs.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.THURSDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                                if (alaram.fri.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.FRIDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                                if (alaram.sat.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.SATURDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                                if (alaram.sun.equals("true", true)) {
                                    setrepeatingalaram(
                                        context,
                                        Calendar.SUNDAY,
                                        alaram.hour!!.toInt(),
                                        alaram.min!!.toInt(),
                                        alaram.alarmid.toString()
                                    )
                                }
                            } else {
                                setalaram(
                                    context,
                                    alaram.hour.toString().toInt(),
                                    alaram.min.toString().toInt(),
                                    alaram.alarmid.toString()
                                )
                            }
                        }
                    }

                }
            }

        }
    }

    fun setalaram(context: Context?, hour: Int, min: Int, alaramid: String) {

        var calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, min)
        calendar.set(Calendar.SECOND, 0)
        if (calendar.timeInMillis < Calendar.getInstance().timeInMillis) {
            calendar.add(Calendar.DATE, 1)
        }

        Log.i(
            "alaram",
            "(non-repating)${hour} : $min  alarm set for${calendar.time}"
        )


        val am =
            context?.applicationContext?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(context, AlarmBroadcast::class.java)
        i.putExtra("alarmid", alaramid);
        val pi =
            PendingIntent.getBroadcast(
                context,
                alaramid.toInt(),
                i,
                PendingIntent.FLAG_UPDATE_CURRENT
            )


        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pi)
    }

    fun setrepeatingalaram(context: Context?, dayno: Int, hour: Int, min: Int, alaramid: String) {

        var calendar = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, min)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.DAY_OF_WEEK, dayno)
        Log.i(
            "alaram",
            "(non-repating)${hour} : $min  alarm set for${calendar.time}"
        )

        val am =
            context?.applicationContext?.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        //creating a new intent specifying the broadcast receiver
        val i = Intent(context, AlarmBroadcast::class.java)
        i.putExtra("alarmid", alaramid);
        //creating a pending intent using the intent
        val pi =
            PendingIntent.getBroadcast(
                context,
                alaramid.toInt(),
                i,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, 24 * 60 * 60 * 1000, pi)
    }
}
