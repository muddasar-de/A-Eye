package com.scorpio.a_eye.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Alarm::class], version = 1, exportSchema = false)
abstract class AlarmDatebase : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao

    companion object {
        private var INSTANCE: AlarmDatebase? = null
        fun getDatabase(context: Context): AlarmDatebase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AlarmDatebase::class.java, "aeyedb"
                )
                    .build()
            }
            return INSTANCE
        }
    }
}