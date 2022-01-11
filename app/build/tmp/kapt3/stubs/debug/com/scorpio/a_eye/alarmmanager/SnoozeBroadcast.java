package com.scorpio.a_eye.alarmmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u001a\u001a\u00020\u0019J\u001c\u0010\u001b\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/scorpio/a_eye/alarmmanager/SnoozeBroadcast;", "Landroid/content/BroadcastReceiver;", "()V", "alaram", "Lcom/scorpio/a_eye/database/Alarm;", "getAlaram", "()Lcom/scorpio/a_eye/database/Alarm;", "setAlaram", "(Lcom/scorpio/a_eye/database/Alarm;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "notifyid", "", "getNotifyid", "()Ljava/lang/String;", "setNotifyid", "(Ljava/lang/String;)V", "Dateconverter", "date", "", "cancelnotification", "", "createSnozeNotification", "onReceive", "intent", "Landroid/content/Intent;", "setalaram", "app_debug"})
public final class SnoozeBroadcast extends android.content.BroadcastReceiver {
    public com.scorpio.a_eye.database.Alarm alaram;
    @org.jetbrains.annotations.Nullable
    private java.lang.String notifyid = "";
    public android.content.Context context;
    
    public SnoozeBroadcast() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.scorpio.a_eye.database.Alarm getAlaram() {
        return null;
    }
    
    public final void setAlaram(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.database.Alarm p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNotifyid() {
        return null;
    }
    
    public final void setNotifyid(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    private final void setalaram(android.content.Context context) {
    }
    
    public final void cancelnotification(@org.jetbrains.annotations.Nullable
    android.content.Context context) {
    }
    
    public final void createSnozeNotification() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String Dateconverter(long date) {
        return null;
    }
}