package com.scorpio.a_eye.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J>\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019J\u001a\u0010%\u001a\u00020\u00172\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020(0\'J\"\u0010)\u001a\u00020\u00172\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020(0\'2\u0006\u0010*\u001a\u00020+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/scorpio/a_eye/viewmodel/AppViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "captureImagePressed", "Landroidx/lifecycle/MutableLiveData;", "", "getCaptureImagePressed", "()Landroidx/lifecycle/MutableLiveData;", "currentScanningType", "", "getCurrentScanningType", "currentUser", "Lcom/scorpio/a_eye/model/Guide;", "getCurrentUser", "database", "Lcom/google/firebase/firestore/FirebaseFirestore;", "showAuthenticationStatus", "getShowAuthenticationStatus", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "getUserData", "", "email", "", "registerUser", "personName", "personAge", "gender", "guideName", "guidePhone", "guideEmail", "guidePassword", "resetUserPassword", "signInUser", "password", "updateData", "value", "Ljava/util/HashMap;", "", "uploadImageToDatabase", "uri", "Landroid/net/Uri;", "app_debug"})
public final class AppViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> currentScanningType = null;
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    private final com.google.firebase.firestore.FirebaseFirestore database = null;
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.scorpio.a_eye.model.Guide> currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> captureImagePressed = null;
    
    /**
     * 0 -> Login Success
     * 1 -> Login Failure
     *
     * 2 -> Register Success
     * 3 -> Register Failure
     *
     * 5 -> Editing Success
     * 6 -> Editing Failure
     *
     * 7 -> Reset Email Success
     * 8 -> Reset Email Failure
     */
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> showAuthenticationStatus = null;
    
    public AppViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentScanningType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.scorpio.a_eye.model.Guide> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getCaptureImagePressed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getShowAuthenticationStatus() {
        return null;
    }
    
    public final void signInUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void registerUser(@org.jetbrains.annotations.NotNull
    java.lang.String personName, @org.jetbrains.annotations.NotNull
    java.lang.String personAge, @org.jetbrains.annotations.NotNull
    java.lang.String gender, @org.jetbrains.annotations.NotNull
    java.lang.String guideName, @org.jetbrains.annotations.NotNull
    java.lang.String guidePhone, @org.jetbrains.annotations.NotNull
    java.lang.String guideEmail, @org.jetbrains.annotations.NotNull
    java.lang.String guidePassword) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final void getUserData(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.Object> value) {
    }
    
    public final void uploadImageToDatabase(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.Object> value, @org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    public final void resetUserPassword(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
}