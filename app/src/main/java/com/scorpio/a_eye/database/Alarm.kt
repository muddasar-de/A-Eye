package com.scorpio.a_eye.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Alarm(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "time") val time: String?,
    @ColumnInfo(name = "hour") val hour: String?,
    @ColumnInfo(name = "mins") val min: String?,
    @ColumnInfo(name = "label") val label: String?,
    @ColumnInfo(name = "mon") val mon: String?,
    @ColumnInfo(name = "tues") val tues: String?,
    @ColumnInfo(name = "wed") val wed: String?,
    @ColumnInfo(name = "thurs") val thurs: String?,
    @ColumnInfo(name = "fri") val fri: String?,
    @ColumnInfo(name = "sat") val sat: String?,
    @ColumnInfo(name = "sun") val sun: String?,
    @ColumnInfo(name = "is_enabled") val is_enabled: String?,
    @ColumnInfo(name = "snooze") val snooze: String?,
    @ColumnInfo(name = "vibration") val vibration: String?,
    @ColumnInfo(name = "alarmid") val alarmid: String?
)