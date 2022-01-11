package com.scorpio.a_eye.voiceutils;

import java.lang.System;

@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0004J$\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0#J\u0016\u0010$\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\b\u0010\'\u001a\u00020\u001eH\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000202H\u0016J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006<"}, d2 = {"Lcom/scorpio/a_eye/voiceutils/VoiceAssistant;", "Landroid/speech/RecognitionListener;", "()V", "TAG", "", "appViewModel", "Lcom/scorpio/a_eye/viewmodel/AppViewModel;", "getAppViewModel", "()Lcom/scorpio/a_eye/viewmodel/AppViewModel;", "setAppViewModel", "(Lcom/scorpio/a_eye/viewmodel/AppViewModel;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "sr", "Landroid/speech/SpeechRecognizer;", "getSr", "()Landroid/speech/SpeechRecognizer;", "setSr", "(Landroid/speech/SpeechRecognizer;)V", "t1", "Landroid/speech/tts/TextToSpeech;", "getT1", "()Landroid/speech/tts/TextToSpeech;", "setT1", "(Landroid/speech/tts/TextToSpeech;)V", "announceCurrentCall", "", "context", "textToSpeak", "announceWithCallback", "complete", "Lkotlin/Function0;", "compareCommands", "resultList", "Ljava/util/ArrayList;", "onBeginningOfSpeech", "onBufferReceived", "buffer", "", "onEndOfSpeech", "onError", "error", "", "onEvent", "eventType", "params", "Landroid/os/Bundle;", "onPartialResults", "partialResults", "onReadyForSpeech", "onResults", "results", "onRmsChanged", "rmsdB", "", "startListening", "app_debug"})
public final class VoiceAssistant implements android.speech.RecognitionListener {
    @org.jetbrains.annotations.NotNull
    public static final com.scorpio.a_eye.voiceutils.VoiceAssistant INSTANCE = null;
    private static final java.lang.String TAG = "RecognitionListenerTest";
    @org.jetbrains.annotations.Nullable
    private static android.speech.tts.TextToSpeech t1;
    @org.jetbrains.annotations.Nullable
    private static com.scorpio.a_eye.viewmodel.AppViewModel appViewModel;
    @org.jetbrains.annotations.Nullable
    private static android.speech.SpeechRecognizer sr;
    @org.jetbrains.annotations.Nullable
    private static android.content.Context mContext;
    
    private VoiceAssistant() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.speech.tts.TextToSpeech getT1() {
        return null;
    }
    
    public final void setT1(@org.jetbrains.annotations.Nullable
    android.speech.tts.TextToSpeech p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.scorpio.a_eye.viewmodel.AppViewModel getAppViewModel() {
        return null;
    }
    
    public final void setAppViewModel(@org.jetbrains.annotations.Nullable
    com.scorpio.a_eye.viewmodel.AppViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.speech.SpeechRecognizer getSr() {
        return null;
    }
    
    public final void setSr(@org.jetbrains.annotations.Nullable
    android.speech.SpeechRecognizer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.Nullable
    android.content.Context p0) {
    }
    
    public final void announceCurrentCall(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String textToSpeak) {
    }
    
    public final void announceWithCallback(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String textToSpeak, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> complete) {
    }
    
    public final void startListening(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    private final void compareCommands(java.util.ArrayList<java.lang.String> resultList) {
    }
    
    @java.lang.Override
    public void onReadyForSpeech(@org.jetbrains.annotations.NotNull
    android.os.Bundle params) {
    }
    
    @java.lang.Override
    public void onBeginningOfSpeech() {
    }
    
    @java.lang.Override
    public void onRmsChanged(float rmsdB) {
    }
    
    @java.lang.Override
    public void onBufferReceived(@org.jetbrains.annotations.NotNull
    byte[] buffer) {
    }
    
    @java.lang.Override
    public void onEndOfSpeech() {
    }
    
    @java.lang.Override
    public void onError(int error) {
    }
    
    @java.lang.Override
    public void onResults(@org.jetbrains.annotations.NotNull
    android.os.Bundle results) {
    }
    
    @java.lang.Override
    public void onPartialResults(@org.jetbrains.annotations.NotNull
    android.os.Bundle partialResults) {
    }
    
    @java.lang.Override
    public void onEvent(int eventType, @org.jetbrains.annotations.NotNull
    android.os.Bundle params) {
    }
}