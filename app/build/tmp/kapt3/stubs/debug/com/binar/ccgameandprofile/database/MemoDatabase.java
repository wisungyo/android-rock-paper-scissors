package com.binar.ccgameandprofile.database;

import java.lang.System;

@androidx.room.Database(entities = {com.binar.ccgameandprofile.database.Memo.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/binar/ccgameandprofile/database/MemoDatabase;", "Landroidx/room/RoomDatabase;", "()V", "memoDao", "Lcom/binar/ccgameandprofile/database/MemoDao;", "Companion", "app_debug"})
public abstract class MemoDatabase extends androidx.room.RoomDatabase {
    private static com.binar.ccgameandprofile.database.MemoDatabase INSTANCE;
    public static final com.binar.ccgameandprofile.database.MemoDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.binar.ccgameandprofile.database.MemoDao memoDao();
    
    public MemoDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/binar/ccgameandprofile/database/MemoDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/binar/ccgameandprofile/database/MemoDatabase;", "destroyInstance", "", "getIntance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.binar.ccgameandprofile.database.MemoDatabase getIntance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void destroyInstance() {
        }
        
        private Companion() {
            super();
        }
    }
}