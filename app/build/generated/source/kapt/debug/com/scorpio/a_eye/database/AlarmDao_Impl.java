package com.scorpio.a_eye.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Alarm> __insertionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter<Alarm> __deletionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter<Alarm> __updateAdapterOfAlarm;

  private final SharedSQLiteStatement __preparedStmtOfDeletealarm;

  private final SharedSQLiteStatement __preparedStmtOfUpdatealaramstatus;

  public AlarmDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarm = new EntityInsertionAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Alarm` (`id`,`time`,`hour`,`mins`,`label`,`mon`,`tues`,`wed`,`thurs`,`fri`,`sat`,`sun`,`is_enabled`,`snooze`,`vibration`,`alarmid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
        if (value.getTime() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTime());
        }
        if (value.getHour() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHour());
        }
        if (value.getMin() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMin());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLabel());
        }
        if (value.getMon() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMon());
        }
        if (value.getTues() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTues());
        }
        if (value.getWed() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getWed());
        }
        if (value.getThurs() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getThurs());
        }
        if (value.getFri() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFri());
        }
        if (value.getSat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSat());
        }
        if (value.getSun() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSun());
        }
        if (value.is_enabled() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.is_enabled());
        }
        if (value.getSnooze() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSnooze());
        }
        if (value.getVibration() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVibration());
        }
        if (value.getAlarmid() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getAlarmid());
        }
      }
    };
    this.__deletionAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Alarm` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Alarm` SET `id` = ?,`time` = ?,`hour` = ?,`mins` = ?,`label` = ?,`mon` = ?,`tues` = ?,`wed` = ?,`thurs` = ?,`fri` = ?,`sat` = ?,`sun` = ?,`is_enabled` = ?,`snooze` = ?,`vibration` = ?,`alarmid` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
        if (value.getTime() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTime());
        }
        if (value.getHour() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHour());
        }
        if (value.getMin() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMin());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLabel());
        }
        if (value.getMon() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMon());
        }
        if (value.getTues() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTues());
        }
        if (value.getWed() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getWed());
        }
        if (value.getThurs() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getThurs());
        }
        if (value.getFri() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFri());
        }
        if (value.getSat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSat());
        }
        if (value.getSun() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSun());
        }
        if (value.is_enabled() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.is_enabled());
        }
        if (value.getSnooze() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSnooze());
        }
        if (value.getVibration() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getVibration());
        }
        if (value.getAlarmid() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getAlarmid());
        }
        stmt.bindLong(17, value.getId());
      }
    };
    this.__preparedStmtOfDeletealarm = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE  FROM Alarm WHERE alarmid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatealaramstatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Alarm SET is_enabled = ?  WHERE alarmid = ? ";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final Alarm... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlarm.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Alarm user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAlarm.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAlarm(final Alarm... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAlarm.handleMultiple(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletealarm(final String alaramid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletealarm.acquire();
    int _argIndex = 1;
    if (alaramid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, alaramid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletealarm.release(_stmt);
    }
  }

  @Override
  public int updatealaramstatus(final int id, final String status) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatealaramstatus.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdatealaramstatus.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Alarm>> getAll() {
    final String _sql = "SELECT * FROM Alarm ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Alarm"}, false, new Callable<List<Alarm>>() {
      @Override
      public List<Alarm> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMin = CursorUtil.getColumnIndexOrThrow(_cursor, "mins");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfMon = CursorUtil.getColumnIndexOrThrow(_cursor, "mon");
          final int _cursorIndexOfTues = CursorUtil.getColumnIndexOrThrow(_cursor, "tues");
          final int _cursorIndexOfWed = CursorUtil.getColumnIndexOrThrow(_cursor, "wed");
          final int _cursorIndexOfThurs = CursorUtil.getColumnIndexOrThrow(_cursor, "thurs");
          final int _cursorIndexOfFri = CursorUtil.getColumnIndexOrThrow(_cursor, "fri");
          final int _cursorIndexOfSat = CursorUtil.getColumnIndexOrThrow(_cursor, "sat");
          final int _cursorIndexOfSun = CursorUtil.getColumnIndexOrThrow(_cursor, "sun");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "is_enabled");
          final int _cursorIndexOfSnooze = CursorUtil.getColumnIndexOrThrow(_cursor, "snooze");
          final int _cursorIndexOfVibration = CursorUtil.getColumnIndexOrThrow(_cursor, "vibration");
          final int _cursorIndexOfAlarmid = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmid");
          final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Alarm _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final String _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getString(_cursorIndexOfHour);
            }
            final String _tmpMin;
            if (_cursor.isNull(_cursorIndexOfMin)) {
              _tmpMin = null;
            } else {
              _tmpMin = _cursor.getString(_cursorIndexOfMin);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final String _tmpMon;
            if (_cursor.isNull(_cursorIndexOfMon)) {
              _tmpMon = null;
            } else {
              _tmpMon = _cursor.getString(_cursorIndexOfMon);
            }
            final String _tmpTues;
            if (_cursor.isNull(_cursorIndexOfTues)) {
              _tmpTues = null;
            } else {
              _tmpTues = _cursor.getString(_cursorIndexOfTues);
            }
            final String _tmpWed;
            if (_cursor.isNull(_cursorIndexOfWed)) {
              _tmpWed = null;
            } else {
              _tmpWed = _cursor.getString(_cursorIndexOfWed);
            }
            final String _tmpThurs;
            if (_cursor.isNull(_cursorIndexOfThurs)) {
              _tmpThurs = null;
            } else {
              _tmpThurs = _cursor.getString(_cursorIndexOfThurs);
            }
            final String _tmpFri;
            if (_cursor.isNull(_cursorIndexOfFri)) {
              _tmpFri = null;
            } else {
              _tmpFri = _cursor.getString(_cursorIndexOfFri);
            }
            final String _tmpSat;
            if (_cursor.isNull(_cursorIndexOfSat)) {
              _tmpSat = null;
            } else {
              _tmpSat = _cursor.getString(_cursorIndexOfSat);
            }
            final String _tmpSun;
            if (_cursor.isNull(_cursorIndexOfSun)) {
              _tmpSun = null;
            } else {
              _tmpSun = _cursor.getString(_cursorIndexOfSun);
            }
            final String _tmpIs_enabled;
            if (_cursor.isNull(_cursorIndexOfIsEnabled)) {
              _tmpIs_enabled = null;
            } else {
              _tmpIs_enabled = _cursor.getString(_cursorIndexOfIsEnabled);
            }
            final String _tmpSnooze;
            if (_cursor.isNull(_cursorIndexOfSnooze)) {
              _tmpSnooze = null;
            } else {
              _tmpSnooze = _cursor.getString(_cursorIndexOfSnooze);
            }
            final String _tmpVibration;
            if (_cursor.isNull(_cursorIndexOfVibration)) {
              _tmpVibration = null;
            } else {
              _tmpVibration = _cursor.getString(_cursorIndexOfVibration);
            }
            final String _tmpAlarmid;
            if (_cursor.isNull(_cursorIndexOfAlarmid)) {
              _tmpAlarmid = null;
            } else {
              _tmpAlarmid = _cursor.getString(_cursorIndexOfAlarmid);
            }
            _item = new Alarm(_tmpId,_tmpTime,_tmpHour,_tmpMin,_tmpLabel,_tmpMon,_tmpTues,_tmpWed,_tmpThurs,_tmpFri,_tmpSat,_tmpSun,_tmpIs_enabled,_tmpSnooze,_tmpVibration,_tmpAlarmid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Alarm> getAllWithoutLive() {
    final String _sql = "SELECT * FROM Alarm ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
      final int _cursorIndexOfMin = CursorUtil.getColumnIndexOrThrow(_cursor, "mins");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfMon = CursorUtil.getColumnIndexOrThrow(_cursor, "mon");
      final int _cursorIndexOfTues = CursorUtil.getColumnIndexOrThrow(_cursor, "tues");
      final int _cursorIndexOfWed = CursorUtil.getColumnIndexOrThrow(_cursor, "wed");
      final int _cursorIndexOfThurs = CursorUtil.getColumnIndexOrThrow(_cursor, "thurs");
      final int _cursorIndexOfFri = CursorUtil.getColumnIndexOrThrow(_cursor, "fri");
      final int _cursorIndexOfSat = CursorUtil.getColumnIndexOrThrow(_cursor, "sat");
      final int _cursorIndexOfSun = CursorUtil.getColumnIndexOrThrow(_cursor, "sun");
      final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "is_enabled");
      final int _cursorIndexOfSnooze = CursorUtil.getColumnIndexOrThrow(_cursor, "snooze");
      final int _cursorIndexOfVibration = CursorUtil.getColumnIndexOrThrow(_cursor, "vibration");
      final int _cursorIndexOfAlarmid = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmid");
      final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Alarm _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        final String _tmpHour;
        if (_cursor.isNull(_cursorIndexOfHour)) {
          _tmpHour = null;
        } else {
          _tmpHour = _cursor.getString(_cursorIndexOfHour);
        }
        final String _tmpMin;
        if (_cursor.isNull(_cursorIndexOfMin)) {
          _tmpMin = null;
        } else {
          _tmpMin = _cursor.getString(_cursorIndexOfMin);
        }
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        final String _tmpMon;
        if (_cursor.isNull(_cursorIndexOfMon)) {
          _tmpMon = null;
        } else {
          _tmpMon = _cursor.getString(_cursorIndexOfMon);
        }
        final String _tmpTues;
        if (_cursor.isNull(_cursorIndexOfTues)) {
          _tmpTues = null;
        } else {
          _tmpTues = _cursor.getString(_cursorIndexOfTues);
        }
        final String _tmpWed;
        if (_cursor.isNull(_cursorIndexOfWed)) {
          _tmpWed = null;
        } else {
          _tmpWed = _cursor.getString(_cursorIndexOfWed);
        }
        final String _tmpThurs;
        if (_cursor.isNull(_cursorIndexOfThurs)) {
          _tmpThurs = null;
        } else {
          _tmpThurs = _cursor.getString(_cursorIndexOfThurs);
        }
        final String _tmpFri;
        if (_cursor.isNull(_cursorIndexOfFri)) {
          _tmpFri = null;
        } else {
          _tmpFri = _cursor.getString(_cursorIndexOfFri);
        }
        final String _tmpSat;
        if (_cursor.isNull(_cursorIndexOfSat)) {
          _tmpSat = null;
        } else {
          _tmpSat = _cursor.getString(_cursorIndexOfSat);
        }
        final String _tmpSun;
        if (_cursor.isNull(_cursorIndexOfSun)) {
          _tmpSun = null;
        } else {
          _tmpSun = _cursor.getString(_cursorIndexOfSun);
        }
        final String _tmpIs_enabled;
        if (_cursor.isNull(_cursorIndexOfIsEnabled)) {
          _tmpIs_enabled = null;
        } else {
          _tmpIs_enabled = _cursor.getString(_cursorIndexOfIsEnabled);
        }
        final String _tmpSnooze;
        if (_cursor.isNull(_cursorIndexOfSnooze)) {
          _tmpSnooze = null;
        } else {
          _tmpSnooze = _cursor.getString(_cursorIndexOfSnooze);
        }
        final String _tmpVibration;
        if (_cursor.isNull(_cursorIndexOfVibration)) {
          _tmpVibration = null;
        } else {
          _tmpVibration = _cursor.getString(_cursorIndexOfVibration);
        }
        final String _tmpAlarmid;
        if (_cursor.isNull(_cursorIndexOfAlarmid)) {
          _tmpAlarmid = null;
        } else {
          _tmpAlarmid = _cursor.getString(_cursorIndexOfAlarmid);
        }
        _item = new Alarm(_tmpId,_tmpTime,_tmpHour,_tmpMin,_tmpLabel,_tmpMon,_tmpTues,_tmpWed,_tmpThurs,_tmpFri,_tmpSat,_tmpSun,_tmpIs_enabled,_tmpSnooze,_tmpVibration,_tmpAlarmid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Alarm getalarm(final String alaramid) {
    final String _sql = "SELECT * FROM Alarm WHERE alarmid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (alaramid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, alaramid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
      final int _cursorIndexOfMin = CursorUtil.getColumnIndexOrThrow(_cursor, "mins");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfMon = CursorUtil.getColumnIndexOrThrow(_cursor, "mon");
      final int _cursorIndexOfTues = CursorUtil.getColumnIndexOrThrow(_cursor, "tues");
      final int _cursorIndexOfWed = CursorUtil.getColumnIndexOrThrow(_cursor, "wed");
      final int _cursorIndexOfThurs = CursorUtil.getColumnIndexOrThrow(_cursor, "thurs");
      final int _cursorIndexOfFri = CursorUtil.getColumnIndexOrThrow(_cursor, "fri");
      final int _cursorIndexOfSat = CursorUtil.getColumnIndexOrThrow(_cursor, "sat");
      final int _cursorIndexOfSun = CursorUtil.getColumnIndexOrThrow(_cursor, "sun");
      final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "is_enabled");
      final int _cursorIndexOfSnooze = CursorUtil.getColumnIndexOrThrow(_cursor, "snooze");
      final int _cursorIndexOfVibration = CursorUtil.getColumnIndexOrThrow(_cursor, "vibration");
      final int _cursorIndexOfAlarmid = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmid");
      final Alarm _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        final String _tmpHour;
        if (_cursor.isNull(_cursorIndexOfHour)) {
          _tmpHour = null;
        } else {
          _tmpHour = _cursor.getString(_cursorIndexOfHour);
        }
        final String _tmpMin;
        if (_cursor.isNull(_cursorIndexOfMin)) {
          _tmpMin = null;
        } else {
          _tmpMin = _cursor.getString(_cursorIndexOfMin);
        }
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        final String _tmpMon;
        if (_cursor.isNull(_cursorIndexOfMon)) {
          _tmpMon = null;
        } else {
          _tmpMon = _cursor.getString(_cursorIndexOfMon);
        }
        final String _tmpTues;
        if (_cursor.isNull(_cursorIndexOfTues)) {
          _tmpTues = null;
        } else {
          _tmpTues = _cursor.getString(_cursorIndexOfTues);
        }
        final String _tmpWed;
        if (_cursor.isNull(_cursorIndexOfWed)) {
          _tmpWed = null;
        } else {
          _tmpWed = _cursor.getString(_cursorIndexOfWed);
        }
        final String _tmpThurs;
        if (_cursor.isNull(_cursorIndexOfThurs)) {
          _tmpThurs = null;
        } else {
          _tmpThurs = _cursor.getString(_cursorIndexOfThurs);
        }
        final String _tmpFri;
        if (_cursor.isNull(_cursorIndexOfFri)) {
          _tmpFri = null;
        } else {
          _tmpFri = _cursor.getString(_cursorIndexOfFri);
        }
        final String _tmpSat;
        if (_cursor.isNull(_cursorIndexOfSat)) {
          _tmpSat = null;
        } else {
          _tmpSat = _cursor.getString(_cursorIndexOfSat);
        }
        final String _tmpSun;
        if (_cursor.isNull(_cursorIndexOfSun)) {
          _tmpSun = null;
        } else {
          _tmpSun = _cursor.getString(_cursorIndexOfSun);
        }
        final String _tmpIs_enabled;
        if (_cursor.isNull(_cursorIndexOfIsEnabled)) {
          _tmpIs_enabled = null;
        } else {
          _tmpIs_enabled = _cursor.getString(_cursorIndexOfIsEnabled);
        }
        final String _tmpSnooze;
        if (_cursor.isNull(_cursorIndexOfSnooze)) {
          _tmpSnooze = null;
        } else {
          _tmpSnooze = _cursor.getString(_cursorIndexOfSnooze);
        }
        final String _tmpVibration;
        if (_cursor.isNull(_cursorIndexOfVibration)) {
          _tmpVibration = null;
        } else {
          _tmpVibration = _cursor.getString(_cursorIndexOfVibration);
        }
        final String _tmpAlarmid;
        if (_cursor.isNull(_cursorIndexOfAlarmid)) {
          _tmpAlarmid = null;
        } else {
          _tmpAlarmid = _cursor.getString(_cursorIndexOfAlarmid);
        }
        _result = new Alarm(_tmpId,_tmpTime,_tmpHour,_tmpMin,_tmpLabel,_tmpMon,_tmpTues,_tmpWed,_tmpThurs,_tmpFri,_tmpSat,_tmpSun,_tmpIs_enabled,_tmpSnooze,_tmpVibration,_tmpAlarmid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean isAlarmIsExist(final String time, final String name) {
    final String _sql = "SELECT EXISTS(SELECT * FROM Alarm WHERE time = ? And label= ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (time == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, time);
    }
    _argIndex = 2;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
