package com.scorpio.a_eye.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\'J\u0010\u0010(\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0003J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0018\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0002J\b\u00100\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u00061"}, d2 = {"Lcom/scorpio/a_eye/ui/FaceTrainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ORIENTATIONS", "Landroid/util/SparseIntArray;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "Lcom/scorpio/a_eye/databinding/ActivityFaceTrainBinding;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "database", "Lcom/google/firebase/firestore/FirebaseFirestore;", "guideEmail", "", "imageCapture", "Landroidx/camera/core/ImageCapture;", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "progressDialog$delegate", "Lkotlin/Lazy;", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "getStorage", "()Lcom/google/firebase/storage/FirebaseStorage;", "setStorage", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "captureImage", "", "personName", "convert", "bitmap", "Landroid/graphics/Bitmap;", "decodeBitmap", "image", "Landroidx/camera/core/ImageProxy;", "firebaseUploadBitmap", "init", "initListeners", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "sendRequestToAPI", "base64String", "startCamera", "app_debug"})
public final class FaceTrainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.scorpio.a_eye.databinding.ActivityFaceTrainBinding binding;
    private androidx.camera.core.ImageCapture imageCapture;
    private java.util.concurrent.ExecutorService cameraExecutor;
    private androidx.camera.core.CameraSelector cameraSelector;
    private final android.util.SparseIntArray ORIENTATIONS = null;
    private final kotlin.Lazy progressDialog$delegate = null;
    @org.jetbrains.annotations.NotNull
    private com.google.firebase.storage.FirebaseStorage storage;
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    private final com.google.firebase.firestore.FirebaseFirestore database = null;
    private java.lang.String guideEmail = "";
    
    public FaceTrainActivity() {
        super();
    }
    
    private final android.app.ProgressDialog getProgressDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.storage.FirebaseStorage getStorage() {
        return null;
    }
    
    public final void setStorage(@org.jetbrains.annotations.NotNull
    com.google.firebase.storage.FirebaseStorage p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void initListeners() {
    }
    
    private final void startCamera() {
    }
    
    private final void captureImage(java.lang.String personName) {
    }
    
    private final void sendRequestToAPI(java.lang.String base64String, java.lang.String personName) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String convert(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap decodeBitmap(@org.jetbrains.annotations.NotNull
    androidx.camera.core.ImageProxy image) {
        return null;
    }
    
    private final void firebaseUploadBitmap(android.graphics.Bitmap bitmap) {
    }
}