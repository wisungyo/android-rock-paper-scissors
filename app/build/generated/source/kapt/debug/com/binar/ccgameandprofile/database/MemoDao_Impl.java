package com.binar.ccgameandprofile.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class MemoDao_Impl implements MemoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMemo;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMemo;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfMemo;

  public MemoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMemo = new EntityInsertionAdapter<Memo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Memo`(`id`,`tanggal`,`isiMemo`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Memo value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTanggal() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTanggal());
        }
        if (value.getIsiMemo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIsiMemo());
        }
      }
    };
    this.__deletionAdapterOfMemo = new EntityDeletionOrUpdateAdapter<Memo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Memo` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Memo value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfMemo = new EntityDeletionOrUpdateAdapter<Memo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Memo` SET `id` = ?,`tanggal` = ?,`isiMemo` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Memo value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTanggal() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTanggal());
        }
        if (value.getIsiMemo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIsiMemo());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
  }

  @Override
  public long insertMemo(Memo memo) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfMemo.insertAndReturnId(memo);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteMemo(Memo memo) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfMemo.handle(memo);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateMemo(Memo memo) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfMemo.handle(memo);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Memo> getAllMemo() {
    final String _sql = "SELECT * FROM Memo ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTanggal = _cursor.getColumnIndexOrThrow("tanggal");
      final int _cursorIndexOfIsiMemo = _cursor.getColumnIndexOrThrow("isiMemo");
      final List<Memo> _result = new ArrayList<Memo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Memo _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTanggal;
        _tmpTanggal = _cursor.getString(_cursorIndexOfTanggal);
        final String _tmpIsiMemo;
        _tmpIsiMemo = _cursor.getString(_cursorIndexOfIsiMemo);
        _item = new Memo(_tmpId,_tmpTanggal,_tmpIsiMemo);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
