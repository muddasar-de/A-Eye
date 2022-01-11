package com.scorpio.a_eye.ui.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u001b2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\u001dH\u0002J \u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0019H\u0002J\b\u00107\u001a\u00020)H\u0002J\b\u00108\u001a\u00020)H\u0002J\b\u00109\u001a\u00020)H\u0003J\b\u0010:\u001a\u00020)H\u0002J$\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020)H\u0016J \u0010D\u001a\u00020)2\u000e\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0F2\u0006\u0010H\u001a\u00020IH\u0002J(\u0010J\u001a\u00020)2\u000e\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0F2\u000e\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0LH\u0002J\u001a\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020\u001bH\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010R\u001a\u00020)2\b\b\u0002\u0010S\u001a\u00020\u0019H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010\u0010\u001a\u0004\b%\u0010&\u00a8\u0006U"}, d2 = {"Lcom/scorpio/a_eye/ui/fragment/MainFragment;", "Lcom/scorpio/a_eye/ui/fragment/BaseFragment;", "()V", "ORIENTATIONS", "Landroid/util/SparseIntArray;", "binding", "Lcom/scorpio/a_eye/databinding/FragmentMainBinding;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "captureFrameDialogBinding", "Lcom/scorpio/a_eye/databinding/DialogImageCaptureBinding;", "getCaptureFrameDialogBinding", "()Lcom/scorpio/a_eye/databinding/DialogImageCaptureBinding;", "captureFrameDialogBinding$delegate", "Lkotlin/Lazy;", "capturedFrameDialog", "Landroid/app/Dialog;", "getCapturedFrameDialog", "()Landroid/app/Dialog;", "capturedFrameDialog$delegate", "imageCapture", "Landroidx/camera/core/ImageCapture;", "isForObjects", "", "lastDeductObject", "", "outputDirectory", "Ljava/io/File;", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "progressDialog$delegate", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "getScanner", "()Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "scanner$delegate", "captureImage", "", "convert", "bitmap", "Landroid/graphics/Bitmap;", "decodeBitmap", "image", "Landroidx/camera/core/ImageProxy;", "getOutputDirectory", "getRotationCompensation", "", "cameraId", "activity", "Landroid/app/Activity;", "isFrontFacing", "init", "initDrawerListeners", "initListeners", "initObservers", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFailureResponse", "call", "Lretrofit2/Call;", "Lcom/scorpio/a_eye/services/ServerResponse;", "t", "", "onSuccessResponse", "response", "Lretrofit2/Response;", "onViewCreated", "view", "sendRequestToAPI", "base64String", "showCapturedFrameDialog", "startCamera", "startAnalyzer", "Companion", "app_debug"})
public final class MainFragment extends com.scorpio.a_eye.ui.fragment.BaseFragment {
    private com.scorpio.a_eye.databinding.FragmentMainBinding binding;
    private androidx.camera.core.ImageCapture imageCapture;
    private java.io.File outputDirectory;
    private java.util.concurrent.ExecutorService cameraExecutor;
    private androidx.camera.core.CameraSelector cameraSelector;
    private final kotlin.Lazy scanner$delegate = null;
    private final android.util.SparseIntArray ORIENTATIONS = null;
    private final kotlin.Lazy capturedFrameDialog$delegate = null;
    private final kotlin.Lazy captureFrameDialogBinding$delegate = null;
    private final kotlin.Lazy progressDialog$delegate = null;
    private boolean isForObjects = false;
    private java.lang.String lastDeductObject = "";
    @org.jetbrains.annotations.NotNull
    public static final com.scorpio.a_eye.ui.fragment.MainFragment.Companion Companion = null;
    private static final java.lang.String TAG = "CameraXBasic";
    private static final java.lang.String FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS";
    
    public MainFragment() {
        super();
    }
    
    private final com.google.mlkit.vision.barcode.BarcodeScanner getScanner() {
        return null;
    }
    
    private final android.app.Dialog getCapturedFrameDialog() {
        return null;
    }
    
    private final com.scorpio.a_eye.databinding.DialogImageCaptureBinding getCaptureFrameDialogBinding() {
        return null;
    }
    
    private final android.app.ProgressDialog getProgressDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void initListeners() {
    }
    
    private final void initObservers() {
    }
    
    private final void initDrawerListeners() {
    }
    
    @android.annotation.SuppressLint(value = {"UnsafeOptInUsageError"})
    private final void startCamera(boolean startAnalyzer) {
    }
    
    @android.annotation.SuppressLint(value = {"UnsafeOptInUsageError"})
    private final void captureImage() {
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
    
    private final java.io.File getOutputDirectory() {
        return null;
    }
    
    private final void sendRequestToAPI(java.lang.String base64String) {
    }
    
    private final void onSuccessResponse(retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> call, retrofit2.Response<com.scorpio.a_eye.services.ServerResponse> response) {
    }
    
    private final void onFailureResponse(retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> call, java.lang.Throwable t) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {android.hardware.camera2.CameraAccessException.class})
    private final int getRotationCompensation(java.lang.String cameraId, android.app.Activity activity, boolean isFrontFacing) throws android.hardware.camera2.CameraAccessException {
        return 0;
    }
    
    private final void showCapturedFrameDialog(android.graphics.Bitmap bitmap) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/scorpio/a_eye/ui/fragment/MainFragment$Companion;", "", "()V", "FILENAME_FORMAT", "", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}