package com.scorpio.a_eye.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.scorpio.a_eye.database.Alarm

@Dao
interface AlarmDao {
    @Query("SELECT * FROM Alarm ORDER BY id DESC")
    fun getAll(): LiveData<MutableList<Alarm>>

    @Query("SELECT * FROM Alarm ORDER BY id DESC")
    fun getAllWithoutLive(): MutableList<Alarm>

    @Insert
    fun insertAll(vararg users: Alarm)

    @Update
    fun updateAlarm(vararg users: Alarm)

    @Delete
    fun delete(user: Alarm)

    @Query("DELETE  FROM Alarm WHERE alarmid = :alaramid")
    fun deletealarm(alaramid: String): Unit

    @Query("SELECT * FROM Alarm WHERE alarmid = :alaramid")
    fun getalarm(alaramid: String): Alarm

    @Query("UPDATE Alarm SET is_enabled = :status  WHERE alarmid = :id ")
    fun updatealaramstatus(id: Int, status: String): Int

    @Query("SELECT EXISTS(SELECT * FROM Alarm WHERE time = :time And label= :name)")
    fun isAlarmIsExist(time: String, name: String): Boolean
}