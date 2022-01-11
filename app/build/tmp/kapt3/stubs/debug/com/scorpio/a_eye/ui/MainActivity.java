package com.scorpio.a_eye.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/scorpio/a_eye/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appViewModel", "Lcom/scorpio/a_eye/viewmodel/AppViewModel;", "binding", "Lcom/scorpio/a_eye/databinding/ActivityMainBinding;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFirebaseAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "loadingBinding", "Lcom/scorpio/a_eye/databinding/DialogLoadingBinding;", "getLoadingBinding", "()Lcom/scorpio/a_eye/databinding/DialogLoadingBinding;", "loadingBinding$delegate", "Lkotlin/Lazy;", "loadingDialog", "Landroid/app/Dialog;", "getLoadingDialog", "()Landroid/app/Dialog;", "loadingDialog$delegate", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showHideLoadingDialog", "show", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.scorpio.a_eye.databinding.ActivityMainBinding binding;
    public com.google.firebase.auth.FirebaseAuth firebaseAuth;
    private com.scorpio.a_eye.viewmodel.AppViewModel appViewModel;
    private final kotlin.Lazy loadingDialog$delegate = null;
    private final kotlin.Lazy loadingBinding$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    public final void setFirebaseAuth(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    private final android.app.Dialog getLoadingDialog() {
        return null;
    }
    
    private final com.scorpio.a_eye.databinding.DialogLoadingBinding getLoadingBinding() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void showHideLoadingDialog(boolean show) {
    }
    
    @java.lang.Override
    public boolean dispatchKeyEvent(@org.jetbrains.annotations.NotNull
    android.view.KeyEvent event) {
        return false;
    }
}