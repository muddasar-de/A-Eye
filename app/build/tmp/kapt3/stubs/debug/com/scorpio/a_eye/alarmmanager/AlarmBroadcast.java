package com.scorpio.a_eye.alarmmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/scorpio/a_eye/alarmmanager/AlarmBroadcast;", "Landroid/content/BroadcastReceiver;", "()V", "alaram", "Lcom/scorpio/a_eye/database/Alarm;", "getAlaram", "()Lcom/scorpio/a_eye/database/Alarm;", "setAlaram", "(Lcom/scorpio/a_eye/database/Alarm;)V", "generatenotification", "", "context", "Landroid/content/Context;", "onReceive", "intent", "Landroid/content/Intent;", "speakNotification", "message", "", "app_debug"})
public final class AlarmBroadcast extends android.content.BroadcastReceiver {
    public com.scorpio.a_eye.database.Alarm alaram;
    
    public AlarmBroadcast() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.scorpio.a_eye.database.Alarm getAlaram() {
        return null;
    }
    
    public final void setAlaram(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.database.Alarm p0) {
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    private final void generatenotification(android.content.Context context) {
    }
    
    private final void speakNotification(android.content.Context context, java.lang.String message) {
    }
}