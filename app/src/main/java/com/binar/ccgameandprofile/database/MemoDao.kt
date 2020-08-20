package com.binar.ccgameandprofile.database

import androidx.room.*

@Dao
interface MemoDao {

    @Query("SELECT * FROM Memo ORDER BY id DESC")
    fun getAllMemo(): List<Memo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(memo: Memo): Long

    @Update
    fun updateMemo(memo: Memo): Int

    @Delete
    fun deleteMemo(memo: Memo): Int

}