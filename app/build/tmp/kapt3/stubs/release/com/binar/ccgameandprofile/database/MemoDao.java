package com.binar.ccgameandprofile.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/binar/ccgameandprofile/database/MemoDao;", "", "deleteMemo", "", "memo", "Lcom/binar/ccgameandprofile/database/Memo;", "getAllMemo", "", "insertMemo", "", "updateMemo", "app_release"})
public abstract interface MemoDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Memo ORDER BY id DESC")
    public abstract java.util.List<com.binar.ccgameandprofile.database.Memo> getAllMemo();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract long insertMemo(@org.jetbrains.annotations.NotNull()
    com.binar.ccgameandprofile.database.Memo memo);
    
    @androidx.room.Update()
    public abstract int updateMemo(@org.jetbrains.annotations.NotNull()
    com.binar.ccgameandprofile.database.Memo memo);
    
    @androidx.room.Delete()
    public abstract int deleteMemo(@org.jetbrains.annotations.NotNull()
    com.binar.ccgameandprofile.database.Memo memo);
}