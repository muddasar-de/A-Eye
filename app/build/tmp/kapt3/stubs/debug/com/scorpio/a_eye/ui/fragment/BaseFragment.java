package com.scorpio.a_eye.ui.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/scorpio/a_eye/ui/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appViewModel", "Lcom/scorpio/a_eye/viewmodel/AppViewModel;", "getAppViewModel", "()Lcom/scorpio/a_eye/viewmodel/AppViewModel;", "setAppViewModel", "(Lcom/scorpio/a_eye/viewmodel/AppViewModel;)V", "navOptions", "Landroidx/navigation/NavOptions;", "navigateToFragment", "", "actionId", "", "fragmentId", "bundle", "Landroid/os/Bundle;", "(Ljava/lang/Integer;ILandroid/os/Bundle;)V", "onCreate", "savedInstanceState", "showToast", "text", "", "app_debug"})
public class BaseFragment extends androidx.fragment.app.Fragment {
    public com.scorpio.a_eye.viewmodel.AppViewModel appViewModel;
    private final androidx.navigation.NavOptions navOptions = null;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.scorpio.a_eye.viewmodel.AppViewModel getAppViewModel() {
        return null;
    }
    
    public final void setAppViewModel(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.viewmodel.AppViewModel p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void navigateToFragment(@org.jetbrains.annotations.Nullable
    java.lang.Integer actionId, int fragmentId, @org.jetbrains.annotations.NotNull
    android.os.Bundle bundle) {
    }
    
    public final void showToast(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
}