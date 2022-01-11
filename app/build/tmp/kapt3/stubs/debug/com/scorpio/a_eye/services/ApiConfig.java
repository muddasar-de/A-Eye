package com.scorpio.a_eye.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/scorpio/a_eye/services/ApiConfig;", "", "colorDetection", "Lretrofit2/Call;", "Lcom/scorpio/a_eye/services/ServerResponse;", "data", "", "currencyDetection", "emotionDetection", "faceAdd", "faceDetection", "faceName", "objectDetection", "ocrDetection", "sceneDetection", "app_debug"})
public abstract interface ApiConfig {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/faceDetection")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> faceDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/objectDetection")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> objectDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/OCR")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> ocrDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/colorDetection")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> colorDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/currencyDetection")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> currencyDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/sceneDetection")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> sceneDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/emotionDetection")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> emotionDetection(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/faceAdd")
    @retrofit2.http.Headers(value = {"Content-Type: image/jpeg"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> faceAdd(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/faceName")
    @retrofit2.http.Headers(value = {"Content-Type: text/html"})
    public abstract retrofit2.Call<com.scorpio.a_eye.services.ServerResponse> faceName(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.lang.String data);
}