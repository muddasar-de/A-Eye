package com.scorpio.a_eye.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0016\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aH\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter$MyViewHolder;", "()V", "clickListener", "Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter$ClickListener;", "getClickListener", "()Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter$ClickListener;", "setClickListener", "(Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter$ClickListener;)V", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "tempList", "", "ClickListener", "MyViewHolder", "app_debug"})
public final class HistoryDetailsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.scorpio.a_eye.adapters.HistoryDetailsAdapter.MyViewHolder> {
    private java.util.ArrayList<java.lang.String> list;
    @org.jetbrains.annotations.Nullable
    private com.scorpio.a_eye.adapters.HistoryDetailsAdapter.ClickListener clickListener;
    
    public HistoryDetailsAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.scorpio.a_eye.adapters.HistoryDetailsAdapter.ClickListener getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.Nullable
    com.scorpio.a_eye.adapters.HistoryDetailsAdapter.ClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.scorpio.a_eye.adapters.HistoryDetailsAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.scorpio.a_eye.adapters.HistoryDetailsAdapter.MyViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tempList) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/scorpio/a_eye/databinding/LayoutHistoryDetailsItemBinding;", "(Lcom/scorpio/a_eye/databinding/LayoutHistoryDetailsItemBinding;)V", "getBinding", "()Lcom/scorpio/a_eye/databinding/LayoutHistoryDetailsItemBinding;", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.scorpio.a_eye.databinding.LayoutHistoryDetailsItemBinding binding = null;
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull
        com.scorpio.a_eye.databinding.LayoutHistoryDetailsItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.scorpio.a_eye.databinding.LayoutHistoryDetailsItemBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/scorpio/a_eye/adapters/HistoryDetailsAdapter$ClickListener;", "", "onClickListener", "", "app_debug"})
    public static abstract interface ClickListener {
        
        public abstract void onClickListener();
    }
}