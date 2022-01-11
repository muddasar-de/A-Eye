package com.scorpio.a_eye.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J!\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0010\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\'J!\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0010\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bH\'\u00a8\u0006\u001b"}, d2 = {"Lcom/scorpio/a_eye/database/AlarmDao;", "", "delete", "", "user", "Lcom/scorpio/a_eye/database/Alarm;", "deletealarm", "alaramid", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "getAllWithoutLive", "getalarm", "insertAll", "users", "", "([Lcom/scorpio/a_eye/database/Alarm;)V", "isAlarmIsExist", "", "time", "name", "updateAlarm", "updatealaramstatus", "", "id", "status", "app_debug"})
public abstract interface AlarmDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Alarm ORDER BY id DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.scorpio.a_eye.database.Alarm>> getAll();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Alarm ORDER BY id DESC")
    public abstract java.util.List<com.scorpio.a_eye.database.Alarm> getAllWithoutLive();
    
    @androidx.room.Insert
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.database.Alarm... users);
    
    @androidx.room.Update
    public abstract void updateAlarm(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.database.Alarm... users);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.database.Alarm user);
    
    @androidx.room.Query(value = "DELETE  FROM Alarm WHERE alarmid = :alaramid")
    public abstract void deletealarm(@org.jetbrains.annotations.NotNull
    java.lang.String alaramid);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Alarm WHERE alarmid = :alaramid")
    public abstract com.scorpio.a_eye.database.Alarm getalarm(@org.jetbrains.annotations.NotNull
    java.lang.String alaramid);
    
    @androidx.room.Query(value = "UPDATE Alarm SET is_enabled = :status  WHERE alarmid = :id ")
    public abstract int updatealaramstatus(int id, @org.jetbrains.annotations.NotNull
    java.lang.String status);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM Alarm WHERE time = :time And label= :name)")
    public abstract boolean isAlarmIsExist(@org.jetbrains.annotations.NotNull
    java.lang.String time, @org.jetbrains.annotations.NotNull
    java.lang.String name);
}