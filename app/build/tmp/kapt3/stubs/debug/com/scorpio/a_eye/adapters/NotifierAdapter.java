package com.scorpio.a_eye.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/scorpio/a_eye/adapters/NotifierAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/scorpio/a_eye/adapters/NotifierAdapter$MyViewHolder;", "()V", "clickListener", "Lcom/scorpio/a_eye/adapters/NotifierAdapter$ClickListener;", "getClickListener", "()Lcom/scorpio/a_eye/adapters/NotifierAdapter$ClickListener;", "setClickListener", "(Lcom/scorpio/a_eye/adapters/NotifierAdapter$ClickListener;)V", "list", "", "Lcom/scorpio/a_eye/database/Alarm;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "tempList", "ClickListener", "MyViewHolder", "app_debug"})
public final class NotifierAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.scorpio.a_eye.adapters.NotifierAdapter.MyViewHolder> {
    private java.util.List<com.scorpio.a_eye.database.Alarm> list;
    @org.jetbrains.annotations.Nullable
    private com.scorpio.a_eye.adapters.NotifierAdapter.ClickListener clickListener;
    
    public NotifierAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.scorpio.a_eye.adapters.NotifierAdapter.ClickListener getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.Nullable
    com.scorpio.a_eye.adapters.NotifierAdapter.ClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.scorpio.a_eye.adapters.NotifierAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.adapters.NotifierAdapter.MyViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.scorpio.a_eye.database.Alarm> tempList) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/scorpio/a_eye/adapters/NotifierAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/scorpio/a_eye/databinding/LayoutNotifierItemBinding;", "(Lcom/scorpio/a_eye/databinding/LayoutNotifierItemBinding;)V", "getBinding", "()Lcom/scorpio/a_eye/databinding/LayoutNotifierItemBinding;", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.scorpio.a_eye.databinding.LayoutNotifierItemBinding binding = null;
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull
        com.scorpio.a_eye.databinding.LayoutNotifierItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.scorpio.a_eye.databinding.LayoutNotifierItemBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/scorpio/a_eye/adapters/NotifierAdapter$ClickListener;", "", "onLongClickListener", "", "pos", "", "alarm", "Lcom/scorpio/a_eye/database/Alarm;", "app_debug"})
    public static abstract interface ClickListener {
        
        public abstract void onLongClickListener(int pos, @org.jetbrains.annotations.NotNull
        com.scorpio.a_eye.database.Alarm alarm);
    }
}